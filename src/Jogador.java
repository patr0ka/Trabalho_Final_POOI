public class Jogador{
    private String nome;
    private int pontos;

    public Jogador(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome1){
        nome = nome1;
    }

    public int getPontos(){
        return pontos;
    }

    public void setPontos(int pontos1){
        pontos = pontos1;
    }

}