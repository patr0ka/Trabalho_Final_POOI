import java.util.Scanner;
import maps.HiddenBoard;
import maps.PlayerBoard;
import fleet.Navio;

public class BatalhaNaval {

    public static boolean bombardeio(int linha, int coluna, HiddenBoard oponenteOculto, PlayerBoard atacanteVisivel) {
        Navio navioAtingido = oponenteOculto.getValor(linha, coluna);
        if (navioAtingido != null && !atacanteVisivel.getValor(linha, coluna).equals("X")) {
            System.out.println("FOGO! Acertou!");
            atacanteVisivel.setValor(linha, coluna, "X");
            navioAtingido.setVida(navioAtingido.getVida() - 1);
            if (navioAtingido.getVida() == 0) {
                System.out.println("O " + navioAtingido.getNome() + "afundou!");
                // Aqui você pode adicionar lógica para contar navios afundados.
            }
            return true;
        } else {
            System.out.println("ÁGUA!");
            if (!atacanteVisivel.getValor(linha, coluna).equals("X")) {
                atacanteVisivel.setValor(linha, coluna, "O");
            }
            return false;
        }
    }


    public static void main(String[] args) {
        HiddenBoard[] tabuleirosOcultos = new HiddenBoard[2];
        PlayerBoard[] tabuleirosDosJogadores = new PlayerBoard[2];
        Player[] players = new Player[2];
        boolean isAtivo = true;
        int jogadorDaVez = 0;

        try (Scanner sc = new Scanner(System.in)) {
            // --- FASE DE PREPARAÇÃO ---
            for (int i = 0; i < 2; i++) {
                players[i] = new Player();
                System.out.print("Insira o nome do Jogador " + (i + 1) + ": ");
                players[i].setNome(sc.next());
                players[i].setId(i + 1);

                tabuleirosOcultos[i] = new HiddenBoard();
                tabuleirosOcultos[i].insereNoTabuleiro(sc);
                tabuleirosDosJogadores[i] = new PlayerBoard();
                System.out.println("\n\n\n\n\n\n");
            }

            // --- FASE DE BATALHA ---
            System.out.println("====== INÍCIO DA BATALHA! ======");
            while (isAtivo) {
                int oponente = (jogadorDaVez == 0) ? 1 : 0;
                System.out.println("\n--- Vez de " + players[jogadorDaVez].getNome() + " ---");
                System.out.println("Seu tabuleiro de tiros:");
                tabuleirosDosJogadores[jogadorDaVez].imprimeTabluleiro();

                // Lógica para pedir coordenada de ataque
                System.out.print("Digite a coordenada para bombardear (Ex: A5): ");
                String coord = sc.next().toUpperCase();
                int col = coord.charAt(0) - 'A';
                int line = Integer.parseInt(coord.substring(1)) - 1;

                // Lógica de validação da coordenada (se está no tabuleiro)

                boolean acertou = bombardeio(line, col, tabuleirosOcultos[oponente], tabuleirosDosJogadores[jogadorDaVez]);

                // Lógica de condição de vitória
                // if (jogadorOponentePerdeu) {
                //    System.out.println(players[jogadorDaVez].getNome() + " VENCEU O JOGO!");
                //    jogoAtivo = false;
                // }

                // Troca o turno se o jogador não acertar
                if (!acertou) {
                    jogadorDaVez = oponente;
                } else {
                    System.out.println("Você acertou! Jogue novamente.");
                }
            }

        } catch (Exception exception) {
            System.out.println("Ocorreu um erro inesperado: " + exception.getMessage());
        } finally {
            System.out.println("Jogo finalizado.");
        }
    }
}