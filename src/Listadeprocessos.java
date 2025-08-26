public class Listadeprocessos {
    private Noprocesso inicio;
    private Noprocesso fim;
    private int tamanho;

    public Listadeprocessos() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    public void adicionarNoFinal(Processo processoNovo) {
        Noprocesso novoNo = new Noprocesso(processoNovo);
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

