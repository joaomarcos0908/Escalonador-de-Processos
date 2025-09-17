Escalonador-de-Processos



Informações do Projeto











Disciplina: Algoritmos e Estrutura de Dados I







Professor: Dimmy Magalhães







Turma: Allen







Integrantes:











Adriano Batista de Carvalho - Matrícula: 0030579







Eduardo Oliveira dos Santos - Matrícula: 0030780







João Marcos Maia Cavalcanti - Matrícula: 0030562







Repositório: https://github.com/joaomarcos0908/Escalonador-de-Processos.git



Descrição do Projeto



Este projeto implementa um escalonador de processos para um sistema operacional fictício chamado iCEVOS. O escalonador gerencia processos com diferentes prioridades (alta, média e baixa) e suporta operações como bloqueio por recursos (ex.: DISCO) e rotação de processos. Os processos são lidos de um arquivo de texto (processos.txt) e simulados ciclo a ciclo até que todos sejam concluídos.

Instruções de Compilação e Execução:

Pré-requisitos:

Java Development Kit (JDK) 11 ou superior







IntelliJ IDEA ou outro IDE compatível com Java







Git (para clonar o repositório)



Passos para Compilar e Executar











Clone o Repositório:



git clone https://github.com/joaomarcos0908/Escalonador-de-Processos.git

cd Escalonador-de-Processos







Configure o Projeto no IDE:











Abra o projeto no IntelliJ IDEA.







Certifique-se de que o JDK está configurado nas configurações do projeto.







Prepare o Arquivo processos.txt:











Crie ou edite o arquivo processos.txt na raiz do projeto ou na pasta out/production/Escalonador após compilação.







O formato do arquivo deve ser: id,nome,prioridade,ciclos,recurso (ex.: 1,ProcessoA,1,3,NENHUM).







Exemplo de conteúdo:



1,ProcessoA,1,3,NENHUM

2,ProcessoB,2,2,DISCO

3,ProcessoC,1,4,NENHUM

4,ProcessoD,3,1,NENHUM







Compile o Projeto:











No IntelliJ, clique em Build > Build Project ou use o comando no terminal:



javac src/*.java -d out/production/Escalonador







Execute o Programa:











No IntelliJ, configure a execução em Run > Edit Configurations:











Defina o "Working directory" como out/production/Escalonador.







Adicione o argumento do arquivo (ex.: processos.txt) no campo "Program arguments".







Alternativamente, use o terminal:



java -cp out/production/Escalonador Main processos.txt







Certifique-se de que o caminho para processos.txt está correto no argumento.







Observação:











O programa exibirá a simulação ciclo a ciclo, mostrando o status das filas de processos (alta, média, baixa prioridade e bloqueados) até que todos os processos sejam concluídos. 
