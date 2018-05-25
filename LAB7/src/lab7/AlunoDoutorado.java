/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab7;

public class AlunoDoutorado extends AlunoPos {
	
	//Sobrecarga de construtores para alunos de Doutorado
	public AlunoDoutorado( String nome, String cpf, Professor p) {
		super(nome,cpf, p);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de doutorado
	}
	public AlunoDoutorado( String nome, String cpf) {
		this(nome,cpf, null);
	}
	
	
	public void setInglesComprovado( boolean comprova ) {
		isInglesComprovado = comprova;
	}
	//TODO: será alterado futuramente !
	public void setExameQualificado( boolean qualificaEQM ) {
		isExameQualificacaoAprovado = qualificaEQM;
	}
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 5; //+5 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	
	@Override
	public void imprimeDados() {
		String saida = "##### Aluno Doutorado #####\n";
		
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf(); 
		saida = saida +  "\nAno de ingresso: " + getAnoIngresso() + "\nAno prazo: " + getAnoPrazo();
		saida = saida + "\nMatricula: " + getMatricula() + "\nCurso: " + getCurso().getNome() ;
		System.out.println(saida);
		
		System.out.println();
	}
	
}
