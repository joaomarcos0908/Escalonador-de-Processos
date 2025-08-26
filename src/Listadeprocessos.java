public class Listadeprocessos {
    private NoProcesso inicio;
    private NoProcesso fim;
    private int tamanho;

    public Listadeprocessos() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    public void adicionarNoFinal(Processo processo) {
        NoProcesso novoNo = new NoProcesso (processo);
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximoNo = novoNo;
            this.fim = novoNo;

        }
            this.tamanho++;

        }
    }

