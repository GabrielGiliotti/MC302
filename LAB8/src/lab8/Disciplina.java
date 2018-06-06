/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

import java.util.ArrayList;

public abstract class Disciplina {
	
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	protected ArrayList <AvaliaAluno> listaAlunos;
	private int creditos;

	
	protected class AvaliaAluno {
	    private Aluno aluno;	//Indica o aluno que esta sendo avaliado
	    private Boolean aprovado; //indica se o aluno foi aprovado ou nao
	    private Float nota; // armazenando nota respectiva ao Aluno

	    public AvaliaAluno(Aluno aluno) {
	        this.aluno = aluno;
	        this.nota = null;
	        this.aprovado = null;
        }

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
	
	public Disciplina(int id, String nome, int creditos) {
		this.id = id;
		this.nome = nome;
		this.listaAlunos = new ArrayList <AvaliaAluno> ();
		this.creditos = creditos;
	}
	
	public void setNome(String nome) {
		if (nome.length() >= Disciplina.NOME_MIN_LEN) {
			this.nome = nome;
		} else {
			System.out.println("O nome informado possui menos de " + Disciplina.NOME_MIN_LEN + " caracteres !");
		}
	}
	
	public void geraNota() {
		int tam = listaAlunos.size();
		for(int i = 0; i<tam; i++) {
			listaAlunos.get(i).setNota((float)i%10);
		}
	}
	 
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
