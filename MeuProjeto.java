package myClasses;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import org.apache.axiom.c14n.omwrapper.interfaces.NodeList;
import org.apache.jena.ontology.Ontology;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.riot.RDFLanguages;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.LocationMapper;
import org.apache.jena.riot.system.stream.JenaIOEnvironment;


import org.neontoolkit.core.ExtendedAnnotatedBuilder;
import org.semanticweb.owl.align.Alignment;
import org.semanticweb.owl.align.AlignmentProcess;
import org.semanticweb.owl.align.AlignmentVisitor;
import org.semanticweb.owl.align.Cell;
import org.semanticweb.owl.align.Evaluator;

import com.sun.jndi.toolkit.url.Uri;

import fr.inrialpes.exmo.align.impl.BasicAlignment;
import fr.inrialpes.exmo.align.impl.BasicCell;
import fr.inrialpes.exmo.align.impl.DistanceAlignment;
import fr.inrialpes.exmo.align.impl.ObjectAlignment;
import fr.inrialpes.exmo.align.impl.eval.PRecEvaluator;
import fr.inrialpes.exmo.align.impl.method.ClassStructAlignment;
import fr.inrialpes.exmo.align.impl.method.NameAndPropertyAlignment;
import fr.inrialpes.exmo.align.impl.method.StringDistAlignment;
import fr.inrialpes.exmo.align.impl.method.StrucSubsDistAlignment;
import fr.inrialpes.exmo.align.impl.renderer.RDFRendererVisitor;
import fr.inrialpes.exmo.align.parser.AlignmentParser;
import fr.inrialpes.exmo.ontowrap.owlapi30.OWLAPI3Ontology;


public class MeuProjeto{
	public static void main( String[] args ) throws Exception {

		URI onto1 = null;
		URI onto2 = null;
		Properties params = new Properties(); //Instanciando uma variavel do tipo Properties    

		try {
			onto1 = new URI ("file:///home/giliotti/workspace/alignapi/html/tutorial/CBO.owl");
			onto2 = new URI ( "file:///home/giliotti/workspace/alignapi/html/tutorial/gfo-bio.owl" );
			//CBO e gfo-bio sao ontologias retiradas do site BioPortal
			

			//Alignment: Descreve um alinhamento particular, contendo uma especificação do alinhamento e uma lista de Cells.
			//Cell : Descreve uma correspondencia particular entre Entidades das ontologias
			//Entidades: no caso do teste sao Objetos.
			
			
			AlignmentProcess a1 = new StringDistAlignment(); 
			//AlignmentProcess a2 = new StrucSubsDistAlignment(); 
			
			/*
			 * AlignmentProcess EH UMA INTERFACE IMPLEMENTAVEL, ONDE PODEMOS CRIAR NOSSO PROPRIO PROCESSO
			 * DE ALINHAMEENTO (NA DOCUMENTACAO TEM ALGUMAS DICAS)
			 */
			
			params.setProperty("stringFunction","smoaDistance");
			//params.setProperty("stringFunction","subStringDistance");
								   //Chave          //Valor
			
			a1.init ( onto1, onto2 ); 
			//a2.init ( onto1, onto2 );

	
			OWLAPI3Ontology o1 = (OWLAPI3Ontology) SalvaDados.getO1();
  			OWLAPI3Ontology o2 = (OWLAPI3Ontology) SalvaDados.getO2();
  			
  	/*		
  	 * 		DESCOMENTAR ESSA PARTE DO CODIGO FAZ COM QUE SEJA PRINTADO CADA classes E Entities 
  	 * 		DAS ONTOLOGIAS 1 E 2
  	 */
  			
  	/*		
  			System.out.println("Conceitos que representam CLASSES na Ontologia 1: ");
			Set<? extends Object> s1 =  o1.getClasses();
			s1.forEach(System.out::println);
 
			
			System.out.println("Conceitos que representam CLASSES na Ontologia 2: ");
			Set<? extends Object> s2 =  o2.getClasses();
			s2.forEach(System.out::println);
	*/
  	/*		
			System.out.println("Conceitos que apresentam ENTITIES na Ontologia 1: ");
			Set<? extends Object> s11 = o1.getEntities();
			s11.forEach(System.out::println);

			System.out.println("Conceitos que apresentam ENTITIES na Ontologia 2: ");
			Set<? extends Object> s22 = o2.getEntities();
			s22.forEach(System.out::println);						
	*/
  	
  	/*		
			System.out.println("Conceitos que apresentam PROPERTIES na Ontologia 1: ");
			Set<? extends Object> s111 = o1.getEntities();
			s111.forEach(System.out::println);

			System.out.println("Conceitos que apresentam PROPERTIES na Ontologia 2: ");
			Set<? extends Object> s222 = o2.getEntities();
			s222.forEach(System.out::println);	
	*/		
			
			a1.align( (Alignment)null, params ); 
			//a2.align( (Alignment)null, params );	
			
			/*
			 * Parser EH UM OBJETO QUE PODEMOS INSTANCIAR AQUI (DESCOMENTANDO O CODIGO ABAIXO) QUE REALIZA
			 * UM PROCESSO DE LEITURA E INTERPRETACAO DE UMA URI PASSADA COM PARAMETRO, ISTO EH, O Parser 
			 * ABRE O ARQUIVO INDERECADO PELA URI, LE INTERPRETA E SALVA ESSE ARQUIVO EM UMA INTANCIA DE
			 * OBJETO QUE SERA UTILIZADA MAIS TARDE (NO CASO Alignment reference) .
			*/
			
			//AlignmentParser aparser = new AlignmentParser();
			//Alignment reference = aparser.parse( new File("html/tutorial/EcologyTrack/flopo-pto.rdf" ).toURI() );
			//Evaluator evaluator = new PRecEvaluator ( reference, a1 );
			//evaluator.eval( params );

			
			
			//a1.cut ( 0.3 );

			
			
			//PRINTANDO AS Cells GERADAS PELO ALINHAMENTO ANTES DO Writer DAR A SAIDA
			
			/*Enumeration <Cell> out = a1.getElements();
			ArrayList <Cell> celulas = new ArrayList <Cell> ();
			while( out.hasMoreElements() ) {
				celulas.add(out.nextElement());
			}
			System.out.println("Conceitos alinhados em CADA Cell Gerada: ");
			for(int i=0; i < celulas.size(); i++) {
				System.out.println(i);
				System.out.println("Ob1:" + celulas.get(i).getObject1());
				System.out.println("Ob2:" + celulas.get(i).getObject2());
				System.out.println();
			}*/
			
			
			
		/*	System.out.println("Numero de celulas consideradas: " + a1.nbCells());
			//System.out.println("Numero de celulas consideradas: " + a2.nbCells());

			//Somente da a saida no terminal
			PrintWriter writer = new PrintWriter ( 
									new BufferedWriter( 
										new OutputStreamWriter( System.out, "UTF-8" )), true);


			AlignmentVisitor renderer = new RDFRendererVisitor(writer);
			a1.render(renderer); 
			//a2.render(renderer);
			writer.flush();
			writer.close();
			
			*/
			String personURI = "http://somewhere/JohnSmith";
			String fullName = "John Smith";
			
			// create an empty Model
			Model model = ModelFactory.createDefaultModel();

			// create the resource
			Resource johnSmith = model.createResource(personURI);

			// add the property
			johnSmith.addProperty(VCARD.FN, fullName);
			
			
			} catch( Exception e ) {
					e.printStackTrace();
			}
        }
}












