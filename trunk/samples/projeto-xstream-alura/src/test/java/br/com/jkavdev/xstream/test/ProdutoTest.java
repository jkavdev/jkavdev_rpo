package br.com.jkavdev.xstream.test;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.jkavdev.xstream.model.Produto;

public class ProdutoTest {
	
	@Test
	public void deveGerarXmlComNomePrecoDescricaoAdequados(){
		
		String xmlEsperado = 
				"<produto>"
					+ " <nome>Geladeira</nome>"
					+ "<preco>1000.0</preco>"
					+ "<descricao>Geladeira duas portas</descricao>"
				+ "</produto>";
	

		
		Produto geladeira = new Produto("Geladeira", 1000.0, "Geladeira duas portas");
		
		new XStream();
		
	}

}
