/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab9;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{
	
	private double salario;
	private int matricula;
		
	//Construtor da classe funcionario
	public Funcionario(String nome, String cpf, double salario, int matricula) {
		super(nome, cpf);
		this.salario = salario;
		this.matricula = matricula;
	}
	
	//getters e setters da classe funcionario
	public void setSalario( double salario) {
		this.salario = salario;
	}
	public double getSalario() {
		return salario;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	//Metodo Assinado pela Interface Imprimivel, implementado por Pessoa e que é herdado até as subclasses mais especificas e concretas
	//(Pessoa->Funcionario)
	@Override
	public void imprimeDados() {
		String saida;
		saida = "####### Funcionario #######\n";
		saida = saida + "Nome: " + getNome() + "\nCpf: " + getCpf() + "\nSalario: " + getSalario();
		System.out.println(saida);
		System.out.println();
	}

	//Retorna um numero n < 0 se a matricula do objeto corrente que chama compareTo eh menor que a matricula do objeto aluno
	//Retorna um numero n == 0 se a matricula do objeto corrente que chama compareTo eh igual que a matricula do objeto aluno
	//Retorna um numero n > 0 se a matricula do objeto corrente que chama compareTo eh maior que a matricula do objeto aluno
	@Override
	public int compareTo(Funcionario fun) {
		return this.getMatricula() - fun.getMatricula();
	}
	
}
