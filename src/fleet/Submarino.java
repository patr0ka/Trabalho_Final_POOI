package fleet;

public class Submarino extends Navio{
    public Submarino(){
        super("Submarino",3);
    }

    @Override
    public String toString(){
        return  "Você destruiu um navio: (" + getNome() + ").";
    }
}