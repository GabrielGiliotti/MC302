/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab8;

public abstract class Pessoa {
	//Atributos mais genericos, especificos para qualquer pessoa.
	private String nome;
	private String cpf;
	
	//Construtor
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;	
	}
	
	//Metodos getters e setters
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
	
	//Assinatura de metodo implementada nas subclasses de Pessoa
	public abstract void imprimeDados();
	
}
