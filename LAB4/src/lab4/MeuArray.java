/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab4;
 
import java.util.ArrayList;

//Criada a classe MeuArray que extende ArrayList de PESSOA ! (Enunciado)
public class MeuArray extends ArrayList <Pessoa> {
	
	public void ordenaArrayList() {
		
		int n = this.size();
		for(int i = 1; i < n ; i++) {
			Pessoa chave = this.get(i);
			int j = i - 1;
			while( j >= 0 && this.get(j).getNome().compareTo(chave.getNome()) > 0 ) {
				this.set(j+1, this.get(j));
				j--;
			}
			this.set(j+1, chave);
		}
	}
}
