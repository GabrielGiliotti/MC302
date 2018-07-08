/*
 * $Id: Skeleton.java 1404 2010-03-31 08:53:09Z euzenat $
 *
 * Copyright (C) INRIA, 2006-2008, 2010
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */

// Alignment API classes
import org.semanticweb.owl.align.Alignment;
import org.semanticweb.owl.align.AlignmentProcess;
import org.semanticweb.owl.align.AlignmentVisitor;

// Alignment API implementation classes
import fr.inrialpes.exmo.align.impl.BasicAlignment;
import fr.inrialpes.exmo.align.impl.BasicParameters;
import fr.inrialpes.exmo.align.impl.method.StringDistAlignment;
import fr.inrialpes.exmo.align.impl.renderer.RDFRendererVisitor;

// SAX standard classes
import org.xml.sax.SAXException;

// Java standard classes
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.File;
import java.net.URI;
import java.util.Properties;

/**
 * The Skeleton of code for embeding the alignment API
 *
 * Takes two files as arguments and align them.
 */

	public class Skeleton {

	    public static void main( String[] args ) {
    		URI onto1 = null; //Objeto do tipo URI inicialmente nulo, que eh recebido na linha de comando
    		URI onto2 = null; //Objeto do tipo URI inicialmente nulo, que eh recebido na linha de comando
    		Properties params = new Properties(); //Objeto do tipo Properties utilizado no alinhamento de ontologias
	
    		try {
    			// Bloco que verifica se as URI`s estão sendo recebidos corretamente da linha de comando
    			if (args.length >= 2) {
    				onto1 = new URI( args[0] ); //Argumento na posicao 0 eh a ontologia 1
    				onto2 = new URI( args[1] ); //Argumento na posicao 1 eh a ontologia 2
    			} else {
    				System.err.println("Need two arguments to proceed"); //Caso nao seja recebido uma das URI`s 
    				return ; //A mensagem eh printada e a aplicacao eh finalizada pelo retorno.
    			}

    			//Alinhamento:
    			AlignmentProcess a1 = new StringDistAlignment(); //Instanciando um processo de alinhamento a1;
    			params.setProperty("stringFunction","smoaDistance"); //setProperty("chave", "valor");
    			a1.init ( onto1, onto2 ); //Atribui as URIS recebidas na linha de comando para os atributos onto1 e onto2;
    			a1.align( (Alignment)null, params ); //Realiza o metodo alinhamento smoaDistance, que é um valor de params; 
							     //smoaDistance é uma classe que realiza o alinhamento.
			//Mesmos procedimentos para um segundo processo de alinhamento a2,
			//porém o novo metodo de alinhamento usado eh ngramDistance;
			//ngramDistance tambem eh uma classe que realiza o alinhamento; 			
			AlignmentProcess a2 = new StringDistAlignment();
			params.setProperty("stringFunction","ngramDistance");
			a2.init ( onto1, onto2 );
    			a2.align( (Alignment)null, params );

			System.out.println( " " );
			
			//Clonagem:
			//Para provar a quantidade entidades presentes em um processo de alinhamento, realizamos:
			System.out.println( "Numero de entidades do alinhamento a1: " + a1.nbCells() );
			//Usando metodo clone na manipulacao de alinhamentos:			
			BasicAlignment a3 = (BasicAlignment)(a1.clone()); //Fazendo um novo atributo de alinhamento a3,
			//Agora com o tipo BasicAlignment e utilizando cast em a1 para poder ser recebido com o metodo clone 
			//Entao printamos para mostrar a ocorrencia do mesmo numero de entidades:
			System.out.println( "Numero de entidades do alinhamento a3: " + a3.nbCells() );

			
			//Fusão de dois alinhmentos:
			a3.ingest ( a2 ); //Usando metodo ingest para realizar o merge entre os resultados a3 e a2;		
			//Apos o merge, o numero de entidades deve ter sido modificado, entao printamos novamente:			
			System.out.println( "Numero de entidades de a3 apos merge com a2: " + a3.nbCells() );

			//Inversão de um alinhamento:
			BasicAlignment a4 = a3.inverse();
			//Como ainda nao foi possivel mostrar efetivamente os alinhamentos invertidos,
			//Eu criei dois atributos o1 e o2 que receberam onto1 de a3 e onto2 de a4 respectivamente;
			//Como sao alinhamentos invertidos, as ontologias de a3 e a4 sao invertidas, assim
			//onto1 de a3 eh IGUAL a onto2 de a4 e,
			//por fim, criei uma verificacao para provar a inversao:			
			Object o1 = a3.getOntologyObject1();
			Object o2 = a4.getOntologyObject2();
			if( o1.equals(o2) == true ) {
				System.out.println( "Processo de inversao realizado com SUCESSO !");
			} else {
				System.out.println( "Processo de inversao COM PROBLEMAS !");
			}
		
			//Eliminar alinhamentos abaixo de 0.5
			System.out.println( "Num total de alinhamentos considerados ANTES do metodo cut: " + a4.nbCells());
			a4.cut ( .5 ); //Elimina os alinhamentos abaixo de 0.5
			System.out.println( "Num total de alinhamentos considerados APOS o metodo cut: " + a4.nbCells());
			//Mostra a diminuicao do numero de alinhamentos considerados apos o uso do metodo cut !			
			
			System.out.println( " " );

			//Avaliando alinhamentos:





    			// Outputing
    			PrintWriter writer = new PrintWriter (
    						   new BufferedWriter(
    							new OutputStreamWriter( System.out, "UTF-8" )), true);
    			AlignmentVisitor renderer = new RDFRendererVisitor(writer);
    			a1.render(renderer);
    			writer.flush();
    			writer.close();

    		} catch (Exception e) { 
    			e.printStackTrace(); 
    		};
    	    }
	}





