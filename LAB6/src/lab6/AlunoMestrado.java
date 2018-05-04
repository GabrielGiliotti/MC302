package lab6;

public class AlunoMestrado extends AlunoPos{

	public AlunoMestrado(String nome, String cpf, String vinculo, int curso) {
		super(nome, cpf,vinculo, curso);
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
	
}
