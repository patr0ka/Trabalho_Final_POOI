package fleet;
import maps.PlayerBoard;
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

    public void getInicial(PlayerBoard playerBoard){
        for(int i = 0; i < playerBoard.getLinha(); i++){
            System.out.printf("%2d", i+1);
            for(int j = 0; j < playerBoard.getColuna(); j++){
                Navio navio = playerBoard.getValor(i, j);
                if(navio == null){
                    System.out.print("~");
                }
                else{
                    System.out.print(navio.getNome().charAt(0) + " ");
                }
            }
        }
    }
}

