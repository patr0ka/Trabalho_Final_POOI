package maps;
import fleet.Navio;
import fleet.Posicao;

public class PlayerBoard extends Board<Posicao>{
    public PlayerBoard() {
        super(Posicao.class);

        for (int i = 0; i < getLinha(); i++) {
            for (int j = 0; j < getColuna(); j++) {
                Posicao p = new Posicao();
                p.setNavio(null);
                setValor(i , j , p);
            }
        }
    }

    public void setValorCoordenada(int linha, int coluna, Posicao novoValor){
        this.setValor(linha, coluna, novoValor);
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
                Navio navio = this.getValor(i, j).getNavio();

                char simbolo = (navio == null) ? '~' : navio.getInicial();
                System.out.printf(" %c", simbolo);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void imprimeTabluleiroNoJogo() {
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
                boolean foiAtingido = getValor(i, j).isAtingido();

                if (foiAtingido) {
                    System.out.print(" X");
                } else {
                    System.out.print(" ~");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public void setCoordenadasPlayerBoard(int x, int y, Posicao navio) {
        setValor(x, y, navio);
    }

    /**
     * Essa função verifica se a posição escolhida para ser bombardeada é válida, e se era um navio ou água.
     * @param x Linha escolhida para ser bombardeada.
     * @param j Coluna escolhida para ser bombaredeada.
     * @return retorna true caso tenha acertado um navio, e false caso tenha sido na água.
     */
    public boolean bombardear(int x, char j) {
        int y = j - 'A';
        Navio navio = this.getValor(x-1, y).getNavio();
        if (navio != null) {
            this.getValor(x-1, y).marcarComoAtingido();
            this.getValor(x-1, y).getNavio().tomarDano();
            this.getValor(x-1, y).setNavio(null);
            System.out.println("\n!!!VOCÊ ATINGIU UMA EMBARCAÇÃO!!!\n");
            return true;
        } else {
            System.out.println("\n!!ERROU!!\n");
            this.getValor(x-1, y).marcarComoAtingido();
            return false;
        }
    }
}