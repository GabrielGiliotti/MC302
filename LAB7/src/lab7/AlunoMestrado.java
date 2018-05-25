/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab7;

//Classe nao utilizada no lab 6
public class AlunoMestrado extends AlunoPos{
	public AlunoMestrado(String nome, String cpf) {
		super(nome, cpf);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de mestrado
	}
	//TODO: será alterado futuramente !
	public void setInglesComprovado( boolean comprova ) {
		isInglesComprovado = comprova;
	}
	//TODO: será alterado futuramente !
	public void setExameQualificado( boolean qualificaEQM ) {
		isExameQualificacaoAprovado = qualificaEQM;
	}
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 2; //+2 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	
	@Override
	public void imprimeDados() {
		String saida = "##### Aluno Mestrado #####\n";
		
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf(); 
		saida = saida +  "\nAno de ingresso: " + getAnoIngresso() + "\nAno prazo: " + getAnoPrazo();
		saida = saida + "\nMatricula: " + getMatricula() + "\nCurso: " + getCurso() ;
		System.out.println(saida);
		
		System.out.println();
	}
}
