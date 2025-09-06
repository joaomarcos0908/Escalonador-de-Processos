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
    this.contadorCiclosAltaPrioridade=0;
}
 public void adicionarProcesso(Processo p) {
     switch (p.getPrioridade()) {
         case 1:
             listaAltaPrioridade.adicionarNoFinal(p);
         case 2:
             listaMediaPrioridade.adicionarNoFinal(p);
         case 3:
             listadeBaixaPrioridade.adicionarNoFinal(p);
         default:
             System.out.println("prioridade inválida" + p.getNome());
     }
 }
    public void  executarCicloDeCPU(){
    if(!listaBloqueados.estaVazia()){
        Processo desbloquear=listaBloqueados.removerDoInicio();
        adicionarProcesso(desbloquear);
    }
    
        Processo atual=null;
        if(contadorCiclosAltaPrioridade>=5){
            if(!listaMediaPrioridade.estaVazia()){
                atual=listaMediaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade=0;
            } else if (!listadeBaixaPrioridade.estaVazia()) {
                atual=listadeBaixaPrioridade.removerDoInicio();
                contadorCiclosAltaPrioridade=0;
            }

        }
     }
 }


