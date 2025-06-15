package maps;

public class PlayerBoard extends Board<String>{

    public PlayerBoard() {
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

    public void insereNoTabuleiro(HiddenBoard hiddenBoard) {
        for (int i = 1; i < getLinha(); i++) {
            for (int j = 1; j < getColuna(); j ++) {
                if (hiddenBoard.getValor(i, j) == 1) {
                    setValor(i, j, "B");
                }
            }
        }
    }
}