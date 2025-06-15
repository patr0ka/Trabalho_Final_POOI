import java.util.Scanner;
import maps.*;

public class Main {
    public static void main(String[] args) {
        HiddenBoard tabuleiroOculto1 = new HiddenBoard();
        HiddenBoard tabuleiroOculto2 = new HiddenBoard();
        PlayerBoard tabuleiroDoJogador1 = new PlayerBoard();
        PlayerBoard tabuleiroDoJogador2 = new PlayerBoard();

        Player player1 = new Player();
        Player player2 = new Player();

        try (Scanner sc = new Scanner(System.in)) {

            
            System.out.println("Insira o nome do jogador 1: ");
            player1.setNome(sc.next());
            System.out.println("Insira o nome do jogador 2: ");
            player2.setNome(sc.next());

            System.out.println("Jogador 1, selecione os locais dos navios!");
            tabuleiroOculto1.insereNoTabuleiro(sc, tabuleiroDoJogador1);

            // player2
            System.out.println("Jogador 2, selecione os locais dos navios!");
            tabuleiroOculto2.insereNoTabuleiro(sc, tabuleiroDoJogador2);   
            
        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }
        finally {
            System.out.println("Jogo finalizado.");
        }
    }
}