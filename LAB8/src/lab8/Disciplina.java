/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

import java.util.ArrayList;

public abstract class Disciplina {
	
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	protected ArrayList <Aluno> listaAlunos;
	private int creditos;
	
	public Disciplina(int id, String nome, int creditos) {
		this.id = id;
		this.nome = nome;
		this.listaAlunos = new ArrayList <Aluno> ();
		this.creditos = creditos;
	}
	
	public void setNome(String nome) {
		if (nome.length() >= Disciplina.NOME_MIN_LEN) {
			this.nome = nome;
		} else {
			System.out.println("O nome informado possui menos de " + Disciplina.NOME_MIN_LEN + " caracteres !");
		}
	}
	 
	public abstract boolean addAluno( Aluno aluno );
	public abstract boolean removeAluno( Aluno aluno );
	
	//Metodo utilizado para printar o nome da disciplina e o id
	public void imprimeDados() {
		String resp = this.nome + "(" + this.id + ")\n";
		for ( int i =0; i<this.listaAlunos.size(); i++ ) {
			int matricula = this.listaAlunos.get(i).getMatricula();
			if (i == 0) {
				resp += "[" + matricula;
			} else { 
				resp += ", " + matricula;
			}
		}
		resp += "]";
		System.out.println(resp);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getCreditos() {
		return creditos;
	}

	public int getId() {
		return id;
	}
	
	
}
