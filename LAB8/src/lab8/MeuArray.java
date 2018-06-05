/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab8;
 
import java.util.ArrayList;

//Criada a classe MeuArray que extende ArrayList de Pessoa.

public abstract class MeuArray extends ArrayList <Pessoa> {
	//
	public void ordenaArrayList() {
		int tam = this.size();
        for(int i=0; i<tam; i++) {
            for(int j=i+1; j<tam; j++) {
                Pessoa anterior = this.compara(this.get(i), this.get(j));
                if(anterior.equals(this.get(j))) {
                    Pessoa aux = this.get(i);
                    this.set(i, this.get(j));
                    this.set(j, aux);
                }
            }
        }
	}
	public abstract Pessoa compara(Pessoa p1, Pessoa p2 );
}
