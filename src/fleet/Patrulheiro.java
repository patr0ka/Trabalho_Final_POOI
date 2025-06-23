package fleet;

public class Patrulheiro extends Navio{
    public Patrulheiro(){
        super("Patrulheiro", 2);
    }

    @Override
    public String toString(){
        return  "Você destruiu um navio: (" + getNome() + ").";
    }
}