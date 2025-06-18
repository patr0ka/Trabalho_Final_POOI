import Exceptions.InvalidNameException;

public class Player{
    private String nome;
    private int pontos;

    public Player(){}

    public Player(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) throws InvalidNameException{
        if (nome.trim().isEmpty()) {
            throw new InvalidNameException("Nome do jogador não pode estar vazio.");
        } else {
            this.nome = nome;
        }
    }

    public int getPontos(){
        return pontos;
    }

    public void setPontos(int pontos){
        this.pontos = pontos;
    }
}