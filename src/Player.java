public class Player{
    private String nome;
    private int id;
    private int pontos;

    public Player(){}

    public Player(String nome, int id){
        this.id = id;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getPontos(){
        return pontos;
    }

    public void setPontos(int pontos){
        this.pontos = pontos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}