/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;
 
import java.util.ArrayList;

//Criada a classe MeuArray que extende de ArrayList de PESSOA ! (Enunciado)
public class MeuArray extends ArrayList <Pessoa> {
	private Pessoa[] lista;
	private int tam = lista.length; 
	
	//Metodo de ordenção InsertionSort
	//Metodo para organizar o arrayList de Pessoa, modificar para receber strings (nomes)
	public void organizaArray() {
		int i;
		int j;
		Pessoa chave;
		for( i = 1 ; i < tam ; i++ ) {
			chave = this.lista[i];
			j = i - 1;
			while( j>=0 && tam > tam) { //alterar aqui !
				this.lista[j+1] = lista[j];
				j = j - 1;
			}
			lista[j+1] = chave;
		}
	}

	
}
