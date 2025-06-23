import Exceptions.InvalidNameException;
import fleet.Embarcacoes;
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
        Embarcacoes[] navios = Embarcacoes.values();

        System.out.println("                            ██████╗░░█████╗░████████╗░█████╗░██╗░░░░░██╗░░██╗░█████╗    ███╗░░██╗░█████╗░██╗░░░██╗░█████╗░██╗░░░░░\n" +
                "                            ██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██║░░░░░██║░░██║██╔══██╗   ████╗░██║██╔══██╗██║░░░██║██╔══██╗██║░░░░░\n" +
                "                            ██████╦╝███████║░░░██║░░░███████║██║░░░░░███████║███████║   ██╔██╗██║███████║╚██╗░██╔╝███████║██║░░░░░\n" +
                "                            ██╔══██╗██╔══██║░░░██║░░░██╔══██║██║░░░░░██╔══██║██╔══██║   ██║╚████║██╔══██║░╚████╔╝░██╔══██║██║░░░░░\n" +
                "                            ██████╦╝██║░░██║░░░██║░░░██║░░██║███████╗██║░░██║██║░░██║   ██║░╚███║██║░░██║░░╚██╔╝░░██║░░██║███████╗\n" +
                "                            ╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝   ╚═╝░░╚══╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚══════╝\n");


        System.out.println("Seja bem-vindo(a) a Batalha Naval!");
        System.out.println("Sua frota é composta de:");
        for(Embarcacoes todosOsNavios : navios){
            System.out.println("-> " + todosOsNavios.getQuantidade() + " " + todosOsNavios);
        }
        System.out.println();
        try (Scanner sc = new Scanner(System.in)) {

            // <==== FASE DE PREPARAÇÂO ===>
            try {
                System.out.println("<=== Insira o nome do jogador 1 ===>");
                System.out.print("-> ");
                player1.setNome(sc.next()); //Exception sendo usado dento do metodo set.
                System.out.println("<=== Insira o nome do jogador 2 ===>");
                System.out.print("-> ");
                player2.setNome(sc.next());
            } catch(InvalidNameException e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.println("\n <=== " + player1.getNome() + ", selecione os locais dos navios! ===>");
            tabuleiroOculto1.insereNoTabuleiro(sc, tabuleiroDoJogador1);

            // player2
            System.out.println("\n <=== " + player2.getNome() + ", selecione os locais dos navios! ===>");
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
                        tabuleiroDoJogador1.imprimeTabluleiroNoJogo();
                        System.out.println("Escolha as coordenadas para atacar!!!");

                        System.out.print("Linha (1-10):");
                        int x = sc.nextInt();
                        System.out.print("Coluna (A- J):");
                        char y = Character.toUpperCase(sc.next().trim().charAt(0));

                        acertou = tabuleiroDoJogador1.bombardear(x, y);
                        if (acertou) {
                            player2.setPontos();
                        }
                        if (player2.getPontos() == 21) {
                            isAtivo = false;
                        }
                    }                
                    jogadorDaVez = 1;
                } else {
                    System.out.println("\n--- Vez de " + player1.getNome() + " ---");
                    System.out.println("  Seu tabuleiro de tiros");
                    while (acertou) { 
                        tabuleiroDoJogador2.imprimeTabluleiroNoJogo();
                        System.out.println("Escolha as coordenadas para atacar!!!");

                        System.out.print("Linha (1-10):");
                        int x = sc.nextInt();
                        System.out.print("Coluna (A- J):");
                        char y = Character.toUpperCase(sc.next().trim().charAt(0));

                        acertou = tabuleiroDoJogador2.bombardear(x, y);
                        if (acertou) {
                            player1.setPontos();
                        }
                        if (player1.getPontos() == 20) {
                            isAtivo = false;
                        }
                    }                
                    jogadorDaVez = 2;
                }
            }
            if (player1.getPontos() == 20) {
                System.out.println("O jogador: (" +player1.getNome()+ ") !!!GANHOU!!! com: (" +player1.getPontos()+"). PONTOS.");
                System.out.println("Jogador: (" +player2.getNome()+ ") ficou com: (" +player2.getPontos()+ "). Pontos.");
            }
        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }
    }
}            