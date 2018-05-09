package lab6;

public class AlunoPos extends Aluno{
	
	protected boolean isInglesComprovado; //Atributos especificados para a classe AlunoPos que serão modificados nas classes AlunoMestrado e AlunoDoutorado
	protected boolean isExameQualificacaoAprovado;
	
	public AlunoPos(String nome, String cpf) {
		super(nome, cpf);
	}
	
}
