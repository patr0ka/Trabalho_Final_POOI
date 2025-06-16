package maps;
import java.util.Scanner;

public abstract class Board<T> {
    private final  int linha = 10, coluna = 10;
    private final T[][] tabuleiro;

    /**
     * Constrói um novo tabuleiro com dimensões pré-definidas.
     * Utiliza reflect para instanciar um array de tipo genérico, uma vez que o Java
     * não permite a criação direta (ex: new T[10][10]). A anotação @SuppressWarnings("unchecked")
     * é necessária para evitar o aviso gerado pelo compilador.
     *
     * @param tipo O objeto Class do tipo genérico T, necessário para a criação da matriz.
     */
    @SuppressWarnings("unchecked")
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

    /**
     * Esse metodo verifica se a linha escolhida é valida.
     * @param linha A linha escolhida da matriz.
     * @param coluna A coluna escolhida da matriz.
     * @param tamanhoDoBarco O tamanho do barco que vai ser colocado na matriz.
     * @return Retorna true ou false para dizer se a posição é valida.
     */
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