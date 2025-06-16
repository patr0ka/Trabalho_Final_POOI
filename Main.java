import java.util.Scanner;
import maps.*;

public class Main {
    public static void main(String[] args) {
        boolean isAtivo = true;
        int jogadorDaVez = 1;
        HiddenBoard tabuleiroOculto1 = new HiddenBoard();
        HiddenBoard tabuleiroOculto2 = new HiddenBoard();
        PlayerBoard tabuleiroDoJogador1 = new PlayerBoard();
        PlayerBoard tabuleiroDoJogador2 = new PlayerBoard();

        Player player1 = new Player();
        Player player2 = new Player();

        try (Scanner sc = new Scanner(System.in)) {

            // <==== FASE DE PREPARAÇÂO ===>
            System.out.print("Insira o nome do jogador 1: ");
            player1.setNome(sc.next());
            System.out.print("Insira o nome do jogador 2: ");
            player2.setNome(sc.next());

            System.out.println("\nJogador 1, selecione os locais dos navios!");
            tabuleiroOculto1.insereNoTabuleiro(sc, tabuleiroDoJogador1);

            // player2
            System.out.println("\nJogador 2, selecione os locais dos navios!");
            tabuleiroOculto2.insereNoTabuleiro(sc, tabuleiroDoJogador2);
            System.out.println();
            System.out.println("====== INÍCIO DA BATALHA! ======");

            // <=== FASE DE BATALHA ===>

            while (isAtivo) {
                boolean acertou = true;
                int oponente = (jogadorDaVez == 1) ? 2 : 1;

                if (oponente == 1) {
                    System.out.println("\n--- Vez de " + player2.getNome() + " ---");
                    System.out.println("  Seu tabuleiro de tiros");
                    while (acertou) { 
                        tabuleiroDoJogador2.imprimeTabluleiroNoJogo();
                        System.out.println("Escolha as coordenadas para atacar!!!");

                        System.out.print("Linha (1-10):");
                        int x = sc.nextInt();
                        System.out.print("Coluna (A- J):");
                        char y = Character.toUpperCase(sc.next().trim().charAt(0));

                        acertou = tabuleiroDoJogador2.bombardear(x, y);
                    }                
                    jogadorDaVez = 2;                    
                    isAtivo = false;
                } else {
                    System.out.println("\n--- Vez de " + player1.getNome() + " ---");
                    System.out.println("  Seu tabuleiro de tiros");
                    while (acertou) { 
                        tabuleiroDoJogador1.imprimeTabluleiroNoJogo();
                        System.out.println("Escolha as coordenadas para atacar!!!");

                        System.out.print("Linha (1-10):");
                        int x = sc.nextInt();
                        System.out.print("Coluna (A- J):");
                        char y = Character.toUpperCase(sc.next().trim().charAt(0));

                        acertou = tabuleiroDoJogador1.bombardear(x, y);
                    }                
                    jogadorDaVez = 1;                    
                    isAtivo = false;
                }
            }
            
        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }
    }
}            