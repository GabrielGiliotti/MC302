/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

import java.util.ArrayList;

public class Curso {
	//Atributos especificados no enunciado
	private String nome;
	private ArrayList <Disciplina> disciplinasDoCurso;
	private ArrayList <Aluno> alunosMatNoCurso;
	private int limiteCreditosDoCurso;
	private int id;
	
	//Construtor recebe o nome do curso e limite de creditos do mesmo no semestre
	public Curso ( String nome, int limiteCreditosDoCurso, int id ) {
		this.nome = nome;
		this.limiteCreditosDoCurso = limiteCreditosDoCurso;
		this.disciplinasDoCurso = new ArrayList <Disciplina> ();
		this.alunosMatNoCurso = new ArrayList <Aluno> ();
		this.id = id;
	}
	
	
	//Metodo que adiciona o aluno no arraylist de alunos matriculados no curso : faz uma busca para nao repetir matriculas iguais
	public void adicionarAlunoNoCurso( Aluno a ) {
		int i;
		Aluno checado;
		for( i = 0; i<alunosMatNoCurso.size(); i++) {
			checado = alunosMatNoCurso.get(i);
			if( !a.equals(checado) ) {		
				this.alunosMatNoCurso.add(a); 
			}
		}
	}
	//matodo para remover aluno do arraylist dos alunos matriculados no curso
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
	//Metodo para remover disciplina: busca disciplina desejada para remover a disciplina
	public void removerDisciplinaDoCurso( Disciplina d ) {
		int i;
		for( i=0; i < this.disciplinasDoCurso.size(); i++ ) {
			if( d.equals(disciplinasDoCurso.get(i))) {
				this.disciplinasDoCurso.remove(i);
			}
		}
	}
	//Metodos setters e getters da classe Aluno
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Disciplina> getDisciplinasDoCurso() {
		return disciplinasDoCurso;
	}
	public void setDisciplinasDoCurso(ArrayList<Disciplina> disciplinasDoCurso) {
		this.disciplinasDoCurso = disciplinasDoCurso;
	}
	public ArrayList<Aluno> getAlunosMatNoCurso() {
		return alunosMatNoCurso;
	}
	public void setAlunosMatNoCurso(ArrayList<Aluno> alunosMatNoCurso) {
		this.alunosMatNoCurso = alunosMatNoCurso;
	}
	public int getLimiteCreditosDoCurso() {
		return limiteCreditosDoCurso;
	}
	public void setLimiteCreditosDoCurso(int limiteCreditosDoCurso) {
		this.limiteCreditosDoCurso = limiteCreditosDoCurso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
