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
     switch (p.getPrioridade()) {
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
            if (atual.getRecurso_necessario() != null && atual.getRecurso_necessario().equals("DISCO")) {
                atual.setRecurso_necessario(null);
                this.listaBloqueados.adicionarNoFinal(atual);
            } else {
                atual.setCiclo_necessarios(atual.getCiclo_necessarios() - 1);
                if (atual.getCiclo_necessarios() <= 0) {

                } else {
                    this.adicionarProcesso(atual);

                }
            }
        }
    }
 }


