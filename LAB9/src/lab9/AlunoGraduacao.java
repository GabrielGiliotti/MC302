/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

public class AlunoGraduacao extends Aluno implements Comparable<AlunoGraduacao>{
	
	//Construtor
	public AlunoGraduacao(String nome, String cpf) {
		super(nome, cpf);
		this.calculaAnoMaxIntegralizacao(); //Metodo utilizado para calcular o ano de integralização do aluno de graduacao
	}
	
	//Metodo que calcula o ano maximo de integralizacao do aluno de Graduacao
	@Override
	public void calculaAnoMaxIntegralizacao(){
		int a = getAnoIngresso();
		a = a + 6; //+6 pois o ano de entrada já eh um ano da integralização
		anoPrazo = a;
	}
	
	//Metodo Assinado pela Interface Imprimivel, implementado por Pessoa e que é herdado até as subclasses mais especificas e concretas
	//(Pessoa->Aluno->AlunoGraduacao)
	@Override
	public void imprimeDados() {
		String saida = "##### Aluno Graduacao #####\n";
		
		saida = saida + "Nome: "+ getNome() + "\nCpf: "+ getCpf(); 
		saida = saida +  "\nAno de ingresso: " + getAnoIngresso() + "\nAno prazo: " + getAnoPrazo();
		saida = saida + "\nMatricula: " + getMatricula() + "\nCurso: " + getCurso().getNome() ;
		System.out.println(saida);
		
		System.out.println();
	}
	
	//Sobrescrita de metodos abstratos de Aluno
	@Override
	public void adicionaNota(float nota) {
		this.notas.add(nota);
	}
	@Override
	public float mediaNotas() {
		float soma = 0;
        for(float nota : this.notas)
            soma += nota;
        return soma / this.notas.size();
	}
	@Override
	public boolean verificarAprovacao(float nota) {
		if( nota >= 5.0f) {
			return true;
		}
		return false;
	}

	//Retorna um numero n < 0 se a matricula do objeto corrente que chama compareTo eh menor que a matricula do objeto aluno
	//Retorna um numero n == 0 se a matricula do objeto corrente que chama compareTo eh igual que a matricula do objeto aluno
	//Retorna um numero n > 0 se a matricula do objeto corrente que chama compareTo eh maior que a matricula do objeto aluno
	@Override
	public int compareTo(AlunoGraduacao aluno) {
		return this.getMatricula() - aluno.getMatricula();
	}
	
}
