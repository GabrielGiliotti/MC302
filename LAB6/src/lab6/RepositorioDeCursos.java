package lab6;

import java.util.ArrayList;

public class RepositorioDeCursos {
	
	private ArrayList <Curso> listaDeCursos;
	
	public RepositorioDeCursos() {
		this.listaDeCursos = new ArrayList <Curso> ();
	}

	public void removerCurso( Curso c ){
		int i;
		for( i=0; i < this.listaDeCursos.size(); i++ ) {
			if( c.equals(this.listaDeCursos.get(i))) {
				this.listaDeCursos.remove(i);
			}
		}
	}
	
	public void adicionarCurso ( Curso c ) {
		this.listaDeCursos.add(c);
	}
	
	
	public ArrayList<Curso> getListaDeCursos() {
		return listaDeCursos;
	}

	public void setListaDeCursos(ArrayList<Curso> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}
	
	
	//ArrayList de Cursos de toda a universidade
	//Metodos para adicionar e remover cursos;
	
}
