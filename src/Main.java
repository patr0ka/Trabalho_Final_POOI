import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Insira o nome do Jogador 1:");
            String nome1 = sc.next();
            System.out.println("Insira o nome do Jogador 2:");
            String nome2 = sc.next();

            Jogador J1 = new Jogador(nome1);
            Jogador J2 = new Jogador(nome2);

            Navio PortaAvioesJ1 = new PortaAvioes();
            Navio PortaAvioesJ2 = new PortaAvioes();
            Navio TorpedeiroJ1 = new ContraTorpedeiro();
            Navio TorpedeiroJ2 = new ContraTorpedeiro();
            Navio Submarino1J1 = new Submarino();
            Navio Submarino2J1 = new Submarino();
            Navio Submarino1J2 = new Submarino();
            Navio Submarino2J2 = new Submarino();
            Navio Patrulheiro1J1 = new Patrulheiro();
            Navio Patrulheiro2J1 = new Patrulheiro();
            Navio Patrulheiro3J1 = new Patrulheiro();
            Navio Patrulheiro1J2 = new Patrulheiro();
            Navio Patrulheiro2J2 = new Patrulheiro();
            Navio Patrulheiro3J2 = new Patrulheiro();
        }
        catch(Exception exception){
            System.out.println("Ocorreu um erro: " + exception.getMessage());
        }
        finally {
            System.out.println("Jogo finalizado.");
        }
    }
}
