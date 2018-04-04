/*Nome: Gabriel Volpato Giliotti ra:197569*/

package lab3;

import java.util.Arrays; //Importamos a classe Arrays para trabalhar com arrays estaticos de tamanho maximo 25

public class Disciplina {
	/*Atributos minimos sugeridos no enunciado*/
	public static final int NUM_MAX_ALUNOS = 25;
	private final int idDisciplina; //o id não pode ser alterado, entao recebe final
	private String nomeDisciplina;
	private int[] listaMatriculas;
	private int indice;
	
	/*Metodo contrutor que define/recebe o id, o nome de um objeto define o vetor estatico de matriculas que são numeros inteiros */
	public Disciplina(int idDisciplina, String nomeDisciplina ) {
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.listaMatriculas = new int[NUM_MAX_ALUNOS];
	}
	
	/*Metodos setters e getters necessarios para acessar e modificar os atributos da classe */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int[] getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(int[] listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	//Metodo que remove uma matricula recebida como argumento;
	public void removerMatricula( int matricula ) {
		int i;
		for(i=0; i<this.listaMatriculas.length; i++) { //percorre o vetor de matriculas de UMA disciplina especifica
			if( this.listaMatriculas[i] == matricula ) { //Se o array na posição i for igual a matricula, seta para zero
				this.listaMatriculas[i] = 0;
			}
		}
	}
	
	//Para adicionar as matriculas, apenas acessamos a lista em um indice
	public void adicionarMatricula( int matricula ) {
		this.listaMatriculas[indice] = matricula; //inserimos os dados
		this.indice += 1; //incrementamos o indice
	}
	//Para dar os prints corretos ordemos a lista com a funçaõ sort
	public void ordenarLista() {	
		int cont=0;
		Arrays.sort(this.listaMatriculas); 
		for(int i = 0; i < this.listaMatriculas.length; i++) { //E com esse trecho deslocamos os numeros para o inicio do vetor, ja ordenado
			if( this.listaMatriculas[i] != 0) {
				for(int j = i; j>cont; j-- ) {
					this.listaMatriculas[j-1] =  this.listaMatriculas[j];
					this.listaMatriculas[j] = 0;
				}
				cont +=1;//Cont aqui serve para auxiliar no deslocamento das matriculas para o inicio, para que nao se sobreponha os numeros
			}
		}
	
	}
	//Função para imprimir dados no formato definido no enunciado;
	public void imprimeDados() {
		int i;
		System.out.println(this.nomeDisciplina + "(" + this.idDisciplina +")");
		System.out.print("[");
		for(i=0; i < this.listaMatriculas.length-1; i++) {
			if(this.listaMatriculas[i] != 0 ) {
				System.out.print(this.listaMatriculas[i]);
				if( this.listaMatriculas[i+1] != 0) {
					System.out.print(",");
				}
			}
		}
		System.out.println("]");
	}
}
