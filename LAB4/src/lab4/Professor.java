/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Professor extends Funcionario{
	private int [] materiasQueProfessorLeciona;
	
	public Professor(String nome, String cpf, double salario, int materia1, int materia2, int materia3) {
		super(nome, cpf, salario);
		this.materiasQueProfessorLeciona = new int[3];
		this.materiasQueProfessorLeciona[0] = materia1;
		this.materiasQueProfessorLeciona[1] = materia2;
		this.materiasQueProfessorLeciona[2] = materia3;
	}

	public int[] getMaterias() {
		return materiasQueProfessorLeciona;
	}

	public void setMaterias(int[] materiasQueProfessorLeciona) {
		this.materiasQueProfessorLeciona = materiasQueProfessorLeciona;
	}
	
	public void imprimeDados() {
		int i;
		String saida;
		saida = "########## Professor\n";
		saida = saida + "Nome: " + getNome() + "\nCpf: " + getCpf() + "\nSalario: " + getSalario() + "\nMaterias que o professor leciona: "; 
		System.out.println(saida);
		for(i = 0; i<materiasQueProfessorLeciona.length-1; i++) {
			System.out.printf("%d, ", materiasQueProfessorLeciona[i]);
		}
		System.out.printf( "%d\n", materiasQueProfessorLeciona[i]);		
		System.out.println();
	}
	
}
