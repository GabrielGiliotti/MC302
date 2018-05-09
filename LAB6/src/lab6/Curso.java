package lab6;

import java.util.ArrayList;

public class Curso {
	private String nome;
	private ArrayList <Disciplina> disciplinasDoCurso;
	private ArrayList <Aluno> alunosMatNoCurso;
	
	private int limiteCreditosDoCurso;
	
	public Curso ( String nome, int limiteCreditosDoCurso ) {
		this.nome = nome;
		this.limiteCreditosDoCurso = limiteCreditosDoCurso;
		this.disciplinasDoCurso = new ArrayList <Disciplina> ();
		this.alunosMatNoCurso = new ArrayList <Aluno> ();
	}
	
	
	public int getLimiteCreditosDoCurso() {
		return limiteCreditosDoCurso;
	}

	public void setLimiteCreditosDoCurso(int limiteCreditosDoCurso) {
		this.limiteCreditosDoCurso = limiteCreditosDoCurso;
	}



	//Não criei setter de nome e nem creditos do curso pois eles não podem ser alterados depois de instanciados;
	//E também não fiz constantes pois nomes e creditos na instanciação podem ser diferentes;
	public String getNome() {
		return nome;
	}
	
	public int getCreditosDoCurso() {
		return limiteCreditosDoCurso;
	}
	

	public void adicionarAlunoNoCurso( Aluno a ) {
		this.alunosMatNoCurso.add(a); // Adicionando um aluno no curso
	}
	
	public void removerAlunoDoCurso ( Aluno a ) {
		int i;
		for(i=0; i<this.alunosMatNoCurso.size(); i++) {
			if( a.equals(this.alunosMatNoCurso.get(i)) ) {
				this.alunosMatNoCurso.remove(i); //remove aluno na posição i se ele for igual o aluno a recebido
			}
		}
	}
	
	//Aluno so pode ser matriculado em 1 curso (verificar se o aluno ja nao esta matriculado em outro curso)

	public void adicionarDisciplinaAoCurso( Disciplina d ) {
		this.disciplinasDoCurso.add(d);
	}
	
	public void removerDisciplinaDoCurso( Disciplina d ) {
		int i;
		for( i=0; i < this.disciplinasDoCurso.size(); i++ ) {
			if( d.equals(disciplinasDoCurso.get(i))) {
				this.disciplinasDoCurso.remove(i);
			}
		}
	}
	
}
