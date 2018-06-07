/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

public class DisciplinaGrad extends Disciplina {
	
	//Construtor
	public DisciplinaGrad(int id, String nome, int creditos) {
		super(id, nome, creditos);
	}
	
	//Metodo sobrescrito que eh abstrato na superclasse
	@Override
	public boolean addAluno(Aluno aluno) {
		if (listaAlunos.size() == MAX_ALUNOS || aluno instanceof AlunoPos ) {
			return false; //Nesse caso, se a disciplina for de graduacao e aluno de Pos, nao sera possivel adicionar o aluno
		}else{
			listaAlunos.add(new AvaliaAluno(aluno));
			aluno.addDisciplina(this); 
			return true;
		}
	}
	//Metodo sobrescrito que eh abstrato na superclasse
	@Override
	public boolean removeAluno(Aluno aluno) {
		if(listaAlunos.size() == 0 ) {
			return false;
		}else{
			for( AvaliaAluno a : listaAlunos) {
				if( a.getAluno().equals(aluno)) {
					listaAlunos.remove(a);
				}
			}
			aluno.removeDisciplina(this);  
			return true;
		}
	}
}
