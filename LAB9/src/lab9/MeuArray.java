/*Nome: Gabriel Volpato Giliotti  RA:197569*/

package lab9;
 
import java.util.ArrayList;

/**
 * @deprecated
 * Essa classe será removida,devido a utilizacao do metodo compareTo de Comparable, o que inutiliza MeuArray e  
 * suas classes derivadas.
 * Portanto, utilize ArrayList.
 */
@Deprecated
public abstract class MeuArray extends ArrayList <Aluno> {
	//Metodo de ordenação do ArrayList
	public void ordenaArrayList() {
		int tam = this.size();
        for(int i=0; i<tam; i++) {
            for(int j=i+1; j<tam; j++) {
                Aluno anterior = this.compara(this.get(i), this.get(j));
                if(anterior.equals(this.get(j))) {
                    Aluno aux = this.get(i);
                    this.set(i, this.get(j));
                    this.set(j, aux);
                }
            }
        }
	}
	public abstract Aluno compara( Aluno a1, Aluno a2 );
}
