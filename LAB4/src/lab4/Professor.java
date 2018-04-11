/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Professor extends Funcionario{
	//Vetor de materias é atributo mais especifico, particular da classe Professor
	private int [] materiasQueProfessorLeciona;
	
	public Professor(String nome, String cpf, double salario, int materia1, int materia2, int materia3) {
		
		//Contrutor de Professor chama o Construtor de Funcionario
		//Entao chama o construtor da super classe para atribuição das informações mais gerais
		//e as informações mais especificas a classe são atribuidas nesse construtor.
		super(nome, cpf, salario);
		this.materiasQueProfessorLeciona = new int[3];//Aqui define-se que cada professor leciona em 3 materias diferentes;
		this.materiasQueProfessorLeciona[0] = materia1; //Fiz desse modo a titulo apenas de testar a classe
		this.materiasQueProfessorLeciona[1] = materia2;
		this.materiasQueProfessorLeciona[2] = materia3;
	}
	//Metodo que retorna as materias que o professor leciona
	public int[] getMaterias() {
		return materiasQueProfessorLeciona;
	}
	
	//Como atribuo as 3 materias no que cada professor leciona no construtor,
	//Não foi necessario um metodo setter para se atribuir as materias.
	//Mas poderia ser realizado.
	
	//Metodo de impressão dados especifico para as informaçoes presentes em objetos do tipo Professor
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
