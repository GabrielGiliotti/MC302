/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Professor extends Funcionario{
	private int [] materiasQueProfessorLeciona;
	
	public Professor(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
		this.materiasQueProfessorLeciona = new int[7];
	}

	public int[] getMateriasQueProfessorLeciona() {
		return materiasQueProfessorLeciona;
	}

	public void setMateriasQueProfessorLeciona(int[] materiasQueProfessorLeciona) {
		this.materiasQueProfessorLeciona = materiasQueProfessorLeciona;
	}
	
}
