/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab8;

public class MeuArrayLexico extends MeuArray {
	//Metodo abstrato de MeuArray implementado na subclasse concreta
	@Override
	public Aluno compara( Aluno a1, Aluno a2) {
		if( a1.getNome().compareTo(a2.getNome()) <= 0  ) {
			return a1;
		}else{
			return a2;
		}
	}
}
