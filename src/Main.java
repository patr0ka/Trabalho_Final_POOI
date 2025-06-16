import java.util.Scanner;

import fleet.Navio;
import maps.*;

public class Main {
    public static void main(String[] args) {
        boolean isAtivo = true;
        int jogadorDaVez = 0;
        HiddenBoard tabuleiroOculto1 = new HiddenBoard();
        HiddenBoard tabuleiroOculto2 = new HiddenBoard();
        PlayerBoard tabuleiroDoJogador1 = new PlayerBoard();
        PlayerBoard tabuleiroDoJogador2 = new PlayerBoard();

        Player player1 = new Player();
        Player player2 = new Player();

        try (Scanner sc = new Scanner(System.in)) {

            // <==== FASE DE PREPARAÇÂO ===>
            System.out.println("Insira o nome do jogador 1: ");
            player1.setNome(sc.next());
            System.out.println("Insira o nome do jogador 2: ");
            player2.setNome(sc.next());

            System.out.println("Jogador 1, selecione os locais dos navios!");
            tabuleiroOculto1.insereNoTabuleiro(sc, tabuleiroDoJogador1);

            // player2
            System.out.println("Jogador 2, selecione os locais dos navios!");
            tabuleiroOculto2.insereNoTabuleiro(sc, tabuleiroDoJogador2);

            System.out.println("====== INÍCIO DA BATALHA! ======");

            // <=== FASE DE BATALHA ===>
            while (isAtivo) {
                int oponente = (jogadorDaVez == 0) ? 1 : 0;
                System.out.println("\n--- Vez de " + player1.getNome() + " ---");
                System.out.println("Seu tabuleiro de tiros:");
                tabuleiroDoJogador1.imprimeTabluleiro();

                System.out.print("Digite a coordenada para bombardear (Ex: A5): ");

                String coord = sc.next().toUpperCase();
                int coluna = coord.charAt(0) - 'A';
                int linha = Integer.parseInt(coord.substring(1)) - 1;

                // Lógica de validação da coordenada (se está no tabuleiro)

                boolean acertou = bombardeio(linha, coluna, tabuleirosOcultos[oponente], tabuleirosDosJogadores[jogadorDaVez]);

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
        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }


    }
}