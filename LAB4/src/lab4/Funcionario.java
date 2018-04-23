/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Funcionario extends Pessoa{
	//Salario é um atributo mais especifico da classe Funcionario, pois nem toda pessoa tem salario.
	//No caso desse laboratorio, instanciamos apenas pessoas que tem salario, isto é,
	//não há objetos do tipo pessoa.
	private double salario;
	
	//Construtor da classe funcionario
	//Chama o construtor da super classe para atribuição das informações mais gerais
	//e as informações mais especificas a classe são atribuidas nesse construtor.
	public Funcionario(String nome, String cpf, double salario) {
		super(nome, cpf);
		this.salario = salario;
	}
	//getters e setters da classe funcionario
	//Não estão sendo utilizados, pois todos os dados estao sendo atribuidos no construtor;
	public void setSalario( double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}
	//Metodo de impressão dados especifico para as informaçoes presentes em objetos do tipo Funcionario
	public void imprimeDados() {
		String saida;
		saida = "########## Funcionario\n";
		saida = saida + "Nome: " + getNome() + "\nCpf: " + getCpf() + "\nSalario: " + getSalario();
		System.out.println(saida);
		System.out.println();
	}
	
}
