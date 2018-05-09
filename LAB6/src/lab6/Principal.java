package lab6;

public class Principal {
	public static void main( String[] args) {
		//inicializando repositorio de cursos e controlador de matricula
        RepositorioDeCursos repositorioDeCursos = new RepositorioDeCursos();
        ControladorDeMatricula controladorDeMatricula = new ControladorDeMatricula();

        //criando curso
        Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", 6);
        repositorioDeCursos.adicionarCurso(cienciaDaComputacao);

        //criando disciplinas e as adicionando no curso acima criado
        Disciplina mc302 = new Disciplina(302, "Programacao Orientada a Objetos", 6);
        Disciplina ma211 = new Disciplina(211, "Calculo 2", 2);
        Disciplina f128 = new Disciplina(128, "Fisica I", 4);
        cienciaDaComputacao.adicionarDisciplinaAoCurso(mc302);
        cienciaDaComputacao.adicionarDisciplinaAoCurso(ma211);
        cienciaDaComputacao.adicionarDisciplinaAoCurso(f128);

        //criando aluno de graduacao e o matriculando no curso acima criado
        AlunoGraduacao alunoGraduacao = new AlunoGraduacao("Gabriel", "753.258.634-11");
        cienciaDaComputacao.adicionarAlunoNoCurso(alunoGraduacao);
        alunoGraduacao.setCurso(cienciaDaComputacao);

        //solicitando matricula do aluno criado em diversas disciplinas
        controladorDeMatricula.solicitarMatricula(f128, alunoGraduacao);
        controladorDeMatricula.solicitarMatricula(ma211, alunoGraduacao);
        controladorDeMatricula.solicitarMatricula(mc302, alunoGraduacao);
        controladorDeMatricula.processaSolicitacoes();


        //criando 26 alunos e tentando matricula-los em uma determinada disciplina
        for(int i=0; i<26; i++) {
            AlunoGraduacao outroAluno = new AlunoGraduacao("Aluno " + i, "00000" + i);
            cienciaDaComputacao.adicionarAlunoNoCurso(outroAluno);
            outroAluno.setCurso(cienciaDaComputacao);
            controladorDeMatricula.solicitarMatricula(mc302, outroAluno);
        }
        controladorDeMatricula.processaSolicitacoes();
		
	}
		
}
