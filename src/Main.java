import java.util.Scanner;
import maps.HiddenBoard;
import maps.PlayerBoard;

public class Main {
    public static void main(String[] args) {
        HiddenBoard[] tabuleiroOculto = new HiddenBoard[2];
        PlayerBoard[] tabuleiroDoJogador = new PlayerBoard[2];
        Player[] players = new Player[2];

        try (Scanner sc = new Scanner(System.in)) {
            for(int i = 0; i < 1; i++) {
                players[i] = new Player();
                System.out.print("Insira o nome do Jogador " + (i+1) + ":");
                players[i].setNome(sc.next());
                players[i].setId(i+1);

                tabuleiroOculto[i] = new HiddenBoard();
                tabuleiroOculto[i].insereNoTabuleiro(sc);
                tabuleiroDoJogador[i] = new PlayerBoard();
                tabuleiroDoJogador[i].insereNoTabuleiro(tabuleiroOculto[i]);
            }

            tabuleiroOculto[0].imprimeTabluleiro();
            tabuleiroDoJogador[0].imprimeTabluleiro();
        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }
        finally {
            System.out.println("Jogo finalizado.");
        }
    }
}