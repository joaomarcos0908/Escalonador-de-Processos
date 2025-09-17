

public class Listadeprocessos {
    private NoProcesso cabeca;
    private NoProcesso cauda;
    private int tamanho;

    public Listadeprocessos() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void adicionarNoFinal(Processo processo) {
        NoProcesso novoNo = new NoProcesso(processo);
        if (this.estaVazia()) {
            this.cabeca = novoNo;
            this.cauda = novoNo;
        } else {
            this.cauda.proximo = novoNo;
            this.cauda = novoNo;
        }
        this.cauda.proximo = this.cabeca;
        this.tamanho++;
    }

    public Processo removerDoInicio() {
        if (this.estaVazia()) {
            return null;
        }
        Processo p = this.cabeca.processo;


        if (this.cabeca == this.cauda) {
            this.cabeca = null;
            this.cauda = null;

        } else {
            this.cabeca = this.cabeca.proximo;
            this.cauda.proximo = this.cabeca;
        }
        this.tamanho--;
        return p;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        if (this.cabeca == null) {
            return true;
        } else {
            return false;
        }
    }

    public Processo verInicio() {
        if (estaVazia()) {
            return null;
        }
        return this.cabeca.processo;
    }

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("Lista vazia");
            return;
        }
        NoProcesso cursor = this.cabeca;
        StringBuilder TextoDaLista = new StringBuilder();
        TextoDaLista.append("[");


        int contador = 0;
        do {
            TextoDaLista.append(cursor.processo.getNome())
                    .append("(")
                    .append(cursor.processo.getCiclo_necessarios())
                    .append(")");
            cursor = cursor.proximo;
            contador++;
            if (contador < this.tamanho) {
                TextoDaLista.append(", ");
            }
        } while (contador < this.tamanho);

        TextoDaLista.append("]");
        System.out.println(TextoDaLista.toString());
    }
}

