import java.sql.SQLOutput;

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
        if (this.cabeca == null) {
            this.cabeca = novoNo;
            this.cauda = novoNo;
            cauda.proximo=this.cabeca;
        } else {
            this.cauda.proximo = novoNo;
            this.cauda = novoNo;
            cauda.proximo=this.cabeca;
        }
        this.tamanho++;
    }

    public Processo removerDoInicio() {
        if (this.cabeca == null) {
            return null;
        }
        Processo p = this.cabeca.processo;
        this.cabeca = this.cabeca.proximo;
        if (this.cabeca == null) {
            this.cauda= null;
            cauda.proximo=this.cabeca;
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
        while (cursor != null) {

            TextoDaLista.append(cursor.processo.getNome())
                    .append("(")
                    .append(cursor.processo.getCiclo_necessarios())
                    .append(")");
            if (cursor.proximo != null) {
                TextoDaLista.append(", ");
            }
            cursor = cursor.proximo;
        }
        TextoDaLista.append("]");
        System.out.println(TextoDaLista.toString());
    }
}


