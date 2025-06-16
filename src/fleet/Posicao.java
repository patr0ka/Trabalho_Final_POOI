package fleet;

public class Posicao {
    private Navio navio;
    private boolean foiAtingido = false;

    public Navio getNavio() {
        return navio;
    }

    public void setNavio(Navio navio) {
        this.navio = navio;
    }

    public boolean isAtingido() {
        return foiAtingido;
    }

    public void marcarComoAtingido() {
        this.foiAtingido = true;
    }

    public void tomarDano() {
        navio.tomarDano();
    }
}