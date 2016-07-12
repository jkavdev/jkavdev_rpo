package br.com.jkavdev.xstream.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.jkavdev.xstream.model.Produto;

public class ProdutoTest {
	
	@Test
	public void deveGerarXmlComNomePrecoDescricaoAdequados(){
		
		String xmlEsperado = 
				"<produto>\n"
					+ "  <nome>Geladeira</nome>\n"
					+ "  <preco>1000.0</preco>\n"
					+ "  <descricao>Geladeira duas portas</descricao>\n"
				+ "</produto>";
		
		Produto geladeira = new Produto("Geladeira", 1000.0, "Geladeira duas portas");
		
		XStream xstream = new XStream();
		
		xstream.alias("produto", Produto.class);
		
		String xmlGerado = xstream.toXML(geladeira);
		
		assertEquals(xmlEsperado, xmlGerado);
		
	}

}
