package lab8;

public class DisciplinaPos extends Disciplina {

	public DisciplinaPos(int id, String nome, int creditos) {
		super(id, nome, creditos);
	}
	//Metodo sobrescrito que eh abstrato na superclasse
	@Override
	public boolean addAluno(Aluno aluno) {
		if (listaAlunos.size() == MAX_ALUNOS) {
			return false;
		}else {
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
