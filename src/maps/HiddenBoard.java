package maps;
import fleet.Navio;
import java.util.Scanner;
import playerQueues.PlayersVesselQueue;
import playerQueues.VesselQueue;

public class HiddenBoard extends Board<Navio>{
    private final PlayersVesselQueue playerVessel = new VesselQueue();

    public HiddenBoard() {
        super(Navio.class);
        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                setValor(i , j , null);
            }
        }
    }
    @Override
    public void imprimeTabluleiro() {
        System.out.print("   ");
        for(int j=0; j< getColuna(); j++){
            System.out.print((char)('A' + j) + " ");
        }
        System.out.println();

        for(int i=0; i<getLinha(); i++){
            System.out.printf("%2d", i+1);

            for(int j=0; j<getColuna(); j++){
                Navio navio = getValor(i, j);

                if(navio == null){
                    System.out.print("~ ");
                } else{
                    System.out.print(navio.getNome().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }


    @Override
    public void insereNoTabuleiro(Scanner sc) {
        String eixo;
        int line; // Armazenará o índice da linha (0-9)
        int col;  // Armazenará o índice da coluna (0-9)


        while (!playerVessel.emptyQueue()) {
            Navio navio = playerVessel.getElement();

            System.out.println("\n-----------------------------------------------------");
            System.out.print("Jogador, posicione seu navio: " + navio.getNome() + " (tamanho: " + navio.getVida() + ")");
            System.out.print("\nOrientação Horizontal(H) ou Vertical(V)?: ");

            // Loop para obter a orientação
            while (true) {
                eixo = sc.next().toUpperCase();
                if (eixo.equals("H") || eixo.equals("V")) {
                    break;
                }
                System.out.print("Entrada inválida. Tente novamente (H ou V): ");
            }

            // Loop principal para obter coordenadas válidas
            while(true) {
                System.out.print("Digite a coordenada inicial (Ex: A5, C10): ");
                try {
                    String coordInput = sc.next().toUpperCase();
                    col = coordInput.charAt(0) - 'A'; // 'A' -> 0, 'B' -> 1, etc.
                    line = Integer.parseInt(coordInput.substring(1)) - 1; // "5" -> 4, "10" -> 9

                    // Validação unificada
                    if (line < 0 || line > 9 || col < 0 || col > 9) {
                        System.out.println("Coordenada fora do tabuleiro. Tente novamente.");
                        continue;
                    }

                    if (eixo.equals("H")) {
                        if (col + navio.getVida() > 10) {
                            System.out.println("O navio não cabe aqui (ultrapassa a borda direita).");
                            continue;
                        }
                        if (validLine(line, col, navio.getVida())) {
                            for (int i = 0; i < navio.getVida(); i++) {
                                setValor(line, col + i, navio);
                            }
                            break; // Sucesso, sai do loop de coordenadas
                        }
                    } else { // Vertical
                        if (line + navio.getVida() > 10) {
                            System.out.println("O navio não cabe aqui (ultrapassa a borda inferior).");
                            continue;
                        }
                        if (validColum(line, col, navio.getVida())) {
                            for (int i = 0; i < navio.getVida(); i++) {
                                setValor(line + i, col, navio);
                            }
                            break; // Sucesso, sai do loop de coordenadas
                        }
                    }

                    // Se chegou aqui, a posição já está ocupada
                    System.out.println("Posição já ocupada. Escolha outra coordenada.");

                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println("Formato de coordenada inválido. Use LetraNúmero (Ex: A1, B2).");
                }
            }
            playerVessel.removeElement();
            System.out.println("Navio " + navio.getNome() + " posicionado! Tabuleiro atual:");
            imprimeTabluleiro();
        }
        System.out.println("\nTodos os navios foram posicionados!");
    }
}