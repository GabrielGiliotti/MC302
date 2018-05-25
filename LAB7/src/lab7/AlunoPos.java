/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab7;

public class AlunoPos extends Aluno{
	protected boolean isInglesComprovado; //Atributos especificados para a classe AlunoPos que serão modificados nas classes AlunoMestrado e AlunoDoutorado
	protected boolean isExameQualificacaoAprovado;
	private String nomeOrientador;
	
	public AlunoPos(String nome, String cpf) {
		super(nome, cpf);
	}	
	
	public AlunoPos(String nome, String cpf , String orientador) {
		super(nome, cpf);
		this.nomeOrientador = orientador;
	}

	public String getNomeOrientador() {
		return nomeOrientador;
	}

	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}	
	
	
}
