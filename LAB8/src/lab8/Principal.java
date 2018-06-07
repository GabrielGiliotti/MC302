/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab8;


public class Principal {
	public static void main(String[] args) {
		//Instanciando Alunos De Graduacao
		AlunoGraduacao g1 = new AlunoGraduacao("Arnaldo Bembolado", "156.321.978-55");
        AlunoGraduacao g2 = new AlunoGraduacao("Claudia Voadora", "985.313.548-87");
        AlunoGraduacao g3 = new AlunoGraduacao("Ernesto Chutalua", "560.256.897-34");
        AlunoGraduacao g4 = new AlunoGraduacao("Gabriela Fullpistola", "751.357.528-66");
        AlunoGraduacao g5 = new AlunoGraduacao("Israel Explosao", "666.666.666-66");
        //Intanciando Alunos de Mestrado
        AlunoMestrado m1 = new AlunoMestrado("Keyla Chicrete-Embalado", "234.156.760-23");
        AlunoMestrado m2 = new AlunoMestrado("Murilo Martelo-Rodado", "291.426.341-30");
        AlunoMestrado m3 = new AlunoMestrado("Paulinha Pernalisa", "573.823.130-96");
        AlunoMestrado m4 = new AlunoMestrado("Ronaldo Trestaco", "711.342.964-13");
        AlunoMestrado m5 = new AlunoMestrado("Tatiane Chutaku", "636.213.413-51");
        //Instanciando Alunos de Doutorado
        AlunoDoutorado d1 = new AlunoDoutorado("Valdinei Vejabem", "542.397.216-25");
        AlunoDoutorado d2 = new AlunoDoutorado("Zuleika Quebratelha", "225.344.398-42");
        AlunoDoutorado d3 = new AlunoDoutorado("Bruno Fantastico", "846.359.846-15");
        AlunoDoutorado d4 = new AlunoDoutorado("Daniela Cuxaixangue", "464.133.841-87");
        AlunoDoutorado d5 = new AlunoDoutorado("Fabricio Cutucaboia", "458.812.358-98");
        
        //Instanciando 2 ArraysLists onde um sera ordenado pela lexografia e outro pelo ano de ingresso
        MeuArray alunosDaUniversidade1 = new MeuArrayLexico();
        MeuArray alunosDaUniversidade2 = new MeuArrayAnoIngresso();
        
        //Adicionando os mesmo alunos em ambos os tipos de Array para testar as subclasses de MeuArray
        alunosDaUniversidade1.add(g1);	alunosDaUniversidade1.add(m1);	alunosDaUniversidade1.add(d1);
        alunosDaUniversidade1.add(g2);	alunosDaUniversidade1.add(m2);	alunosDaUniversidade1.add(d2);
        alunosDaUniversidade1.add(g3);	alunosDaUniversidade1.add(m3);	alunosDaUniversidade1.add(d3);
        alunosDaUniversidade1.add(g4);	alunosDaUniversidade1.add(m4);	alunosDaUniversidade1.add(d4);
        alunosDaUniversidade1.add(g5);	alunosDaUniversidade1.add(m5);	alunosDaUniversidade1.add(d5);
        
        alunosDaUniversidade2.add(g1);	alunosDaUniversidade2.add(m1);	alunosDaUniversidade2.add(d1);
        alunosDaUniversidade2.add(g2);	alunosDaUniversidade2.add(m2);	alunosDaUniversidade2.add(d2);
        alunosDaUniversidade2.add(g3);	alunosDaUniversidade2.add(m3);	alunosDaUniversidade2.add(d3);
        alunosDaUniversidade2.add(g4);	alunosDaUniversidade2.add(m4);	alunosDaUniversidade2.add(d4);
        alunosDaUniversidade2.add(g5);	alunosDaUniversidade2.add(m5);	alunosDaUniversidade2.add(d5);
        
        //Chamando o metodo para ordenar em ambos os ArrayLists
        alunosDaUniversidade1.ordenaArrayList();
        alunosDaUniversidade2.ordenaArrayList();        
        
        RepositorioDeCursos repo = new RepositorioDeCursos(); //Instanciando o repositorio de Curso
        Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", 8, 42); //Criando um curso para adicionar no repositorio
        repo.adicionarCurso(cienciaDaComputacao); //Metodo que adiciona o curso no repositorio
        
        //Determinando o curso de cada Aluno (No caso é o mesmo para todos, apenas para testes)
        g1.setCurso(cienciaDaComputacao);	m1.setCurso(cienciaDaComputacao);	d1.setCurso(cienciaDaComputacao);
        g2.setCurso(cienciaDaComputacao);	m2.setCurso(cienciaDaComputacao);	d2.setCurso(cienciaDaComputacao);
        g3.setCurso(cienciaDaComputacao);	m3.setCurso(cienciaDaComputacao);	d3.setCurso(cienciaDaComputacao);
        g4.setCurso(cienciaDaComputacao);	m4.setCurso(cienciaDaComputacao);	d4.setCurso(cienciaDaComputacao);
        g5.setCurso(cienciaDaComputacao);	m5.setCurso(cienciaDaComputacao);	d5.setCurso(cienciaDaComputacao);


        //Testando Disciplinas e alunos e adicionando as disciplinas no RepositorioDeDisciplinas
        RepositorioDeDisciplinas repoDis = new RepositorioDeDisciplinas ();
        Disciplina f128 = new DisciplinaPos(128, "Fisica I", 4);
        Disciplina mc302 = new DisciplinaGrad (302, "Programacao Orientada Objetos", 6);
        repoDis.adicionarDisciplina(f128);
        repoDis.adicionarDisciplina(mc302);
        
        //Instanciando o controlador de matricula para fazer as solicitacoes dos alunos
        ControladorDeMatricula controladorDeMatricula = new ControladorDeMatricula();
        //Solicitando matricula para Alunos da Pos
        controladorDeMatricula.solicitarMatricula(f128, m1);	controladorDeMatricula.solicitarMatricula(f128, d1);
        controladorDeMatricula.solicitarMatricula(f128, m2);	controladorDeMatricula.solicitarMatricula(f128, d2);
        controladorDeMatricula.solicitarMatricula(f128, m3);	controladorDeMatricula.solicitarMatricula(f128, d3);
        controladorDeMatricula.solicitarMatricula(f128, m4);	controladorDeMatricula.solicitarMatricula(f128, d4);
        controladorDeMatricula.solicitarMatricula(f128, m5);	controladorDeMatricula.solicitarMatricula(f128, d5);
        //Solitando Matricula para alunos de Graduacao
        controladorDeMatricula.solicitarMatricula(mc302, g1);
        controladorDeMatricula.solicitarMatricula(mc302, g2);
        controladorDeMatricula.solicitarMatricula(mc302, g3);
        controladorDeMatricula.solicitarMatricula(mc302, g4);
        controladorDeMatricula.solicitarMatricula(mc302, g5);
        
        //Metodo que processa as solicitacoes
        controladorDeMatricula.processaSolicitacoes();

        System.out.println();
        
        System.out.println("Alunos ordenados por ordem Alfabetica !\n");
        for(Pessoa p : alunosDaUniversidade1) {
            p.imprimeDados(); //Imprimindo os dados ordenados lexicograficamente
        }
        System.out.println("Alunos ordenados por ano de Ingresso !\n");
        for(Pessoa p : alunosDaUniversidade2) {
            p.imprimeDados(); //Imprimindo os dados ordenados por Ano de Ingresso
        }
        
        //Imprime dados da Disciplina com as notas geradas
        f128.geraNota();
        mc302.geraNota();
        
        //Imprimindo os dados 
        mc302.imprimeDados();
        System.out.println();
        f128.imprimeDados();
	}	
}
