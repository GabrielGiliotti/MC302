/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Aluno extends Pessoa  {
	private int nota;
	
	public Aluno(String nome, String cpf, int nota) {
		super(nome, cpf);
		this.nota = nota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
