public enum Embarcacoes {
    Porta_Aviao(1), Contra_Torpedeiro(1), Submarinos(2), Patrulheiros(3);

    private final int quantidade;

    Embarcacoes(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

