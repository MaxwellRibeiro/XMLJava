package br.unifenas.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import br.unifenas.model.Cliente;

public class CriarXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Maxwell", 20));
		clientes.add(new Cliente("Maria", 18));
		clientes.add(new Cliente("Joana", 21));
		
		Element Clientes = new Element("clientes");
		Document doc = new Document(Clientes);
		
		int id = 0;
		for (Cliente cliente : clientes) {
			id++;
			
			Element c = new Element("cliente");
			c.setAttribute(new Attribute("Id",Integer.toString(id)));
			c.addContent(new Element("nome").setText(cliente.getNome()));
			c.addContent(new Element("idade").setText(Integer.toString(cliente.getIdade())));
			
			doc.getRootElement().addContent(c);
		}
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		
		try {
			xmlOutput.output(doc, new FileWriter("clientes.xml"));
			System.out.println("Arquivo gerado com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
