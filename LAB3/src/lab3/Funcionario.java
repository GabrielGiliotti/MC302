/*Nome: Gabriel Volpato Giliotti ra:197569 */

package lab3;

public class Funcionario {
	private String nome, cpf; //Variaveis em tuplas definidas no enunciado
	
	//Construtor da classe funcionario
	public Funcionario(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	//getters e setters da classe funcionario
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
