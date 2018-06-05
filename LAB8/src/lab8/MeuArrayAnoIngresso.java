package lab8;

public class MeuArrayAnoIngresso extends MeuArray {
	//Metodo abstrato de MeuArray implementado na subclasse concreta
	@Override
	public Aluno compara( Aluno a1, Aluno a2) {
		if( a1.getAnoIngresso() <= a2.getAnoIngresso()) {
			return a1;
		}else{
			return a2;
		}
	}
}
