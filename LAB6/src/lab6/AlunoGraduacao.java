package lab6;

public class AlunoGraduacao extends Aluno{
	
	public AlunoGraduacao(String nome, String cpf, String vinculo, int curso) {
		super(nome, cpf, vinculo, curso);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de graduacao
	}
	
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 6; //+6 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	
	
	
}
