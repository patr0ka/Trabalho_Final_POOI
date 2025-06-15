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
    public void imprimeTabluleiro() {

        /* ---------- cabeçalho (A-J, A-Z etc.) ---------- */
        System.out.print("   ");                       // três espaços p/ alinhar com os números
        for (int j = 0; j < getColuna(); j++) {
            char letra = (char) ('A' + j);            // A, B, C…
            System.out.printf(" %c", letra);
        }
        System.out.println();                         // quebra de linha depois do cabeçalho

        /* ---------- corpo do tabuleiro ---------- */
        for (int i = 0; i < getLinha(); i++) {

            System.out.printf("%2d ", i + 1);         // número da linha, alinhado à direita

            for (int j = 0; j < getColuna(); j++) {
                Navio navio = getValor(i, j);

                char simbolo = (navio == null) ? '~' : navio.getInicial();
                System.out.printf(" %c", simbolo);
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