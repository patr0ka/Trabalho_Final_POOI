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

    /**
     * @return Esse metodo retorna a primeira letra do nome do navio em UpperCase, por exemplo, Contra Torpedeiro retorna um "C".
     */
    public char getInicial(){
        return Character.toUpperCase(nome.charAt(0));
    }

    public void tomarDano() {
        this.vida--;
    }
}