package br.unifenas.project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class LerXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SAXBuilder builder = new SAXBuilder();
		File arquivoXML = new File("clientes.xml");
		
		try {
			Document doc = (Document)builder.build(arquivoXML);
			
			Element root = doc.getRootElement();
			
			List<Element> lista = root.getChildren("cliente");
			
			for (int i = 0; i < lista.size(); i++) {
				Element c = lista.get(i);
				
				System.out.println("Nome: " + c.getChildText("nome"));
				System.out.println("Idade: " + c.getChildText("idade"));
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
