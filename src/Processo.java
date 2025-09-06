public class Processo {
     private int id;
     private String nome;
     private int prioridade;
     private int ciclo_necessarios;
     private String recurso_necessario;

public Processo (int id,String nome, int prioridade, int ciclos_necessarios,String recurso_necessario){
    this.id=id;
    this.nome=nome;
     this.prioridade=prioridade;
     this.ciclo_necessarios=ciclos_necessarios;
     this.recurso_necessario=recurso_necessario;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCiclo_necessarios() {
        return ciclo_necessarios;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
