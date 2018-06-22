/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab9;

public class Principal {
	public static void main(String[] args) {
		
		//Instanciando o repositorio para armazenar os cursos
		RepositorioDeCursos repositorio = new RepositorioDeCursos();
		
		//Instanciando os cursos para adicionar ao repositorio
		Curso letras = new Curso ("Letras", 20, 7 );
		Curso historia = new Curso ("Historia", 25, 19);
		Curso matematica = new Curso ("Matematica", 30, 1);
		Curso cienciaDaComputacao = new Curso ("Ciencia da Computacao", 28, 42);
		Curso educacaoFisica = new Curso ("Educacao Fisica", 15, 27);
		
		//Adicionando os cursos no repositorio Fora de Ordem:		
		repositorio.adicionarCurso(letras);
		repositorio.adicionarCurso(historia);
		repositorio.adicionarCurso(matematica);
		repositorio.adicionarCurso(cienciaDaComputacao);
		repositorio.adicionarCurso(educacaoFisica);

		//Instanciando Alunos de Graduacao para popular uma instancia de DisciplinaGraduacao
		AlunoGraduacao aluno1 = new AlunoGraduacao("Pedrinho do Fuminho", "157.965.357-98");
		AlunoGraduacao aluno2 = new AlunoGraduacao("Joseh BatePeh", "546.347.757-15");
		AlunoGraduacao aluno3 = new AlunoGraduacao("Erick Mavehrick", "609.385.637-63");
		AlunoGraduacao aluno4 = new AlunoGraduacao("Gabriela Perla", "157.634.557-11");
		AlunoGraduacao aluno5 = new AlunoGraduacao("Samuel Rodoanel", "157.450.461-57");
		AlunoGraduacao aluno6 = new AlunoGraduacao("Cristina TestaKina", "816.565.367-34");
		AlunoGraduacao aluno7 = new AlunoGraduacao("Giovana PehDeCana", "768.403.197-40");
		AlunoGraduacao aluno8 = new AlunoGraduacao("Isabela SeguraVela", "118.466.927-25");
		
		//Instanciando uma disciplina de Graduacao que eh compartilhada por ambos os cursos:
		DisciplinaGrad calculoII = new DisciplinaGrad( 211 ,"Calculo II", 6);
		DisciplinaGrad mc302 = new DisciplinaGrad( 302 ,"Programacao Orientada a Objetos", 6);
		DisciplinaGrad mc750 = new DisciplinaGrad ( 750 , "Construcao de Interfaces Homem-Computador", 4);
		
		//Associando as disciplinas aos cursos:
		matematica.adicionarDisciplinaAoCurso(calculoII);
		cienciaDaComputacao.adicionarDisciplinaAoCurso(mc302);
		cienciaDaComputacao.adicionarDisciplinaAoCurso(mc750);
		
		//Atribuindo cursos aos alunos instanciados
		aluno1.setCurso(matematica); aluno2.setCurso(matematica);
		aluno4.setCurso(matematica); aluno8.setCurso(matematica);
		aluno3.setCurso(cienciaDaComputacao); aluno5.setCurso(cienciaDaComputacao);
		aluno6.setCurso(cienciaDaComputacao); aluno7.setCurso(cienciaDaComputacao);
		
		ControladorDeMatricula controlador = new ControladorDeMatricula();
		//Solicitacoes de matricula para a disciplina CalculoII presente apenas no curso de Matematica
		controlador.solicitarMatricula(calculoII, aluno1); 
		controlador.solicitarMatricula(calculoII, aluno2);
		controlador.solicitarMatricula(calculoII, aluno4);
		controlador.solicitarMatricula(calculoII, aluno8);
		//Solicitacoes de matricula para as disciplinas mc302 e mc750 presentes no curso de Ciencia Da Computacao
		controlador.solicitarMatricula(mc302, aluno3);
		controlador.solicitarMatricula(mc302, aluno5);
		controlador.solicitarMatricula(mc302, aluno6);
		controlador.solicitarMatricula(mc302, aluno7);
		controlador.solicitarMatricula(mc750, aluno3);
		controlador.solicitarMatricula(mc750, aluno5);
		controlador.solicitarMatricula(mc750, aluno6);
		controlador.solicitarMatricula(mc750, aluno7);
		
		controlador.processaSolicitacoes();
		
		
		System.out.println();
		System.out.println("******* CURSOS EXISTENTES - NAO ORDENADOS *******");
	    System.out.println();
	    
	    Imprimivel imprimivel;
        while(repositorio.hasMoreElements()) {
            imprimivel = repositorio.nextElement();
            imprimivel.imprimeDados();
        }
		
        System.out.println();
        System.out.println("******* ALUNOS EXISTENTES *******");
        System.out.println();
        
        while(mc302.hasMoreElements()) {
            imprimivel = mc302.nextElement();
            imprimivel.imprimeDados();
		}
        while(calculoII.hasMoreElements()) {
            imprimivel = calculoII.nextElement();
            imprimivel.imprimeDados();
		}
        
        System.out.println("******* CURSOS EXISTENTES - ORDENADOS LEXICOGRAFICAMENTE *******");
        System.out.println();
        repositorio.ordenaCursosLexico();

        while(repositorio.hasMoreElements()) {
            imprimivel = repositorio.nextElement();
            imprimivel.imprimeDados();
        }		
	}	
}
