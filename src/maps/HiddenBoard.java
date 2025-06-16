package maps;

import fleet.Navio;
import fleet.Posicao;
import java.util.Locale;
import java.util.Scanner;
import playerQueues.PlayersVesselQueue;
import playerQueues.VesselQueue;

public class HiddenBoard extends Board<Integer> {

    private static final int BOARD_SIZE = 10;
    private final PlayersVesselQueue playerVessel = new VesselQueue();

    public HiddenBoard() {
        super(Integer.class);
        // Inicializa tudo com 0
        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                setValor(i, j, 0);
            }
        }
    }

    @Override
    public void imprimeTabluleiro() {
        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                System.out.print(getTabuleiro()[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* ======== MÉTODOS AUXILIARES DE LEITURA E VALIDAÇÃO ======== */

    /**
     * verificação de entrada que verifica o input até que se encaixe no padrão exigido.
     * @param sc scanner usado para ler input no terminal.
     * @return retorna o eixo escolhido pelo jogador.
     */
    private char lerEixo(Scanner sc) {
        char eixo;
        do {
            System.out.print("Orientacao (H)orizontal ou (V)ertical: ");
            eixo = Character.toUpperCase(sc.next().trim().charAt(0));
        } while (eixo != 'H' && eixo != 'V');
        return eixo;
    }

    /**
     * verificação de entrada que verifica o input até que se encaixe no padrão exigido.
     * @param sc scanner usado para ler o input do terminal.
     * @param maxInclusive variavel que muda de acordo com o tamanho do barco para impedir posicionamentos que causariam IndexOutOfBounds.
     * @return retorna a linha escolhida -1, já que o index do vetor começa em 0.
     */
    private int lerLinha(Scanner sc, int maxInclusive) {
        int linha = -1;
        do {
            System.out.printf(Locale.ROOT, "Linha (1-%d): ", maxInclusive);
            if (sc.hasNextInt()) {
                linha = sc.nextInt();
            } else {
                sc.next();
            }
        } while (linha < 1 || linha > maxInclusive);
        return linha - 1;
    }

    /**
     * verificação de entrada que verifica o input até que se encaixe no padrão exigido.
     * @param sc scanner usado para ler o input do terminal.
     * @param maxInclusive variavel que muda de acordo com o tamanho do barco para impedir posicionamentos que causariam IndexOutOfBounds.
     * @return retorna a coluna escolhida.
     */
    private int lerColuna(Scanner sc, int maxInclusive) {
        char c;
        int coluna;
        do {
            System.out.printf(Locale.ROOT, "Coluna (A-%c): ", (char) ('A' + maxInclusive - 1));
            c = Character.toUpperCase(sc.next().trim().charAt(0));
            coluna = c - 'A';
        } while (coluna < 0 || coluna >= maxInclusive);
        return coluna;
    }

    /* ======== VALIDAÇÕES DE ESPAÇO LIVRE ======== */

    /**
     * Verifica se um navio pode ser posicionado horizontalmente no tabuleiro a partir de uma coordenada inicial.
     * @param linha   O índice da linha onde a peça será colocada.
     * @param colIni  A coluna inicial para o posicionamento da peça.
     * @param tamanho Tamanho do navio que vai ser posicionado.
     * @return Retorna true ou false dependendo se cabe ou não.
     */
    private boolean cabeHorizontal(int linha, int colIni, int tamanho) {
        if (colIni + tamanho > BOARD_SIZE) return false;
        for (int c = colIni; c < colIni + tamanho; c++) {
            if (getValor(linha, c) != 0) return false;
        }
        return true;
    }

    /**
     * Verifica se um navio pode ser posicionado e verticalmente no tabuleiro a partir de uma coordenada inicial.
     * @param linIni  A linha inicial para o posicionamento da peça.
     * @param coluna  O índice da coluna onde a peça será colocada.
     * @param tamanho Tamanho do navio que vai ser posicionado.
     * @return Retorna true ou false dependendo se cabe ou não.
     */
    private boolean cabeVertical(int linIni, int coluna, int tamanho) {
        if (linIni + tamanho > BOARD_SIZE) return false;
        for (int l = linIni; l < linIni + tamanho; l++) {
            if (getValor(l, coluna) != 0) return false;
        }
        return true;
    }

    /* ======== POSICIONAMENTO NO TABULEIRO ======== */

    private void colocaHorizontal(int linha, int colIni, Posicao navio, PlayerBoard pb) {
        for (int i = 0; i < navio.getNavio().getVida(); i++) {
            setValor(linha, colIni + i, 1);
            pb.setCoordenadasPlayerBoard(linha, colIni + i, navio);
        }
    }

    private void colocaVertical(int linIni, int coluna, Posicao navio, PlayerBoard pb) {
        for (int i = 0; i < navio.getNavio().getVida(); i++) {
            setValor(linIni + i, coluna, 1);
            pb.setCoordenadasPlayerBoard(linIni + i, coluna, navio);
        }
    }

    /* ======== MÉTODO PRINCIPAL ======== */



    /**
     * Sobrescreve o metodo de inserção no tabuleiro para implementar uma lógica
     * interativa de posicionamento de navios, guiada pelo usuário.
     * <p>
     * O metodo percorre uma fila de navios pendentes ({@code playerVessel}). Para cada
     * navio, ele realiza o seguinte ciclo:
     * <ol>
     * <li>Exibe o tabuleiro atual para o jogador.</li>
     * <li>Informa qual navio deve ser colocado e seu tamanho.</li>
     * <li>Lê a orientação desejada (Horizontal ou Vertical) do usuário.</li>
     * <li>Entra em um loop que solicita as coordenadas até que uma posição
     * válida seja fornecida.</li>
     * <li>Valida se o navio cabe nos limites do tabuleiro e não se sobrepõe a
     * outros navios já posicionados.</li>
     * <li>Uma vez que uma posição válida é informada, o navio é colocado no
     * tabuleiro e removido da fila de alocação.</li>
     * </ol>
     * O processo se repete até que todos os navios da frota do jogador
     * tenham sido posicionados.
     *
     * @param sc A instância do {@code Scanner} para ler as entradas do
     * usuário (orientação e coordenadas) a partir do console.
     * @param playerBoard O tabuleiro visível do jogador, que é atualizado e exibido
     * a cada navio posicionado para fornecer uma forma de visualização para o jogador.
     */
    @Override
    public void insereNoTabuleiro(Scanner sc, PlayerBoard playerBoard) {
        while (!playerVessel.emptyQueue()) {
            Navio navio = playerVessel.getElement();
            Posicao barco = new Posicao();
            barco.setNavio(navio);
            
            playerBoard.imprimeTabluleiro();
            System.out.printf("Alocar navio (%s) tamanho (%d).%n", navio.getNome(), navio.getVida());

            char eixo = lerEixo(sc);

            boolean colocado = false;
            while (!colocado) {
                if (eixo == 'H') {
                    int linha = lerLinha(sc, BOARD_SIZE);
                    int colIni = lerColuna(sc, BOARD_SIZE - navio.getVida() + 1);

                    if (cabeHorizontal(linha, colIni, navio.getVida())) {
                        colocaHorizontal(linha, colIni, barco, playerBoard);
                        colocado = true;
                    }
                    else {
                        System.out.println("Espaço insuficiente, tente outra posicao.");
                    }
                } else { // eixo == 'V'
                    int coluna = lerColuna(sc, BOARD_SIZE);
                    int linIni = lerLinha(sc, BOARD_SIZE - navio.getVida() + 1);

                    if (cabeVertical(linIni, coluna, navio.getVida())) {
                        colocaVertical(linIni, coluna, barco, playerBoard);
                        colocado = true;
                    } else {
                        System.out.println("Espaço insuficiente, tente outra posicao.");
                    }
                }
            }
            playerVessel.removeElement();
        }
    }
}
