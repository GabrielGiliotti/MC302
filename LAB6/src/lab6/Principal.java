package lab6;

import mc302ef.GerenciadorAlunos;
import mc302ef.GerenciadorDisciplinas;

import java.util.ArrayList;

// é necessario um metodo main para se rodar os outros metodos da classe Principal;
public class Principal {
	public static void main( String[] args) {
		ArrayList<Aluno> alunos = testaInclusaoAlunos(); // O primeiro metodo retorna um ArrayList de Alunos, para ser enviado para o segundo metodo. 
		testaInscricaoEmDisciplinas(alunos);
	}
	
	public static ArrayList<Aluno> testaInclusaoAlunos() {
		
		ArrayList<Aluno> alunosLidos = new ArrayList<Aluno>(); //alunosLidos é o ArrayList que guarda os alunos importados pelo pacote mc302ef;
															   //Criado para retornar os alunos que foram matriculados nas disciplinas.
		
		ArrayList<String[]> infoAlunos = GerenciadorAlunos.getListaAlunos(); //instacia de um ArrayList de String que ira guardar as informações dos alunos(objetos alunos); 
		String vinculo, nome, cpf; 											// do pacote mc302ef
		int curso;
		
		//Para cada objeto Aluno de infoAlunos, campo atribui as informações de vinculo, nome,cpf e curso;
		for (String[] campo : infoAlunos) {
			vinculo = campo[GerenciadorAlunos.I_VINCULO];
			nome    = campo[GerenciadorAlunos.I_NOME];
			cpf     = campo[GerenciadorAlunos.I_CPF];
			curso   = Integer.parseInt( campo[GerenciadorAlunos.I_CURSO] );
			
			if (vinculo.equalsIgnoreCase(GerenciadorAlunos.GRADUACAO) ) {
				AlunoGraduacao alGrad = new AlunoGraduacao (nome, cpf, vinculo, curso); //instanciacao dos alunos de graduacao
				alGrad.imprimeDados(); //Impressão dos seus dados dos alunos de graduacao;
				alunosLidos.add(alGrad); // adicionando o objeto instancia da GRADUACAO no ArrayList alunosLidos
			} else {
						
				if (vinculo.equalsIgnoreCase(GerenciadorAlunos.MESTRADO) ) {
					AlunoMestrado alMest = new AlunoMestrado(nome, cpf, vinculo, curso); //instanciacao dos alunos de mestrado
					if( campo[GerenciadorAlunos.I_QUALIFICADO].equals("False")) { //Verifica se os aluno NAO foi qualificado no EQM
						alMest.setExameQualificado(false);
					}else{
						alMest.setExameQualificado(true);
					}
					if( campo[GerenciadorAlunos.I_INGLES_APROVADO].equals("True")) { //Verifica se o aluno FOI comprovado em ingles
						alMest.setInglesComprovado(true);
					}else{
						alMest.setInglesComprovado(false);
					}
					alMest.imprimeDados(); //Impressao dos dados dos alunos de Pos: Mestrado
					alunosLidos.add(alMest); // adicionando o objeto instacia do MESTRADO no ArrayList alunosLidos
					
				} else if (vinculo.equalsIgnoreCase(GerenciadorAlunos.DOUTORADO) ) {
					
					AlunoDoutorado alDout = new AlunoDoutorado(nome, cpf, vinculo, curso); //instanciacao dos alunos de doutorado
					if( campo[GerenciadorAlunos.I_QUALIFICADO].equals("False")) {  //Verifica se os aluno NAO foi qualificado no EQM
						alDout.setExameQualificado(false);
					}else{
						alDout.setExameQualificado(true);
					}
					if( campo[GerenciadorAlunos.I_INGLES_APROVADO].equals("True")) { //Verifica se o aluno FOI comprovado em ingles
						alDout.setInglesComprovado(true);
					}else{
						alDout.setInglesComprovado(false);
					}
				
					alDout.imprimeDados(); //Impressao dos dados dos alunos da Pos: Doutorado
					alunosLidos.add(alDout);  // adicionando o objeto instancia do DOUTORADO no ArrayList alunosLidos
				}
			}
		}	
		return alunosLidos; //Retorna o Arraylist de TODOS OS ALUNOS instaciados
	}
	
	//Recebendo Arraylist alunosLidos como argumento
	public static void testaInscricaoEmDisciplinas(ArrayList<Aluno> alunos) { //Alunos aqui eh alunosLidos
		
		//criando um ArrayList de disciplinas;
		ArrayList<Disciplina> listaDiscs = new ArrayList<Disciplina>();

		
		//Pegando as disciplinas pelo metodo do gerenciador importado em mc302ef;
		String[][] disciplinasInfo = GerenciadorDisciplinas.getDisciplinas();
		int discId;
		String discNome;
		
		//para cada disciplina do vetor de strings(matriz) disciplinasInfo
		for(String[] d : disciplinasInfo) {
			//pego as informações de cada disciplina em cada iteração;
			discId = Integer.parseInt(d[GerenciadorDisciplinas.ID]); //pega o id;
			discNome = d[GerenciadorDisciplinas.NOME]; //pega o nome;
			Disciplina novaDisc = new Disciplina(discId, discNome); //Instancio um objeto que guarda nome e id;
			listaDiscs.add(novaDisc); //Guardo esse novo objeto no array list de disciplinas
			//novaDisc.imprimeDados();
			
		}
		
		
		//instacia de um ArrayList de String que ira guardar as informações dos alunos(objetos alunos) do pacote mc302ef
		ArrayList<String[]> infoAlunos = GerenciadorAlunos.getDisciplinasPorCpfAluno();
		String cpfAluno; //Nesse caso temos os cpfs e os ids das disciplinas associados a cada numero de cpf
		int idDisciplina;
		
		
		for (String[] params : infoAlunos) {
			cpfAluno = params[0]; //cpf do aluno sempre esta na coluna 0 da matriz que guarda o cpf + as disciplinas
			
			for (int i = 1; i < params.length; i++) { //percorremos as colunas a partir de 1, para pegarmos as disciplinas
				idDisciplina = Integer.parseInt(params[i]);
		
				for(int j = 0; j< listaDiscs.size(); j++) { //percorre arrayList de disciplina para achar o objeto Disciplina com idDisciplina
					if( listaDiscs.get(j).id == idDisciplina ) { //verifico se lista de objetos disciplinas(listaDiscs) apresenta um determinado id que infoAlunos apresenta 
																//isto eh, se a disciplina que o aluno tem vinculado a seu cpf esta presente nas disciplinas 
						for(int k = 0; k < alunos.size(); k++) { //percorre arrayList de aluno para achar o objeto Aluno com cpfAluno
							if( alunos.get(k).getCpf().equals(cpfAluno) ) { //percorro os alunos lidos para verificar os cpfs e adicionar aluno com sua diciplina e vice-versa
								alunos.get(k).addDisciplina(listaDiscs.get(j)); //Vinculo as disciplinas na lista do objeto aluno
								listaDiscs.get(j).addAluno(alunos.get(k)); //Vinculo o aluno nas lista de Alunos da disciplina
								//achados os objetos Aluno e Disciplina, adicionar com os respectivos metodos, um no outro
							}
						}
					}
				}	
			}	
		}
	}
}
