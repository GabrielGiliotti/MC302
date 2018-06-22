/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

public class AlunoMestrado extends AlunoPos implements Comparable<AlunoMestrado>{
	
	//Sobrecarga de construtores dos alunos de Mestrado
	public AlunoMestrado( String nome, String cpf, Professor p) {
		super(nome, cpf, p);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de mestrado
	}
	public AlunoMestrado( String nome, String cpf) {
		this(nome, cpf, null);	
	}
	
	//Metodos para futura implementacao
	public void setInglesComprovado( boolean comprova ) {
		isInglesComprovado = comprova;
	}
	public void setExameQualificado( boolean qualificaEQM ) {
		isExameQualificacaoAprovado = qualificaEQM;
	}
	
	//Metodo que calcula o ano maximo de integralizacao do aluno de Mestrado
	@Override
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 2; //+2 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	
	//Metodo Assinado pela Interface Imprimivel, implementado por Pessoa e que é herdado até as subclasses mais especificas e concretas
	//(Pessoa->Aluno->AlunoPos->AlunoMestrado)
	@Override
	public void imprimeDados() {
		String saida = "##### Aluno Mestrado #####\n";
		
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf(); 
		saida = saida +  "\nAno de ingresso: " + getAnoIngresso() + "\nAno prazo: " + getAnoPrazo();
		saida = saida + "\nMatricula: " + getMatricula() + "\nCurso: " + getCurso().getNome() ;
		System.out.println(saida);
		
		System.out.println();
	}
	
	//Retorna um numero n < 0 se a matricula do objeto corrente que chama compareTo eh menor que a matricula do objeto aluno
	//Retorna um numero n == 0 se a matricula do objeto corrente que chama compareTo eh igual que a matricula do objeto aluno
	//Retorna um numero n > 0 se a matricula do objeto corrente que chama compareTo eh maior que a matricula do objeto aluno
	@Override
	public int compareTo(AlunoMestrado aluno) {
		return this.getMatricula() - aluno.getMatricula();
	}
	
}
