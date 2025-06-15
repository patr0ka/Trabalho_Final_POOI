package maps;

import fleet.Navio;
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

    private char lerEixo(Scanner sc) {
        char eixo;
        do {
            System.out.print("Orientacao (H)orizontal ou (V)ertical: ");
            eixo = Character.toUpperCase(sc.next().trim().charAt(0));
        } while (eixo != 'H' && eixo != 'V');
        return eixo;
    }

    private int lerLinha(Scanner sc, int maxInclusive) {
        int linha;
        do {
            System.out.printf(Locale.ROOT, "Linha (1-%d): ", maxInclusive);
            linha = sc.nextInt();
        } while (linha < 1 || linha > maxInclusive);
        return linha - 1;
    }

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

    private boolean cabeHorizontal(int linha, int colIni, int tamanho) {
        if (colIni + tamanho > BOARD_SIZE) return false;
        for (int c = colIni; c < colIni + tamanho; c++) {
            if (getValor(linha, c) != 0) return false;
        }
        return true;
    }

    private boolean cabeVertical(int linIni, int coluna, int tamanho) {
        if (linIni + tamanho > BOARD_SIZE) return false;
        for (int l = linIni; l < linIni + tamanho; l++) {
            if (getValor(l, coluna) != 0) return false;
        }
        return true;
    }

    /* ======== POSICIONAMENTO NO TABULEIRO ======== */

    private void colocaHorizontal(int linha, int colIni, Navio navio, PlayerBoard pb) {
        for (int i = 0; i < navio.getVida(); i++) {
            setValor(linha, colIni + i, 1);
            pb.setCoordenadasPlayerBoard(linha, colIni + i, navio);
        }
    }

    private void colocaVertical(int linIni, int coluna, Navio navio, PlayerBoard pb) {
        for (int i = 0; i < navio.getVida(); i++) {
            setValor(linIni + i, coluna, 1);
            pb.setCoordenadasPlayerBoard(linIni + i, coluna, navio);
        }
    }

    /* ======== MÉTODO PRINCIPAL ======== */

    @Override
    public void insereNoTabuleiro(Scanner sc, PlayerBoard playerBoard) {
        while (!playerVessel.emptyQueue()) {
            Navio navio = playerVessel.getElement();
            playerBoard.imprimeTabluleiro();
            System.out.printf("%nAlocar navio (%s) tamanho (%d).%n", navio.getNome(), navio.getVida());

            char eixo = lerEixo(sc);

            boolean colocado = false;
            while (!colocado) {
                if (eixo == 'H') {
                    int linha = lerLinha(sc, BOARD_SIZE);
                    int colIni = lerColuna(sc, BOARD_SIZE - navio.getVida() + 1);

                    if (cabeHorizontal(linha, colIni, navio.getVida())) {
                        colocaHorizontal(linha, colIni, navio, playerBoard);
                        colocado = true;
                    }
                    else {
                        System.out.println("Espaço insuficiente, tente outra posicao.");
                    }
                } else { // eixo == 'V'
                    int coluna = lerColuna(sc, BOARD_SIZE);
                    int linIni = lerLinha(sc, BOARD_SIZE - navio.getVida() + 1);

                    if (cabeVertical(linIni, coluna, navio.getVida())) {
                        colocaVertical(linIni, coluna, navio, playerBoard);
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
