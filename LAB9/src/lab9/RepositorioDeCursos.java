/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;


public class RepositorioDeCursos implements Enumeration <Curso> {
	
	//Array list de Cursos da universidade
	private ArrayList <Curso> listaDeCursos;
	private int indice;
	
	//Construtor para instanciar o array list
	public RepositorioDeCursos() {
		this.listaDeCursos = new ArrayList <Curso> ();
		this.indice = 0;
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
	
	//Metodos getters e setters da listaDeCursos
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
	
	
    //Metodo que faz a ordenacao lexicografica dos elementos, utilizando
    //os metodos de Comparable implementados pela classe Curso.
	public void ordenaCursosLexico() {
		Object array[] = this.listaDeCursos.toArray();
		Arrays.sort(array);
		for(int i=0; i < this.listaDeCursos.size(); i++)
			this.listaDeCursos.set(i, (Curso) array[i]);
	}
	

	//Metodo importado da Classe Enumeravel, que verifica se existe um proximo elemento na listaDeCursos
	@Override
	public boolean hasMoreElements() {
		if( this.indice < this.listaDeCursos.size()) {
			return true;
		}
		this.indice = 0;
		return false;
	}

	//Metodo que retorna o proximo elemento na listaDeCursos, se existir um proximo elemento
	@Override
	public Curso nextElement() {
		return this.listaDeCursos.get(this.indice++);
	}	
}
