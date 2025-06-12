package mapas;

public class TabuleiroOculto extends Tabuleiro<Integer>{
    public TabuleiroOculto() {
        super(Integer.class);
        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                setValor(i , j , 0);
            }
        }
    }
    @Override
    public void imprimeTabluleiro() {
        for(int i = 0; i < getLinha(); i++) {
            for(int j = 0; j < getColuna(); j++) {
                System.out.print(getTabuleiro()[i][j] + " ");
            }
            System.out.println();
        }
    }
}