/*Nome: Gabriel Volpato Giliotti  RA:197569*/

//Onde devo instanciar os objetos para testar as classes extendidas e o arraylist de Pessoa

package lab7;

public class Principal {

	public static void main(String[] args) {
		
		MeuArray listaGeral = new MeuArray(); //Estancia da classe MeuArray para se guardar os dados de todas as classes, ou seja, listaGeral é um ArrayList de Pessoa
		//Este ira guardar os Alunos instanciados e servira para mostrar a sobrescrita de metodos 
		
		
		//Instanciando objetos do tipo Professor
		Professor p1 = new Professor ("Julio Cesar", "349.622.177-33", 15655.25, 102, 202, 302);
		Professor p2 = new Professor ("Cristian", "547.159.357-51", 20000.75, 111, 211, 311);
		Professor p3 = new Professor ("Esther", "147.936.285-22", 32500.00, 404, 358, 458) ;
		
		//Instanciando objetos dos tipos AlunoMestrado, AlunoDoutorado e AlunoGraduacao
		AlunoPos a1 = new AlunoPos ("Gabriel", "123.456.789-00", p1);
		AlunoPos a2 = new AlunoPos ("Ana Carolina", "987.654.321-40", p3); //Aluno com orientador
		AlunoGraduacao a3 = new AlunoGraduacao ("Eduardo", "456.213.798-13"); //Aluno sem orientador 
		AlunoPos a4 = new AlunoPos ("Natalia", "654.132.879-05", p1); //Sobrecarga de Construtores
		AlunoPos a5 = new AlunoPos ("Monica", "798.456.321-20", p2);
		
		//Adicionando os alunos instanciados no controlador
		ControladorAluno controlador = new ControladorAluno();
		controlador.adicionaAluno(a1); controlador.adicionaAluno(a2); controlador.adicionaAluno(a3); controlador.adicionaAluno(a4); controlador.adicionaAluno(a5);
		
		//Instanciando cursos para fazer testes;
		//Não será feito testes referentes aos creditos como feito no laboratorio anterior.
        Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", 8, 42);
        Curso engenhariaDaComputacao = new Curso("Engenharia da Computacao", 8, 34);
        Curso engenhariaCivil = new Curso("Engenharia Civil", 10, 12);
        
        //Armazenando cursos no repositorio de cursos
        RepositorioDeCursos repo = new RepositorioDeCursos();
        repo.adicionarCurso(engenhariaCivil);
        repo.adicionarCurso(cienciaDaComputacao);
        repo.adicionarCurso(engenhariaDaComputacao);
		
        //Adicionado os alunos a um unico curso
        a1.setCurso(cienciaDaComputacao); a2.setCurso(cienciaDaComputacao);
        a3.setCurso(engenhariaCivil); a4.setCurso(engenhariaDaComputacao); a5.setCurso(engenhariaCivil);
		System.out.println();
		
		//Testando Disciplinas para um unico aluno e adicionando no RepositorioDeDisciplinas
		RepositorioDeDisciplinas repoDis = new RepositorioDeDisciplinas ();
		Disciplina mc302 = new Disciplina (302, "Programacao Orientada a Objetos", 6);
		Disciplina f128 = new Disciplina (128, "Fisica I", 4);
		repoDis.adicionarDisciplina(f128); repoDis.adicionarDisciplina(mc302);
		a1.addDisciplina(f128); f128.addAluno(a1);
		a1.addDisciplina(mc302); mc302.addAluno(a1);
		
		//Adicionando Alunos e Professores estanciadas dentro de MeuArray;
		listaGeral.add(a1);		listaGeral.add(p1);
		listaGeral.add(a2);		listaGeral.add(p2);
		listaGeral.add(a3);		listaGeral.add(p3);
		listaGeral.add(a4);		listaGeral.add(a5);		
		//Repare que a adição dos objetos em MeuArray está fora de ordem;
		
		for(Pessoa p : listaGeral ) {
			p.imprimeDados();
		}	
		
		//Mostrando que a sobrecarga de metodos da classe ControladorAluno funciona
		Aluno x2 = controlador.buscaAluno("Gabriel", f128);
		Aluno x1 = controlador.buscaAluno(3);
		x1.imprimeDados();	
		x2.imprimeDados();
		
		//Idem para RepositorioDeCursos e RepositorioDeDisciplinas, 
		//porem nao foram feitos metodos para imprimir dados dos repositorios
		
		
		a1.adicionaNotas(7.0); a1.adicionaNotas(8.5);
		a3.adicionaNotas(5.2); a3.adicionaNotas(6.7);
		a1.calculaCoeficiente();
		a3.calculaCoeficiente();
		System.out.println("Nota Convertida (Aluno Pos): " + a1.getCoeficienteDeRendimento());
		System.out.println("Nota Nao Convertida (Aluno Grad): " + a3.getCoeficienteDeRendimento());
		
		
	}
}
