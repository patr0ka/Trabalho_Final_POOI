package maps;
import fleet.Navio;

public class PlayerBoard extends Board<Navio>{

    public PlayerBoard() {
        super(Navio.class);

        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                setValor(i , j , null);
            }
        }
    }
    
    @Override
    public void imprimeTabluleiro(){

        for(int i = 0; i < getLinha(); i++) {
            for(int j = 0; j < getColuna(); j++) {
                System.out.print(getTabuleiro()[i][j] == null ? "~" : getInicial());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setCoordenadasPlayerBoard(int x, int y, Navio navio) {
        setValor(x, y, navio);
    }
 
    public void insereNoTabuleiro(HiddenBoard hiddenBoard) {
        for (int i = 1; i < getLinha(); i++) {
            for (int j = 1; j < getColuna(); j ++) {
                if (hiddenBoard.getValor(i, j) == 1) {
                    setValor(i, j, null);
                }
            }
        }
    }
}