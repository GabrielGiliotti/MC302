/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Funcionario extends Pessoa{
	private double salario;
	
	//Construtor da classe funcionario
	public Funcionario(String nome, String cpf, double salario) {
		super(nome, cpf);
		this.salario = salario;
	}
	//getters e setters da classe funcionario
	public void setSalario( double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}
	
}
