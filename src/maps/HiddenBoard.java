package maps;
import fleet.Navio;
import java.util.Scanner;
import playerQueues.PlayersVesselQueue;
import playerQueues.VesselQueue;

public class HiddenBoard extends Board<Integer>{
    private final PlayersVesselQueue playerVessel = new VesselQueue();
    private boolean posicaoInvalida;

    public HiddenBoard() {
        super(Integer.class);
        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                setValor(i , j , 0);
            }
        }
    }
    @Override
    public void imprimeTabluleiro() {
        for(int i = 0; i < getLinha(); i++) {
            for(int j = 0; j < getColuna(); j++) {
                System.out.print(getTabuleiro()[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void insereNoTabuleiro(Scanner sc, PlayerBoard playerBoard) {
        String eixo;
        int lines;
        int coluns;

        while (!playerVessel.emptyQueue()) {
            Navio navio = playerVessel.getElement();

            System.out.print("Voce tem um navio do tipo (" + navio.getNome() + "), que tem o tamanho (" + navio.getVida() + ") para alocar. \nVoce deseja colocalo na Horizontala(H), ou na Vertical(V):");
            
            do { 
                eixo = sc.next();
                if (!eixo.equalsIgnoreCase("H") && !eixo.equalsIgnoreCase("V")) {
                    System.out.print("Entrada invalida tente novamente (H) ou (V):");
                }
            } while (!eixo.equalsIgnoreCase("H") && !eixo.equalsIgnoreCase("V"));
            
            System.out.println();
            playerBoard.imprimeTabluleiro();

            if (eixo.equalsIgnoreCase("H")) {
                System.out.print("Agora escolha as coordenadas do navio. Escolha uma linha de (1) a (10):");
                posicaoInvalida = true;
                do {
                    lines = sc.nextInt();
                    if (lines > 10 || lines < 1) {
                        System.out.print("Entrada invalida tente novamente de (0) ate (10):");
                    }

                    boolean encontrouEspaco = false;
                    for (int i = 0; i <= 10 - navio.getVida(); i++) {
                        if (validLine(lines, i, navio.getVida())) {
                            encontrouEspaco = true;
                            break;
                        }
                    }
                    if (!encontrouEspaco) {
                        System.out.print("Essa linha está cheia ou sem espaço suficiente. Escolha outra de (1) ate (10):");
                    } else {
                        posicaoInvalida = false;
                    }
                } while (posicaoInvalida);

                // Transforma a coordenada valida em um char;
                char character = (char)((10 - navio.getVida()) + 64);
                char indice = character;

                System.out.print("Escolha uma coluda de (A) até (" + indice + "):");

                do { 
                    posicaoInvalida = false;
                    character = sc.next().charAt(0);
                    coluns = (int)(character - 64);
                    if (coluns > (int)(indice - 64) || coluns < 1 || !validColum(lines, coluns, navio.getVida())) {
                        posicaoInvalida = true;
                        System.out.print("Entrada invalida tente novamente de (A) ate (" + indice + "):");
                    }
                } while (posicaoInvalida);

                System.out.println();

                if (!posicaoInvalida) {
                    for (int i = 0; i < navio.getVida(); i++) {
                        setValor(lines-1, i, 1);
                        playerBoard.setCoordenadasPlayerBoard(lines-1, i, navio);
                    }
                    playerVessel.removeElement();
                }

            } else {
                char character;
                System.out.print("Agora escolha as coordenadas do navio. Escolha uma linha de (A) ate (J):");
                posicaoInvalida = true;
                do { 
                    character = sc.next().charAt(0);
                    coluns = (int)(character - 64);

                    if (coluns > 10 || coluns < 1) {
                        System.out.print("Entrada invalida tente novamente de (A) ate (J):");
                    }

                    boolean encontrouEspaco = false;
                    for (int i = 0; i <= 10 - navio.getVida(); i++) {
                        if (validColum(i, coluns, navio.getVida())) {
                            encontrouEspaco = true;
                            break;
                        }
                    }
                    if (!encontrouEspaco) {
                        System.out.print("Essa coluna está cheia ou sem espaço suficiente. Escolha outra de (A) ate (J):");
                    } else {
                        posicaoInvalida = false;
                    }
                } while (posicaoInvalida);

                int indice = 10 - navio.getVida();
                System.out.print("Agora escolha as coordenadas do navio. Escolha uma linha de (1) ate (" + (indice) + "):");
                do {
                    posicaoInvalida = false; 
                    lines = sc.nextInt();
                    if (lines > indice || lines < 1 || !validColum(lines, coluns, navio.getVida())) {
                        posicaoInvalida = true;
                        System.out.print("Entrada invalida tente novamente de (1) ate (" + indice + "):");
                    }
                } while (posicaoInvalida);

                System.out.println();

                if (!posicaoInvalida) {
                    for (int i = 0; i < navio.getVida(); i++) {
                        setValor(i, coluns-1, 1);
                        playerBoard.setCoordenadasPlayerBoard(i, coluns, navio);
                    }
                    playerVessel.removeElement();
                }
            }
        }    
    }
}