/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab6;

import java.util.ArrayList;

public class RepositorioDeCursos {
	//Array list de Cursos da universidade
	private ArrayList <Curso> listaDeCursos;
	//Construtor para instanciar o array list
	public RepositorioDeCursos() {
		this.listaDeCursos = new ArrayList <Curso> ();
	}
	//Metodo que busca um curso c recebido e o remove da listaDeCursos;
	public void removerCurso( Curso c ){
		int i;
		for( i=0; i < this.listaDeCursos.size(); i++ ) {
			if( c.equals(this.listaDeCursos.get(i))) {
				this.listaDeCursos.remove(i);
			}
		}
	}
	//Metodo para adicionar um curso a lista de cursos
	public void adicionarCurso ( Curso c ) {
		this.listaDeCursos.add(c);
	}
	//getters e setters da listaDeCursos
	public ArrayList<Curso> getListaDeCursos() {
		return listaDeCursos;
	}
	public void setListaDeCursos(ArrayList<Curso> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}
}
