package lab7;

import java.util.ArrayList;

public class RepositorioDeDisciplinas {
	
	private ArrayList <Disciplina> repoDeDisciplinas;

	//Construtor que inicia um arrayList repositorio de disciplinas
	public RepositorioDeDisciplinas(ArrayList<Disciplina> repoDeDisciplinas) {
		this.repoDeDisciplinas = repoDeDisciplinas;
	}
	//Metodo que busca uma disciplina pelo nome
	public Disciplina buscaDisciplina( String nome ) {
		for(Disciplina d: repoDeDisciplinas ) {
			if( nome.equals(d.getNome()) ) {
				return d;
			}
		}
		return null;		
	}
	//Metodo que busca uma disciplina pelo ID
	public Disciplina buscaDisciplina( int id ) {
		for( Disciplina d: repoDeDisciplinas ) {
			if( id == d.getId() ) {
				return d;
			}
		}
		return null;		
	}
	//Implementar metodos para adicinar e remover Disciplina
	
	public void adicionarDisciplina( Disciplina dis ) {
		this.repoDeDisciplinas.add(dis);
	}
	
	public void removerDisciplina ( Disciplina dis ) {
		for( Disciplina d: repoDeDisciplinas) {
			if( dis.equals(d)) {
				repoDeDisciplinas.remove(d);
			}
		}
	}
	
	
}
