/*Nome: Gabriel Volpato Giliotti RA:197569*/

package lab9;

public abstract class AlunoPos extends Aluno{
	
	//Atributos especificados para a classe AlunoPos que serão modificados nas classes AlunoMestrado e AlunoDoutorado
	protected boolean isInglesComprovado; 
	protected boolean isExameQualificacaoAprovado;
	private Professor orientador;
	
	//Classe interna enum, utilizada para converter as notas dos alunos de Pos-Graduacao
	protected enum NotasPos{
		D(1), C(2), B(3), A(4);
		private float nota;
		
		private NotasPos( float nota ) {
			this.nota = nota;
		}
		public float getNota() {
			return nota;
		}
		//Metodo que converte a nota float em NotaPos
		public static NotasPos converteNota( float nota ) {
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
	
	//Sobrescrita de metodos abstratos de Aluno
	@Override
	public void adicionaNota( float nota ) {
		NotasPos notapos = NotasPos.converteNota(nota);
		this.notas.add(notapos.getNota());
	}
	@Override
	public float mediaNotas() {
		float soma = 0;
        for(int i=0; i<this.notas.size(); i++)
            soma += this.notas.get(i);
        return soma / this.notas.size();
	}
	@Override
	public boolean verificarAprovacao(float nota) {
		NotasPos n = NotasPos.converteNota( nota );
		if( n.getNota() >= NotasPos.C.getNota()  ) {
			return true;
		}
		return false;
	}
	
	//Sobrecarga de construtores
	public AlunoPos(String nome, String cpf , Professor orientador) {
		super(nome, cpf);
		this.orientador = orientador;
	}
	public AlunoPos(String nome, String cpf) {
		this(nome, cpf, null);
	}	
	
	//Metodos getters e setters
	public Professor getNomeOrientador() {
		return orientador;
	}

	public void setNomeOrientador(Professor nomeOrientador) {
		this.orientador = nomeOrientador;
	}
}
