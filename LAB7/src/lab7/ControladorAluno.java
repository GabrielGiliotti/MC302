package lab7;

import java.util.ArrayList;

public class ControladorAluno {
	
	private ArrayList <Aluno> listaDeAlunos;
	
	public ControladorAluno(ArrayList<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}
	
	//Metodo que recebe uma lista de Alunos e busca um Aluno pela sua matricula informada  
		public Aluno buscaAluno( int matricula ) { //Recebe o numero da matricula e a lista de alunos
			for( Aluno a: this.listaDeAlunos ) { //laço que percorre a lista de alunos 
				if( matricula == a.getMatricula()) { // se a matricula fornecida for igual a de um aluno
					return a; // Retornamos o Aluno
				}
			}
			return null; // Caso nenhum aluno com a matricula dada seja encontrado, retornamos null como objeto
		}
		
		//Metodo que recebe uma lista de Alunos e busca um Aluno pelo cpf informado  
		public Aluno buscaAluno( String cpf ) {//Recebe a string cpf e a lista de alunos
			for( Aluno a : this.listaDeAlunos ) { //laço que percorre a lista de alunos 
				if( cpf.equals(a.getCpf())) { // se o cpf fornecido for igual a de um aluno
					return a; //Retornamos o Aluno
				}
			}
			return null; // Caso nenhum aluno com o cpf dado seja encontrado, retornamos null como objeto
		}
		
		//Metodo que recebe uma lista de Alunos e busca um Aluno pelo cpf e pelo curso dado 
		public Aluno buscaAluno( String cpf , Curso curso) { //Recebe cpf, o curso, e o ArrayList para buscar um aluno segundo sua as informações solicitadas
			for( Aluno a : this.listaDeAlunos ) { //laço que percorre a lista de alunos 
				if(  cpf.equals(a.getCpf())  ) { // se o cpf fornecido for igual a de um aluno
					if(  curso.equals(a.getCurso())  ) { // e o curso que esse aluno esta matriculado é igual ao solicitado
						return a; //retornamos o aluno
					}
				}
			}
			return null; // Caso nenhum aluno com o cpf e/ou curso dado seja encontrado, retornamos null como objeto
		}
		
		//Metodo que recebe uma lista de Alunos e busca um Aluno pelo cpf e pelo curso dado 
		public Aluno buscaAluno( String nome , Disciplina disciplina) { //Recebe cpf, o curso, e o ArrayList para buscar um aluno segundo sua as informações solicitadas
			for( Aluno a : this.listaDeAlunos ) { //laço que percorre a lista de alunos 
				if(  nome.equals(a.getNome())  ) { // se o nome fornecido for igual a de um aluno
					for( Disciplina d: a.getDisciplinas()) { //Vamos em sua lista de disciplinas, e buscamos a disciplina solicitada
						if( disciplina.equals(d)) { //Se a disciplina solicitada for encontrada
							return a; //retornamos o aluno
						}
					}
				}
			}
			return null; // Caso nenhum aluno com o nome e/ou disciplina dado seja encontrado, retornamos null como objeto
		}
		
			
		//metodos para adicinar e remover Aluno
		public void adicionaAluno ( Aluno aluno ) {
			this.listaDeAlunos.add(aluno);
		}
		
		public void removeAluno ( Aluno aluno ) {
			for(Aluno a: listaDeAlunos ) {
				if( a.equals(aluno) ) {
					listaDeAlunos.remove(a);
				}
			}
		}	
}
