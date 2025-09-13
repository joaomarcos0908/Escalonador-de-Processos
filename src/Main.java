import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("ERRO! Uso correto -> java Main <arquivo_processos.txt>");
            return;
        }

        String nomeArquivo = args[0];
        Scheduler scheduler = new Scheduler();

        System.out.println("CARREGANDO PROCESSOS DO ARQUIVO: " + nomeArquivo);
        System.out.println("═".repeat(60));

        int processosCarregados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int prioridade = Integer.parseInt(partes[2]);
                int ciclos = Integer.parseInt(partes[3]);
                String recurso = partes[4].equals("NENHUM") ? null : partes[4];

                Processo p = new Processo(id, nome, prioridade, ciclos, recurso);
                scheduler.adicionarProcesso(p);
                processosCarregados++;

                String recursoInfo = (recurso != null) ? " (Requer: " + recurso + ")" : "";
                System.out.println("✓ Processo carregado: " + nome + " | Prioridade: " + prioridade +
                        " | Ciclos: " + ciclos + recursoInfo);
            }
        } catch (IOException e) {
            System.out.println("ERRO! ao ler o arquivo: " + e.getMessage());
            return;
        }

        System.out.println("═".repeat(60));
        System.out.println(" CARREGAMENTO CONCLUÍDO: " + processosCarregados + " processos adicionados");
        System.out.println(" SIMULAÇÃO DO ESCALONADOR iCEVOS...\n");

        int ciclo = 1;
        while (true) {
            imprimirCabecalhoCiclo(ciclo);
            scheduler.executarCicloDeCPU();
            scheduler.imprimirFilas();

            ciclo++;

            if (scheduler.trabalhoFinalizado()) {
                imprimirFinalizacao(ciclo - 1);
                break;
            }
        }
    }
    private static void imprimirCabecalho() {
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        ESCALONADOR DE PROCESSOS iCEVOS                       ║");
        System.out.println("║                     Sistema Operacional - Versão 1.0                        ║");
        System.out.println("║                   Algoritmos e Estrutura de Dados I                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static void imprimirCabecalhoCiclo(int ciclo) {
        System.out.println("\n╭" + "─".repeat(30) + " CICLO " + String.format("%03d", ciclo) + " " + "─".repeat(30) + "╮");
    }

    private static void imprimirFinalizacao(int totalCiclos) {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                            SIMULAÇÃO FINALIZADA                               ║");
        System.out.println("║                     Todos os processos foram executados!                      ║");
        System.out.println("║                        Total de ciclos: " + String.format("%03d", totalCiclos) + "                                   ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
    }

}