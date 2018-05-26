/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab7;

public class AlunoPos extends Aluno{
	protected boolean isInglesComprovado; //Atributos especificados para a classe AlunoPos que serão modificados nas classes AlunoMestrado e AlunoDoutorado
	protected boolean isExameQualificacaoAprovado;
	private Professor orientador;
	
	protected enum NotasPos{
		D(1), C(2), B(3), A(4);
		private double nota;
		
		private NotasPos( double nota ) {
			this.nota = nota;
		}
		
		public double getNota() {
			return nota;
		}
		
		public static NotasPos converteNota( double nota ) {
			if( nota >= 8.5 ) {
				return A;
			}else if ( nota >= 7 && nota < 8.5 ) {
				return B;
			}else if ( nota >= 5 && nota < 7) {
				return C;
			}else{
				return D;
			}
		}
	}
	
	
	//Metodo que adiciona as notas ja convertidas para calculo do coeficiente da Pos;
	@Override
	public void adicionaNotas( double nota ) {
		NotasPos notapos = NotasPos.converteNota(nota);
		//Descomente esse println para verificar que as notas estao sendo convertidas
		//System.out.println("Nota da POS: " + notapos + " Nota Apos conversao: " +notapos.getNota());
		this.notas.add(notapos.getNota());
	}
	
	//Sobrecarga de construtores
	public AlunoPos(String nome, String cpf) {
		this(nome, cpf, null);
	}	
	
	public AlunoPos(String nome, String cpf , Professor orientador) {
		super(nome, cpf);
		this.orientador = orientador;
	}
	
	//Metodos getters e setters
	public Professor getNomeOrientador() {
		return orientador;
	}

	public void setNomeOrientador(Professor nomeOrientador) {
		this.orientador = nomeOrientador;
	}
	
	
	
	
	
}
