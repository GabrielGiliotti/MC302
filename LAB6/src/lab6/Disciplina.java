package lab6;

import java.util.ArrayList;

public class Disciplina {
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	// TODO: Criar atributos para armazenar alunos
	protected ArrayList <Aluno> listaAlunos;
	
	//Alteração referente ao laboratorio 6:
	private int creditos;
	
	public Disciplina(int id, String nome, int creditos) {
		this.id = id;
		this.nome = nome;
		this.listaAlunos = new ArrayList <Aluno> ();
		this.creditos = creditos;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() >= Disciplina.NOME_MIN_LEN) {
			this.nome = nome;
		} else {
			System.out.println("O nome informado possui menos de " + Disciplina.NOME_MIN_LEN + " caracteres.");
		}
	}
	
	public boolean addAluno( Aluno aluno ) {
		// TODO: Adicionar aluno à disciplina (e disciplina a lista de disciplinas do aluno)
		if (listaAlunos.size() == MAX_ALUNOS) {
			//System.out.println("Não eh possível matricular o aluno. Turma lotada !");
			return false;
		}else{
			listaAlunos.add(aluno); //Adiciona aluno na lista que esta na classe disciplina
			aluno.addDisciplina(this); // Adiciona a disciplina dentro da lista de disciplinas que um aluno possui
			//System.out.println("Aluno adicionado ah disciplina e disciplina adicionada ah grade do aluno com sucesso !");
			return true;
		}
	}
	
	public boolean removeAluno( Aluno aluno ) {
		// TODO: Remover aluno da disciplina (e disciplina da lista de disciplinas de aluno)
		if(listaAlunos.size() == 0) {
			//System.out.println("Não ha alunos nessa disciplina !");
			return false;
		}else {
			listaAlunos.remove(aluno);//Remove aluno da lista de alunos matriculados na disciplina
			aluno.removeDisciplina(this); // Remove a disciplina dentro da lista de disciplinas que um aluno possui
			//System.out.println("Aluno removido da disciplina e disciplina removida da grade do aluno com sucesso !");
			return true;
		}
	}
	//Descomentar os printlns apresenta apenas se um aluno foi adicionado a turma ou nao, caso esta esteja lotada
	
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

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	
	
}
