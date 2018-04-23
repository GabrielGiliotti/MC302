/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Aluno extends Pessoa  {
	//Atributos mais especificos da classe Aluno
	public static final int ESTADO_APROVADO = 1;
	public static final int ESTADO_REPROVADO = 2;
	public static final int ESTADO_EXAME = 3;
	private int estado;
	private double nota;
	
	//Construtor de Aluno, recebe as informações que uma pessoa receberia,
	//Entao chama o construtor da super classe para atribuição das informações mais gerais
	//e as informações mais especificas a classe são atribuidas nesse construtor.
	public Aluno(String nome, String cpf, double nota, int estado) {
		super(nome, cpf);
		this.nota = nota;
		this.estado = estado;
	}
	//Observe que nas subclasses não criamos metodos iguais da super classe,
	//Utilizamos os metodos da superclasse pois a Herança permite essa ação
	
	//Get e set de nota do aluno,que não estao sendo utilizados, devido a atribuição no construtor,
	//e a não necessidade de modificar as informações passadas na instanciação.
	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	//Metodo de impressão dados especifico para as informaçoes presentes em objetos do tipo Aluno
	public void imprimeDados() {
		String saida = "########## Aluno\n";
		String estado;
		
		if(this.estado == Aluno.ESTADO_APROVADO) {
			estado = "APROVADO";
		}else if(this.estado == Aluno.ESTADO_EXAME) {
			estado = "EXAME";
		}else {
			estado = "REPROVADO";
		}
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf() + "\nNotaFinal: " + getNota() + "\nEstado do Aluno: " + estado;
		System.out.println(saida);
		System.out.println();
	}

}
