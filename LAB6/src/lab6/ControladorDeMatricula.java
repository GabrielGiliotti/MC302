package lab6;

import java.util.ArrayList;

public class ControladorDeMatricula {
	
	private ArrayList <SolicitacaoDeMatricula> solicitacoesDeMatriculas;
	
	public ControladorDeMatricula () {
		this.solicitacoesDeMatriculas = new ArrayList <SolicitacaoDeMatricula> ();
	}
	
	private class SolicitacaoDeMatricula{
		private Aluno aluno;
		private Disciplina disciplina;
		
		public SolicitacaoDeMatricula ( Disciplina disciplina, Aluno aluno ) {
			this.aluno = aluno;
			this.disciplina = disciplina;
		}
	
	}
	
	//Adiciona uma solicitacao de matricula à lista de solocitacoes
	public void solicitarMatricula(Disciplina disciplina, Aluno aluno){
		this.solicitacoesDeMatriculas.add(new SolicitacaoDeMatricula(disciplina, aluno));
	}
	

	public void processaSolicitacoes() {
		int i;
		SolicitacaoDeMatricula solicit;
		for(i = 0; i < this.solicitacoesDeMatriculas.size(); i++) {
			solicit = this.solicitacoesDeMatriculas.get(i);
			if( solicit.aluno.contabilizaCreditosJaMatriculados() + solicit.disciplina.getCreditos() <= solicit.aluno.getCurso().getLimiteCreditosDoCurso() ) {
				if( solicit.disciplina.addAluno(solicit.aluno) ) {
					System.out.println("Solicitacao de " + solicit.aluno.getNome() + " ACEITA ! Aluno(a) matriculado na disciplina: " + solicit.disciplina.getNome() + "(" + solicit.disciplina.getCreditos() + ")");
					System.out.println ("Total de creditos matriculados pelo aluno: " + solicit.aluno.contabilizaCreditosJaMatriculados()); 
				} else {
					System.out.println("Matricula de " + solicit.aluno.getNome() + " REJEITADA na disciplina: " + solicit.disciplina.getNome() + ". Turma Cheia ! (" + solicit.disciplina.getCreditos() + ")");
				}
			} else {
				System.out.println("Matricula de " + solicit.aluno.getNome() + " REJEITADA na disciplina: " + solicit.disciplina.getNome() + " Limite de creditos do aluno excede os limites de creditos permitidos pelo curso no semestre ! (" + solicit.disciplina.getCreditos() + ")");
			}
		}
		solicitacoesDeMatriculas.clear();
	}
}
