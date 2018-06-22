/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

public class AlunoDoutorado extends AlunoPos implements Comparable <AlunoDoutorado> {
	
	//Sobrecarga de construtores para alunos de Doutorado
	public AlunoDoutorado( String nome, String cpf, Professor p) {
		super(nome,cpf, p);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de doutorado
	}
	public AlunoDoutorado( String nome, String cpf) {
		this(nome,cpf, null);
	}
	
	//Metodos para futura implementacao
	public void setInglesComprovado( boolean comprova ) {
		isInglesComprovado = comprova;
	}
	public void setExameQualificado( boolean qualificaEQM ) {
		isExameQualificacaoAprovado = qualificaEQM;
	}
	
	//Metodo que calcula ano de Integralizacao do aluno de Doutorado
	@Override
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 5; //+5 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	
	//Metodo Assinado pela Interface Imprimivel, implementado por Pessoa e que é herdado até as subclasses mais especificas e concretas
	//(Pessoa->Aluno->AlunoPos->AlunoDoutorado)
	@Override
	public void imprimeDados() {
		String saida = "##### Aluno Doutorado #####\n";
		
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
	public int compareTo(AlunoDoutorado aluno) {
		return this.getMatricula() - aluno.getMatricula();
	}

}
