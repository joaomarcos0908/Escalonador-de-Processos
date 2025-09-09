import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Main <arquivo_processos.txt>");
            return;
        }

        String nomeArquivo = args[0];
        Scheduler scheduler = new Scheduler();

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
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        int ciclo = 1;
        while (true) {
            System.out.println("\n=== CICLO " + ciclo + " ===");
            scheduler.executarCicloDeCPU();

            scheduler.imprimirFilas();

            ciclo++;

            if (scheduler.trabalhoFinalizado()) {
                System.out.println("\nTodos os processos foram finalizados!");
                break;
            }
        }

    }
}