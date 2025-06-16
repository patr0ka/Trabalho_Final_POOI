package maps;
import java.util.Scanner;

public abstract class Board<T> {
    private final  int linha = 10, coluna = 10;
    private final T[][] tabuleiro;

    @SuppressWarnings("unchecked") /*Fala para o compilador ignorar o aviso gerado pela declaração do array genérico */
    public Board(Class<T> tipo) {
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

    public boolean validLine(int linha, int coluna, int tamanhoDoBarco) {
        T[][] board = this.getTabuleiro(); // usa o próprio tabuleiro
        if((coluna + tamanhoDoBarco)>10){
            return false;
        }
        else{
            for (int i = coluna; i < coluna + tamanhoDoBarco; i++) {
                if (board[linha][i].equals(1)) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean validColum(int linha, int coluna, int tamanhoDoBarco) {
        T[][] board = this.getTabuleiro(); // usa o próprio tabuleiro
        if((linha + tamanhoDoBarco)>10){
            return false;
        }
        else{
            for (int i = linha; i < linha + tamanhoDoBarco; i++) {
                if (board[i][coluna].equals(1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void insereNoTabuleiro(Scanner sc, PlayerBoard playerBoard){};
}