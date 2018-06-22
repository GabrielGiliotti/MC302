/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

import java.util.ArrayList;

public class RepositorioDeDisciplinas {
	
	//Atributos
	private ArrayList <Disciplina> repoDeDisciplinas; //Armazenas as disciplinas instanciadas

	//Construtor que inicia um arrayList repositorio de disciplinas
	public RepositorioDeDisciplinas() {
		this.repoDeDisciplinas = new ArrayList <Disciplina> ();
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
