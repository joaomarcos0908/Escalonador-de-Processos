public class Scheduler {
private Listadeprocessos listaAltaPrioridade;
private Listadeprocessos listaMediaPrioridade;
private Listadeprocessos listadeBaixaPrioridade;
private Listadeprocessos listaBloqueados;
private int contadorCiclosAltaPrioridade;

public Scheduler(){
    this.listaAltaPrioridade=new Listadeprocessos();
    this.listaMediaPrioridade=new Listadeprocessos();
    this.listadeBaixaPrioridade=new Listadeprocessos();
    this.listaBloqueados=new Listadeprocessos();
    this.contadorCiclosAltaPrioridade=0;
}
 public void adicionarProcesso(Processo p) {
     switch (p.getPrioridade_original()) {
         case 1:
             listaAltaPrioridade.adicionarNoFinal(p);
             break;
         case 2:
             listaMediaPrioridade.adicionarNoFinal(p);
             break;
         case 3:
             listadeBaixaPrioridade.adicionarNoFinal(p);
             break;
         default:
             System.out.println("prioridade inválida" + p.getNome());
     }
 }
    public void  executarCicloDeCPU() {
        if (!listaBloqueados.estaVazia()) {
            Processo desbloquear = listaBloqueados.removerDoInicio();
            System.out.println(" Processo " + desbloquear.getNome() + " foi desbloqueado e voltou para a fila.");
            adicionarProcesso(desbloquear);
        }

        Processo atual = null;
        if (contadorCiclosAltaPrioridade >= 5) {
            if (!listaMediaPrioridade.estaVazia()) {
                atual = listaMediaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade = 0;
            } else if (!listadeBaixaPrioridade.estaVazia()) {
                atual = listadeBaixaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade = 0;
            }
        }
        if (atual == null) {
            if (!listaAltaPrioridade.estaVazia()) {
                atual = listaAltaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade++;
            } else if (!listaMediaPrioridade.estaVazia()) {
                atual = listaMediaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade = 0;
            } else if (!listadeBaixaPrioridade.estaVazia()) {
                atual = listadeBaixaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade = 0;
            }
        }
        if (atual != null) {
            System.out.println("Executando processo: " + atual.getNome() +
                    " | Prioridade: " + atual.getPrioridade() +
                    " | Ciclos restantes: " + atual.getCiclo_necessarios());
            if (atual.getRecurso_necessario() != null && atual.getRecurso_necessario().equals("DISCO")) {
                atual.setRecurso_necessario(null);
                this.listaBloqueados.adicionarNoFinal(atual);
                System.out.println("⏸ Processo " + atual.getNome() + " foi bloqueado (esperando DISCO).");
            } else {
                atual.setCiclo_necessarios(atual.getCiclo_necessarios() - 1);
                if (atual.getCiclo_necessarios() <= 0) {
                    System.out.println("Processo " + atual.getNome() + " terminou a execução!");
                } else {
                    this.adicionarProcesso(atual);

                }
            }
        }else{
            System.out.println("nenhum processo foi encontrado para executar nesse ciclo.");
        }
    }
    public void imprimirFilas() {
        System.out.println("Alta prioridade");
        this.listaAltaPrioridade.imprimirLista();

        System.out.println("Media prioridade");
        this.listaMediaPrioridade.imprimirLista();

        System.out.println("Baixa prioridade");
        this.listadeBaixaPrioridade.imprimirLista();

        System.out.println("Bloqueados");
        this.listaBloqueados.imprimirLista();
    }
    public boolean trabalhoFinalizado() {
        return this.listaAltaPrioridade.estaVazia() &&
                this.listaMediaPrioridade.estaVazia() &&
                this.listadeBaixaPrioridade.estaVazia() &&
                this.listaBloqueados.estaVazia();
    }

}


