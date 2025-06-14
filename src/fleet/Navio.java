package fleet;
public class Navio {
    private int vida;
    private final String nome;

    public Navio(String nome, int vida){
        this.nome = nome;
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public int getVida(){
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void isDestruido() {
        if (vida == 0) {
            System.out.println(nome + " está destruído.");
        } else {
            System.out.println(nome + " ainda está inteiro.");
        }
    }
}