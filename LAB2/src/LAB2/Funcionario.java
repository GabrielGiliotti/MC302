/*Nome: Gabriel Volpato Giliotti 		ra:197569*/

package LAB2;

public class Funcionario {
	private int matricula;
	private String nome;
	private String cpf;

	/*construtor recebe	as informações default dos Funcionario*/
	public Funcionario (String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	/*getters da classe Funcionario*/
	public int getMatricula() {
		return matricula;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	/*Metodo para imprimir os dados dos Funcionario*/
	public void imprimeDados() {
		String saida = "########## Funcionario\n";
		saida = saida + "Matricula: " + getMatricula() + "\nNome: " + getNome() + "\nCpf: " + getCpf();
		System.out.println(saida);
	}
	
	/*Setters da classe Funcionario*/
	
	public void setNome( String nome ) {
		if( nome.length() >= 3 ) {
			this.nome = nome;
		}else{
			System.out.println("Nome invalido.");
		}
	}
	
	public void setCpf( String cpf ) {
		if( cpf.length() == 11 ) {
			this.cpf = cpf;
			this.matricula = CriadorDeMatricula.matriculador(); /*Se o cpf do funcionario for valido, entao incrementamos a matricula*/
		}else{
			System.out.println("Cpf invalido.");
		}
	}
	/*Em uma situação real, o que interessa é o numero do documento da pessoa cadastrada*/
	/*Entao a matricula sera efetuada se o cpf for inserido corretamente*/
}

