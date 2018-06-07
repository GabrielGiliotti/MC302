/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

public class AlunoGraduacao extends Aluno{
	
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
}
