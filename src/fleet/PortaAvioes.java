package fleet;

public class PortaAvioes extends Navio{
    public PortaAvioes(){
        super("Porta Avioes",5);
    }

    @Override
    public String toString(){
        return  "Você destruiu um navio: (" + getNome() + ").";
    }
}