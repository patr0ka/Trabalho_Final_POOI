package mapas;
public abstract class Tabuleiro<T> {
    private int linha , coluna;
    private T[][] tabuleiro;

    @SuppressWarnings("unchecked") /*Fala para o compilador ignorar o aviso gerado pela declaração do array genérico */
    public Tabuleiro(Class<T> tipo) {
        this.linha = 10;
        this.coluna = 10;
        this.tabuleiro = (T[][]) java.lang.reflect.Array.newInstance(tipo, linha, coluna); /*Devido as limitações do java é necessário usar essa notação para criar um array generico */
    }

    public abstract  void imprimeTabluleiro();

    public void setValor(int i , int j , T valor) {
        tabuleiro[i][j] = valor;
    }
    public T getValor(int i, int j) {
        return tabuleiro[i][j];
    }
    public T[][] getTabuleiro() {
        return tabuleiro;
    }
    public int getLinha() {
        return linha;
    }
    public int getColuna() {
        return coluna;
    }
}