/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;

public class Pessoa {
	//Atributos mais genericos, especificos para qualquer pessoa.
	private String nome;
	private String cpf;
	
	//Construtor para atribuir nome e cpf de objetos do tipo Pessoa e suas Subclasses
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;	
	}
	
	//Metodos setters e getters, não estão sendo utilizados, pois todas as informações
	//são atribuidas pelo construtor.
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
	//Será deixado apenas para fins de reutilizações futuras.
	
}
