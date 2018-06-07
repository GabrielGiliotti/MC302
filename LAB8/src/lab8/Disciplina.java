/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

import java.util.ArrayList;

public abstract class Disciplina {
	
	//Atributos da Classe Disciplina
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	protected ArrayList <AvaliaAluno> listaAlunos; //ArrayList de AvaliaAluno para conseguir ter as notas de cada respectivo aluno
	private int creditos;

	//Classe interna que gera um objeto do tipo AvaliaAluno que guarda o aluno, a nota na disciplina e se ele foi aprovado
	protected class AvaliaAluno {
	    private Aluno aluno;	//Indica o aluno que esta sendo avaliado
	    private Boolean aprovado; //indica se o aluno foi aprovado ou nao
	    private Float nota; // armazenando nota respectiva ao Aluno
	    
	    //Construtor
	    public AvaliaAluno(Aluno aluno) {
	        this.aluno = aluno;
	        this.nota = null;
	        this.aprovado = null;
        }
	    
	    //Metodos getters e setters da classe interna
        public Aluno getAluno() {
            return aluno;
        }
        public Boolean getAprovado() {
            return aprovado;
        }
        public float getNota() {
            return nota;
        }
        public void setNota(Float nota) {
            this.nota = nota;
            this.aluno.adicionaNota(nota);
            this.aprovado = this.aluno.verificarAprovacao(nota);
        }
	}
	
	//Construtor da Classe Externa Disciplina
	public Disciplina(int id, String nome, int creditos) {
		this.id = id;
		this.nome = nome;
		this.listaAlunos = new ArrayList <AvaliaAluno> ();
		this.creditos = creditos;
	}
	
	//Metodo que gera notas aleatorias para os alunos (Apenas para teste)
	public void geraNota() {
		int tam = listaAlunos.size();
		for(int i = 0; i<tam; i++) {
			listaAlunos.get(i).setNota((float)i%10);
		}
	}

	//Metodos abstratos implementados nas subclasse de Disciplina
	public abstract boolean addAluno( Aluno aluno );
	public abstract boolean removeAluno( Aluno aluno );
	
	//Metodo utilizado para printar o nome da disciplina e o id
	public void imprimeDados() {
		for ( int i =0; i<this.listaAlunos.size(); i++ ) {
			if(listaAlunos.get(i).getAprovado() == true ) {
				System.out.println("Nome: " + listaAlunos.get(i).getAluno().getNome() + " - Estado final: APROVADO !");
			}else {
				System.out.println("Nome: " + listaAlunos.get(i).getAluno().getNome() + " - Estado final: REPROVADO !");
			}
		}
	}
	
	//Metodos getters e setters
	public void setNome(String nome) {
		if (nome.length() >= Disciplina.NOME_MIN_LEN) {
			this.nome = nome;
		} else {
			System.out.println("O nome informado possui menos de " + Disciplina.NOME_MIN_LEN + " caracteres !");
		}
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
