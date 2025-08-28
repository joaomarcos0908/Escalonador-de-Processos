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
        NoProcesso novoNo = new NoProcesso(processo);
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximoNo = novoNo;
            this.fim = novoNo;
        }
        this.tamanho++;
    }

    public Processo removerDoInicio() {
        if (this.inicio == null) {
            throw new RuntimeException("fila vazia!");
        }
        Processo p = this.inicio.processo;
        this.inicio = this.inicio.proximoNo;
        if (this.inicio == null) {
            this.fim = null;
        }
        this.tamanho--;
        return p;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }
        public Processo verInicio () {
            if (estaVazia()) {
                return null;
            }
            return this.inicio.processo;
        }
    }
