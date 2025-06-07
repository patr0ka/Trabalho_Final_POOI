package mapas;

public class TabuleiroDoJogador extends Tabuleiro{
    public TabuleiroDoJogador() {
        super(String.class);

        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                setValor(i , j , "~");
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
