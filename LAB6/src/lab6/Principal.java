/*Nome: Gabriel Volpato Giliotti	RA:197569*/

/*Pelo re-uso de codigo do laboratorio 5, muitas classes, metodos e atributos nao sao utlizados.
 * tentei realizar os procedimentos referentes ao laboratorio 6 apenas !*/
package lab6;

public class Principal {
	public static void main( String[] args) {

		RepositorioDeCursos repositorioDeCursos = new RepositorioDeCursos(); //Instanciacao do repositorio de Cursos
	    ControladorDeMatricula controladorDeMatricula = new ControladorDeMatricula(); //Instanciacao do controlador de matricula
		
        //Instanciando os cursos de Ciencia e Engenharia da Comp;
        Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", 8);
        Curso engenhariaDaComputacao = new Curso ("Engenharia da Computacao", 20);
        //Adicionando cursos no repositorio de curso;
        repositorioDeCursos.adicionarCurso(cienciaDaComputacao); 
        repositorioDeCursos.adicionarCurso(engenhariaDaComputacao);
        
        //Instanciando disciplinas
        Disciplina mc302 = new Disciplina(302, "Programacao Orientada a Objetos", 6);
        Disciplina hz291 = new Disciplina (291, "Topicos Especiais de Humanidades", 12);
        Disciplina f128 = new Disciplina(128, "Fisica I", 4);
        Disciplina ee532 = new Disciplina (532, "Eletronica Aplicada", 8);
        Disciplina ma111 = new Disciplina (532, "Calculo I", 6 );
        Disciplina ma211 = new Disciplina(211, "Calculo II", 2);
        
        //Adicionando as disciplinas nos cursos criados anteriormente
        engenhariaDaComputacao.adicionarDisciplinaAoCurso(hz291);
        cienciaDaComputacao.adicionarDisciplinaAoCurso(mc302);
        engenhariaDaComputacao.adicionarDisciplinaAoCurso(ee532);
        cienciaDaComputacao.adicionarDisciplinaAoCurso(ma211);
        engenhariaDaComputacao.adicionarDisciplinaAoCurso(ee532);     
        cienciaDaComputacao.adicionarDisciplinaAoCurso(f128);

        //Criando alunos de graduacao
        AlunoGraduacao alunoGraduacao1 = new AlunoGraduacao("Gabriel", "753.258.634-11");
        AlunoGraduacao alunoGraduacao2 = new AlunoGraduacao("Ivan", "813.658.734-61");
        
        //Associando aluno ao curso e curso ao aluno 
        cienciaDaComputacao.adicionarAlunoNoCurso(alunoGraduacao1);
        alunoGraduacao1.setCurso(cienciaDaComputacao);
        //Tentando adicionar um Mesmo aluno em CURSOS Diferentes
        engenhariaDaComputacao.adicionarAlunoNoCurso(alunoGraduacao1);
        alunoGraduacao1.setCurso(engenhariaDaComputacao);
        System.out.println();
        //Associando aluno ao curso e curso ao aluno 
        engenhariaDaComputacao.adicionarAlunoNoCurso(alunoGraduacao2);
        alunoGraduacao2.setCurso(engenhariaDaComputacao);
        //Tentando adicionar um Mesmo aluno em CURSOS Diferentes
        cienciaDaComputacao.adicionarAlunoNoCurso(alunoGraduacao2);
        alunoGraduacao2.setCurso(cienciaDaComputacao);
        System.out.println();
        
        //Solicitando matricula do aluno em disciplinas do curso de Ciencia da Computacao
        controladorDeMatricula.solicitarMatricula(f128, alunoGraduacao1); //Repare que o aluno so faz matriculas em disciplinas do seu curso.
        controladorDeMatricula.solicitarMatricula(ma211, alunoGraduacao1);
        controladorDeMatricula.solicitarMatricula(mc302, alunoGraduacao1);
        controladorDeMatricula.processaSolicitacoes(); 
        System.out.println();
        //Solicitando matricula do aluno em disciplinas do curso de Ciencia da Computacao
        controladorDeMatricula.solicitarMatricula(hz291, alunoGraduacao2);
        controladorDeMatricula.solicitarMatricula(ee532, alunoGraduacao2);
        controladorDeMatricula.solicitarMatricula(ma111, alunoGraduacao2);
        controladorDeMatricula.processaSolicitacoes(); //Processando as solicitações de matricula nas disciplinas instanciadas
        System.out.println();

        //criando 26 alunos e tentando matricula-los em uma determinada disciplina
        int alunoi;
        for(alunoi=1; alunoi<=26; alunoi++) {
            AlunoGraduacao alunos = new AlunoGraduacao("Aluno " + alunoi, "00000" + alunoi); //Instanciacao de alunos
            cienciaDaComputacao.adicionarAlunoNoCurso(alunos); //Adicionando aluno no curso (lista que curso tem dos alunos matriculados)
            alunos.setCurso(cienciaDaComputacao); //passando o curso ao qual os alunos serao matriculados
            controladorDeMatricula.solicitarMatricula(mc302, alunos); //solicitando a matricula em uma materia de 6 creditos
        }
        System.out.println();
        controladorDeMatricula.processaSolicitacoes(); //Apos solicitar a matricula de todos os 26 alunos em uma disciplina, ocorre o processamento
        //onde os 25 primeiros sao aceitos e o ultimo é rejeitado pelo excesso de alunos matriculados.	
	}
}
