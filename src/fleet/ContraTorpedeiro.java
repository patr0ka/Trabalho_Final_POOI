package fleet;

public class ContraTorpedeiro extends Navio{
    public ContraTorpedeiro(){
        super("Contra Torpedeiro",4);
    }

    @Override
    public String toString(){
        return  "Você destruiu um navio: (" + getNome() + ").";
    }
}