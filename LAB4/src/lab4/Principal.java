/*Nome: Gabriel Volpato Giliotti  RA:197569*/

//Onde devo instanciar os objetos para testar as classes extendidas e o arraylist de Pessoa

package lab4;

public class Principal {

	public static void main(String[] args) {
		
		MeuArray listaGeral = new MeuArray(); //Estancia da classe MeuArray para se guardar os dados de todas as classes, ou seja, listaGeral é um ArrayList de Pessoa
		//Este objeto estanciado gera um ArrayList do tipo pessoa para se guardar os dados e ordená-los
		
		//Instanciando objetos do tipo Aluno
		Aluno a1 = new Aluno ("Gabriel", "123.456.789-00", 7.5, Aluno.ESTADO_APROVADO);
		Aluno a2 = new Aluno ("Ana Carolina", "987.654.321-40", 9.5, Aluno.ESTADO_APROVADO);
		Aluno a3 = new Aluno ("Eduardo", "456.213.798-13", 2.7, Aluno.ESTADO_EXAME);
		Aluno a4 = new Aluno ("Natalia", "654.132.879-05", 1.4, Aluno.ESTADO_REPROVADO);
		Aluno a5 = new Aluno ("Monica", "798.456.321-20", 3.75, Aluno.ESTADO_EXAME);
		
		//Instanciando objetos do tipo Funcionario
		//Funcionario aqui é qualquer cargo que não de professor (Secretario, Limpeza, Manutenção, etc)
		Funcionario f1 = new Funcionario ("Jessica", "843.359.847-83", 1650.75 );
		Funcionario f2 = new Funcionario ("Diego", "759.102.276-35", 1185.25);
		Funcionario f3 = new Funcionario ("Giovanna", "581.367.062-15", 2130.35);
		Funcionario f4 = new Funcionario ("Ramon", "439.658.912-10", 1987.68);
		Funcionario f5 = new Funcionario ("Samuel", "911.524.304-69", 560.98);
		
		//Instanciando objetos do tipo Professor
		Professor p1 = new Professor ("Julio Cesar", "349.622.177-33", 15655.25, 102, 202, 302);
		Professor p2 = new Professor ("Cristian", "547.159.357-51", 20000.75, 111, 211, 311);
		Professor p3 = new Professor ("Esther", "147.936.285-22", 32500.00, 404, 358, 458) ;
		Professor p4 = new Professor ("Erika", "489.621.156-43", 29180.56, 558, 658, 909);
		Professor p5 = new Professor ("Bruna", "315,389,579-14", 25650.32, 128, 228, 328);
		
		//Adicionando todos os tipo de Pessoas estanciadas dentro de MeuArray;
		listaGeral.add(a1);		listaGeral.add(f1);		listaGeral.add(p1);
		listaGeral.add(a2);		listaGeral.add(f2);		listaGeral.add(p2);
		listaGeral.add(a3);		listaGeral.add(f3);		listaGeral.add(p3);
		listaGeral.add(a4);		listaGeral.add(f4);		listaGeral.add(p4);
		listaGeral.add(a5);		listaGeral.add(f5);		listaGeral.add(p5);
		//Repare que a adição dos objetos em MeuArray está fora de ordem;
		listaGeral.ordenaArrayList();
		
		int i;
		//Laço percorre o MeuArray que contém objetos do tipo Professor, Aluno e Funcionario
		for(i=0; i < listaGeral.size(); i++ ) { 
			if( listaGeral.get(i) instanceof Aluno) { //Se o objeto é do tipo Aluno
				((Aluno)listaGeral.get(i)).imprimeDados(); //Chama o metodo imprimeDados da classe Aluno ;
			}else if ( listaGeral.get(i) instanceof Professor ) { //Se o objeto é do tipo Professor
				((Professor)listaGeral.get(i)).imprimeDados(); //Chama o metodo imprimeDados da classe Professor;
			}else { //Se não é nenhum dos dois primeiros tipos
				((Funcionario)listaGeral.get(i)).imprimeDados(); //Então chama o metodo imprimeDados da Classe Funcionario;
			}
		}
	}
}
