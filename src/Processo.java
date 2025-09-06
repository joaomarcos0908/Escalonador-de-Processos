public class Processo {
     private int id;
     private String nome;
     private int prioridade;
     private int ciclo_necessarios;
     private String recurso_necessario;
     private String status;

public Processo (int id,String nome, int prioridade, int ciclos_necessarios,String recurso_necessario){
    this.id=id;
    this.nome=nome;
     this.prioridade=prioridade;
     this.ciclo_necessarios=ciclos_necessarios;
     this.recurso_necessario=recurso_necessario;
     this.status= "PRONTO";
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

    public String getRecurso_necessario() {
        return recurso_necessario;
    }

    public String getStatus() {
        return status;
    }

    public void setCiclo_necessarios(int ciclo_necessarios) {
        this.ciclo_necessarios = ciclo_necessarios;
    }

    public void setRecurso_necessario(String recurso_necessario) {
        this.recurso_necessario = recurso_necessario;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;

    }
}
