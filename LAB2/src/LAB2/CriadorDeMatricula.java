/*Nome: Gabriel Volpato Giliotti 		ra:197569*/

package LAB2;

public class CriadorDeMatricula {
	private static int m = 0;
	public static int matriculador(){
		m++;
		return m;	
	}
}

/*No criador de matricula, incrementamos m toda fez que o metodo é chamado, retornando um novo numero*/
/*Esse novo numero é a matricula gerada.*/

