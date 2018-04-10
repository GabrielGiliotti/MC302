/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Aluno extends Pessoa  {
	
	public static final int ESTADO_APROVADO= 1;
	public static final int ESTADO_REPROVADO = 2;
	public static final int ESTADO_EXAME = 3;
	private int estado;
	private double nota;
	
	public Aluno(String nome, String cpf, double nota, int estado) {
		super(nome, cpf);
		this.nota = nota;
		this.estado = estado;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	//Metodo para printar o estado do Aluno;
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
