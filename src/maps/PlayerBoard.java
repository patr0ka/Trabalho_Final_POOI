package maps;
import fleet.ContraTorpedeiro;
import fleet.Navio;
import fleet.Patrulheiro;
import fleet.PortaAvioes;
import fleet.Posicao;
import fleet.Submarino;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
        System.out.print("   ");                
        for (int j = 0; j < getColuna(); j++) {
            char letra = (char) ('A' + j);            
            System.out.printf(" %c", letra);
        }
        System.out.println();

        /* ---------- corpo do tabuleiro ---------- */
        for (int i = 0; i < getLinha(); i++) {
            System.out.printf("%2d ", i + 1);
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
            navio.tomarDano();
            System.out.println("\n!!!VOCÊ ATINGIU UMA EMBARCAÇÃO!!!\n");
            if (navio.getVida() == 0) {
                System.out.println(navio);
                System.out.println();
            }
            return true;
        } else {
            System.out.println("\n!!ERROU!!\n");
            this.getValor(x-1, y).marcarComoAtingido();
            return false;
        }
    }


    @Override
    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
            for (int i = 0; i < getLinha(); i++) {
                for (int j = 0; j < getColuna(); j++) {
                    Posicao p = getValor(i, j);
                    char c = (p.getNavio() == null)
                             ? '.'                    // água
                             : p.getNavio().getInicial();
                    bw.write(c);
                }
                bw.newLine();
            }
        }
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(fileName));

        for (int i = 0; i < Math.min(linhas.size(), getLinha()); i++) {
            String linha = linhas.get(i);

            for (int j = 0; j < Math.min(linha.length(), getColuna()); j++) {
                char c = linha.charAt(j);
                Posicao p = new Posicao();
                p.setNavio(charToNavio(c));
                setValor(i, j, p);
            }
        }
    }

    /* converte caractere salvo no arquivo → instância de Navio (ou null) */
    private Navio charToNavio(char c) {
        switch (Character.toUpperCase(c)) {
            case 'P': return new PortaAvioes();      // Porta-Aviões
            case 'C': return new ContraTorpedeiro(); // Contratorpedeiro
            case 'S': return new Submarino();        // Submarino
            case 'N': return new Patrulheiro();      // Navio patrulheiro
            default:  return null;                   // '.' ou caractere desconhecido
        }
    }
}