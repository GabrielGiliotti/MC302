package lab6;

public class AlunoDoutorado extends AlunoPos {

	public AlunoDoutorado( String nome, String cpf, String vinculo, int curso) {
		super(nome,cpf, vinculo, curso);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de doutorado
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

}
