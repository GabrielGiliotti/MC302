/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab7;

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
	
	//Metodo que busca o Curso pelo nome
	public Curso buscaCurso( String nome ) {
		for( Curso c: this.listaDeCursos) { //Laço que percorre a listaDeCursos
			if(nome.equals(c.getNome())) { // Se o nome do curso dado for encontrado
				return c; //retornamos o curso
			}
		}
		return null; // caso contrario, retornamos null
	}
	//Metodo que busca o curso pelo Id
	public Curso buscaCurso( int id ) { 
		for( Curso c: this.listaDeCursos){ //Laço que percorre a lista de Cursos
			if( id == c.getId()) { //Se o id dado for igual ao de um curso instanciado
				return c; //retornamos o curso
			}
		}
		return null; // caso contrario, retornamos null
	}
	
	
}
