import java.util.Scanner;
import mapas.TabuleiroDoJogador;
import mapas.TabuleiroOculto;

public class Main {
    public static void main(String[] args) {
        TabuleiroOculto tabuleiroOculto1 = new TabuleiroOculto();
        tabuleiroOculto1.imprimeTabluleiro();
        TabuleiroDoJogador tabuleiroDoJogador = new TabuleiroDoJogador();
        tabuleiroDoJogador.imprimeTabluleiro();

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Insira o nome do Jogador 1:");
            String nome1 = sc.next();
            System.out.println("Insira o nome do Jogador 2:");
            String nome2 = sc.next();

            Jogador J1 = new Jogador(nome1);
            Jogador J2 = new Jogador(nome2);

        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }
        finally {
            System.out.println("Jogo finalizado.");
        }
    }
}