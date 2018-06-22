/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

import java.util.ArrayList;
import java.util.Enumeration;

public abstract class Disciplina implements Imprimivel, Enumeration<Aluno>, Comparable<Disciplina> {
	
	//Atributos da Classe Disciplina
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	protected ArrayList <AvaliaAluno> listaAlunos; //ArrayList de AvaliaAluno para conseguir ter as notas de cada respectivo aluno
	private int creditos;
	private int indice;

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
		this.indice = 0;
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
	
	
	//Metodo Assinado pela Interface Imprimivel
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
	
	//Metodo importado da Classe Enumeravel, que verifica se existe um proximo elemento na listaAlunos
	@Override
	public boolean hasMoreElements() {
		if(this.indice < this.listaAlunos.size()) {
			return true;
		}
		this.indice = 0;
		return false;
	}

	//Metodo que retorna o proximo elemento na listaAlunos, se existir um proximo elemento
	@Override
	public Aluno nextElement() {
		return this.listaAlunos.get(indice++).getAluno();
	}

	//Metodo compareTo recebe uma disciplina, acessa seu nome e compara com nome de uma disciplina ja existente
	//Retorna um numero n < 0 se o nome do objeto corrente que chama compareTo eh menor que o nome do objeto dis
	//Retorna um numero n == 0 se o nome do objeto corrente que chama compareTo eh igual que o nome do objeto dis
	//Retorna um numero n > 0 se o nome do objeto corrente que chama compareTo eh maior que o nome do objeto dis
	@Override
	public int compareTo(Disciplina dis) {
		return this.getNome().compareTo(dis.getNome());
	}
	
}
