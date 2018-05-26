/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab7;

//Classe nao utlizada no lab 6
public class AlunoGraduacao extends Aluno{
	public AlunoGraduacao(String nome, String cpf) {
		super(nome, cpf);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de graduacao
	}
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 6; //+6 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	//Sobrescrita de metodo para mostrar os dados dos alunos de graduacao
	@Override
	public void imprimeDados() {
		String saida = "##### Aluno Graduacao #####\n";
		
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf(); 
		saida = saida +  "\nAno de ingresso: " + getAnoIngresso() + "\nAno prazo: " + getAnoPrazo();
		saida = saida + "\nMatricula: " + getMatricula() + "\nCurso: " + getCurso().getNome() ;
		System.out.println(saida);
		
		System.out.println();
	}
}
