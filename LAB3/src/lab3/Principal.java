/*Nome: Gabriel Volpato Giliotti ra:197569*/
/*Na classe principal, utilizamos o modelo de codigo sugerido, pois o enunciado está dificil de se interpretar*/

package lab3;

import mc302ef.GerenciadorDisciplinas;
import mc302ef.GerenciadorFuncionarios;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		/*
		 * Parte 1
		 * Leitura de disciplinas e alunos
		 */
		String[][] disciplinas_info = GerenciadorDisciplinas.getDisciplinas();
		int discId;
		String discNome;
		
		ArrayList <Disciplina> disc = new ArrayList <Disciplina> (); //disc é um array list de objetos disciplina
		
		
		// Exibição das disciplinas (Para entendimento do código)
		//System.out.println("Disciplinas:"); // TODO: remover print
		for (int i = 0; i < disciplinas_info.length; i++) {
			discId = Integer.parseInt(disciplinas_info[i][0]);
			discNome = disciplinas_info[i][1];
			
			//System.out.println("ID: " + discId + ", NOME: " + discNome); // TODO: Remover print
			// TODO: Instânciar Disciplinas
			Disciplina novaDisciplina = new Disciplina( discId, discNome );
				
			// Alunos
			int[] matriculasAlunos = GerenciadorDisciplinas.getAlunosPorDisciplina( discId );
			// TODO: Adicionar matrículas dos alunos à respectiva disciplina
			int j;
			for( j=0; j < matriculasAlunos.length; j++) {
				novaDisciplina.adicionarMatricula(matriculasAlunos[j]);
				//System.out.println(matriculasAlunos[j]);
			}
					
			disc.add(novaDisciplina);
		}
		/*
		 * Parte 2
		 * Busca/remoção e exibição
		 */
	
		int[] alunos_para_remover = GerenciadorDisciplinas.getAlunosARemover();
		
		// TODO: Remova os alunos listados
		for(int i=0; i < disc.size(); i++ ) {
			for(int j=0; j<alunos_para_remover.length; j++) {
				disc.get(i).removerMatricula(alunos_para_remover[j]);
			}
		}
				
		// TODO: Exiba todos os alunos por disciplina
		for(int i = 0; i < disc.size(); i++) {
			disc.get(i).ordenarLista();
			disc.get(i).imprimeDados();
		}
		
		/*
		 * Parte 3
		 * Cadastro de funcionários
		 */
		
		GerenciadorFuncionarios sim = new GerenciadorFuncionarios();
		String[] funcionario_info;
		String funcNome, funcCPF;
		
		ArrayList <Funcionario> funcionarios = new ArrayList <Funcionario> ();
		
		// <...> funcionarios = new <...>; Estrutura para armazenar instâncias de funcionários
		while ( (funcionario_info = sim.getNextFuncionario()) != null) {
			funcNome = funcionario_info[GerenciadorFuncionarios.NOME];
			funcCPF = funcionario_info[GerenciadorFuncionarios.CPF];

			// TODO: Instanciar funcionarios e armazenar em estrutura apropriada.
			Funcionario novoFunc = new Funcionario( funcNome, funcCPF );
			funcionarios.add( novoFunc );
		}
		
		/*Laço que printa os funcionarios e seus respectivos cpf´s que foram armazenados no ArrayList funcionarios*/
		
		System.out.println("\nFuncionarios cadastrados: ");
		for(int l = 0; l < funcionarios.size(); l++) {
			System.out.println("Nome: " + funcionarios.get(l).getNome() + " Cpf: " + funcionarios.get(l).getCpf());
		}
	}
}

