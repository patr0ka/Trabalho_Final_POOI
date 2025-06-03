public class Navio {
    private int vida;
    private final String nome;

    public Navio(String Nome, int vida){
        this.nome = getNome();
        this.vida = getVida();
    }

    public String getNome() {
        return nome;
    }

    public int getVida(){
        return vida;
    }

    public void setVida(int vida1){
        vida = vida1;
    }

    public int tomarDano(){
        if(vida==1){

        }
        vida--;
        setVida(vida);
        return vida;
    }

    public void isDestruido() {
        if (vida <= 0) {
            System.out.println(nome + " está destruído.");
        } else {
            System.out.println(nome + " ainda está inteiro.");
        }
    }

}
