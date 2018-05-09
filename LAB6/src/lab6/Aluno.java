package lab6;

import mc302ef.GerenciadorAlunos;
import java.util.ArrayList;

public class Aluno {
	
	public static final int ALUNO_ATIVO = 1; //Variavel constante que indica se o aluno esta ativo 
	public static final int ALUNO_INATIVO = 2; //Variavel constante que indica se o aluno esta inativo
											//Não são utilizadas pois na classe aluno não é especificado seu uso. 
	private String nome; 
	private String cpf;
	private int estado; //estado eh correspondente ao aluno ser ATIVO OU INATIVO. Estado não eh utilizado nesse lab. 
	
	private int anoIngresso;
	protected int anoPrazo;
	private Curso curso;
	
	//Criar lista de disciplinas em que o aluno está matriculado.
	private ArrayList <Disciplina> disciplinas;
	
	private int matricula;
	private static int idMatricula = 1; //Variavel utilizada para gerar numero de matriculas diferentes para cada aluno, de todas as disciplinas de grad ou pos.
	
	
	//Construtor que nao recebe ano de ingresso como parametro e o altera com o metodo do pacote mc302ef 
	public Aluno(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoIngresso = GerenciadorAlunos.getAnoIngressoRandom();
		this.disciplinas = new ArrayList <Disciplina>();
		this.matricula = idMatricula++;
	}
	//Função que imprime os dados de todos os alunos, sejam eles de Graduacao, mestrado ou doutorado
	public void imprimeDados() {
		String saida = "##### Aluno #####\n";
		
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf(); 
		saida = saida +  "\nAno de ingresso: " + getAnoIngresso() + "\nAno prazo: " + getAnoPrazo();
		saida = saida + "\nMatricula: " + getMatricula() + "\nCurso: " + getCurso() ;
		System.out.println(saida);
		
		System.out.println();
	}
	
	public int contabilizaCreditosJaMatriculados () {
		int cred = 0;
		int i;
		for( i = 0; i < this.disciplinas.size(); i++ ) {
			cred = cred + this.disciplinas.get(i).getCreditos();
		}
		return cred;
	}
	
	
	//Metodo que adiciona disciplina ao ArrayList disciplinas de um aluno estanciado
	public boolean addDisciplina( Disciplina disciplina ) {
		this.disciplinas.add(disciplina);
		return true; //retorna true por ser boolean
	}
	//Metodo que remove disciplina do ArrayList disciplinas de um aluno estanciado
	public boolean removeDisciplina( Disciplina disciplina ) {
		this.disciplinas.remove(disciplina);
		return true;
	}
	
	//Metodos getter e setters (Pode ser que alguns não estejam sendo utilizados)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getEstado() {
		return estado;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getAnoPrazo() {
		return anoPrazo;
	}

	public void setAnoPrazo(int anoPrazo) {
		this.anoPrazo = anoPrazo;
	}
		
}
