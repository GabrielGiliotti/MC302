/*Nome: Gabriel Volpato Giliotti 		ra:197569*/

package lab3;

import lab3.Aluno;

public class Principal {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("AAAAA", "00000", 0, Aluno.ESTADOATIVO); /*Objetos Alunos instanciados com informações pré-definidas*/
		Aluno a2 = new Aluno("AAAAA", "00000", 0, Aluno.ESTADOSUSPENSO); /*Poderia ser feito um laço(Vetor)*/
		Aluno a3 = new Aluno("AAAAA", "00000", 0, Aluno.ESTADOINATIVO);	
		
		Funcionario f1 = new Funcionario("FFFFF", "00000"); /*Objetos Funcionarios instanciados com informaçõs pré-definidas*/
		Funcionario f2 = new Funcionario("FFFFF", "00000"); /*Poderia ser feito um laço(Vetor)*/
		Funcionario f3 = new Funcionario("FFFFF", "00000");

		/*Atribuindo informaçoes e imprimindo para Aluno a1*/
		a1.setNome("Gabriel");
		a1.setCpf("11111111111");
		a1.setCurso(42);
		a1.imprimeDados();
		System.out.println(); /*Pulando uma linha*/
		
		/*Atribuindo informaçoes e imprimindo para Aluno a2*/ 
		a2.setNome("Ana");
		a2.setCpf("22222222222");
		a2.setCurso(42);
		a2.imprimeDados();
		System.out.println(); /*Pulando uma linha*/
		
		/*Atribuindo informaçoes e imprimindo para Aluno a3*/ 
		a3.setNome("Ba");
		a3.setCpf("3333333");
		a3.setCurso(-2);
		a3.imprimeDados();
		System.out.println(); /*Pulando uma linha*/
		
		/*Atribuindo informaçoes e imprimindo para Funcionario f1*/ 
		f1.setNome("Bruno");
		f1.setCpf("44444444444");
		f1.imprimeDados();
		System.out.println(); /*Pulando uma linha*/
		
		/*Atribuindo informaçoes e imprimindo para Funcionario f2*/
		f2.setNome("Carlos");
		f2.setCpf("55555555555");
		f2.imprimeDados();
		System.out.println(); /*Pulando uma linha*/
		
		/*Atribuindo informaçoes e imprimindo para Funcionario f3*/ 
		f3.setNome("Ju");
		f3.setCpf("6666666");
		f3.imprimeDados();
		System.out.println(); /*Pulando uma linha*/
	}
}
