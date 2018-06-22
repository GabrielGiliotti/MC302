/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

import mc302ef.GerenciadorAlunos;
import java.util.ArrayList;

public abstract class Aluno extends Pessoa{
											
	private int anoIngresso;
	protected int anoPrazo;
	private Curso curso = null;
	private double coeficienteDeRendimento;
	
	//Criar lista de disciplinas em que o aluno está matriculado.
	private ArrayList <Disciplina> disciplinas;
	protected ArrayList <Float> notas; //Armazena as notas do aluno nas disciplinas
	
	private int matricula;
	private static int idMatricula = 1; //Variavel utilizada para gerar numero de matriculas diferentes para cada aluno, de todas as disciplinas de grad ou pos.
	
	
	//Construtor que nao recebe ano de ingresso como parametro e o altera com o metodo do pacote mc302ef 
	public Aluno(String nome, String cpf) {
		super( nome,cpf );
		this.anoIngresso = GerenciadorAlunos.getAnoIngressoRandom();
		this.disciplinas = new ArrayList <Disciplina>();
		this.matricula = idMatricula++;
		this.notas = new ArrayList <Float> ();
	}

	//Metodos abstratos que devem ser implementados em subclasses de Aluno/AlunoPos que tambem eh abstrata
	public abstract void adicionaNota(float nota);
	public abstract float mediaNotas();
	public abstract boolean verificarAprovacao(float nota);
	public abstract void calculaAnoMaxIntegralizacao();
	
	//Metodo que contabiliza os creditos que o aluno esta matriculado
	public int contabilizaCreditosJaMatriculados () {
		int cred = 0;
		int i;
		for( i = 0; i < this.disciplinas.size(); i++ ) {
			cred = cred + this.disciplinas.get(i).getCreditos();
		}
		return cred;
	}
	
	//metodo que atribui um curso a um aluno,
	public void setCurso(Curso curso) {
		if( this.curso == null ) {	
			this.curso = curso; //Se o aluno não esta em nenhum curso, entao ele é matriculado no mesmo.
			this.curso.getAlunosMatNoCurso().add(this);
			System.out.println("Matricula do aluno " + getNome() + " realizada no curso de " + this.curso.getNome() + " !");
		}else{
			//Caso ele ja tenha um curso, entao apenas printa a msg de matricula negada por existir matricula do mesmo em outro curso
			System.out.println("Aluno " + getNome() + " já matriculado no curso " + this.curso.getNome() + " . Matricula em outro curso NEGADA !");
		}
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

	//Adiciona as notas no ArrayList de notas 
	public void adicionaNotas( float nota ) {
		this.notas.add(nota);
	}
	
	//metodo para calcular o coeficinete de rendimento de um aluno
	public double calculaCoeficiente() {
		int cont = 0; //Conta o numero de notas adicionadas
		for( double n: notas) { //Perocrre o array list de notas
			this.coeficienteDeRendimento += n; //soma a nota de uma posição no coeficiente
			cont += 1; //conta +1 para nota adicionada
		}
		this.coeficienteDeRendimento = this.coeficienteDeRendimento / (float)cont; //Fazemos o total das notas dividido pelas disciplinas
		return this.coeficienteDeRendimento; //Retornamos a media das notas nas disciplinas
	}
	
	//Metodos getters e setters 
	public double getCoeficienteDeRendimento() {
		return coeficienteDeRendimento;
	}
	public ArrayList<Float> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Float> notas) {
		this.notas = notas;
	}
	public void setCoeficienteDeRendimento(double coeficienteDeRendimento) {
		this.coeficienteDeRendimento = coeficienteDeRendimento;
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
	public int getAnoPrazo() {
		return anoPrazo;
	}
	public void setAnoPrazo(int anoPrazo) {
		this.anoPrazo = anoPrazo;
	}	
}
