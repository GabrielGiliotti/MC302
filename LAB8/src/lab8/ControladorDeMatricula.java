/*Nome:Gabriel Volpato Giliotti RA:197569*/

package lab8;

import java.util.ArrayList;

public class ControladorDeMatricula {
	
	//Criando um ArrayList das solicitacoes de matriculas
	private ArrayList <SolicitacaoDeMatricula> solicitacoesDeMatriculas;
	
	//Construtor que instancia o ArrayList de solicitacoes
	public ControladorDeMatricula () {
		this.solicitacoesDeMatriculas = new ArrayList <SolicitacaoDeMatricula> ();
	}
	
	//Classe interna SolictacaoDeMatricula
	private class SolicitacaoDeMatricula{
		private Aluno aluno;
		private Disciplina disciplina;
		//Construtor dessa classe interna, que recebe uma disciplina e um aluno
		public SolicitacaoDeMatricula ( Disciplina disciplina, Aluno aluno ) {
			this.aluno = aluno;
			this.disciplina = disciplina;
		}
	}
	//Metodo que adiciona uma solicitacao de matricula à lista de solocitacoes
	public void solicitarMatricula(Disciplina disciplina, Aluno aluno){ //recebe da main a disicplina em que o aluno quer matricular e o aluno
		this.solicitacoesDeMatriculas.add(new SolicitacaoDeMatricula(disciplina, aluno)); //cria um objeto da classe interna solicitacao e adiciona no arraylist solicitacoesDeMatriculas
	}
	
	public void processaSolicitacoes() {
		int i;
		SolicitacaoDeMatricula solicit;
		for(i = 0; i < this.solicitacoesDeMatriculas.size(); i++) { // Percorre o ArrayList solicitacoesDeMatriculas
			solicit = this.solicitacoesDeMatriculas.get(i);
			if( solicit.aluno.contabilizaCreditosJaMatriculados() + solicit.disciplina.getCreditos() <= solicit.aluno.getCurso().getLimiteCreditosDoCurso()) { //Verifica se os creditos ja associados ao aluno mais os novos na lista de solicitacoes sao menores que o limite de credito do curso
				if( solicit.disciplina.addAluno(solicit.aluno) ) { //verifica se eh possivel adicionar o aluno na disciplina devido a turma estar incompleta 
					System.out.println("Solicitacao de " + solicit.aluno.getNome() + " ACEITA ! Aluno(a) matriculado na disciplina: " + solicit.disciplina.getNome() + "(" + solicit.disciplina.getCreditos() + " creditos)");
					System.out.println ("Total de creditos matriculados pelo aluno: " + solicit.aluno.contabilizaCreditosJaMatriculados()); 
				} else { //Se a turma estiver lotada:
					System.out.println("Matricula de " + solicit.aluno.getNome() + " REJEITADA na disciplina: " + solicit.disciplina.getNome() + ". Turma Cheia ! (" + solicit.disciplina.getCreditos() + " creditos)");
				}
			} else { //Se os creditos do aluno mais os solicitados sao maiores que o limite do curso:
				System.out.println("Matricula de " + solicit.aluno.getNome() + " REJEITADA na disciplina: " + solicit.disciplina.getNome() + ". Os creditos ja matriculados do aluno (" + solicit.aluno.contabilizaCreditosJaMatriculados() + " creditos) mais os creditos solicitados excedem os limites de creditos permitidos pelo curso(" + solicit.aluno.getCurso().getLimiteCreditosDoCurso() + " creditos) no semestre !");
			}
		}
		solicitacoesDeMatriculas.clear(); //Limpa a lista de solicitacoes
	}
}
