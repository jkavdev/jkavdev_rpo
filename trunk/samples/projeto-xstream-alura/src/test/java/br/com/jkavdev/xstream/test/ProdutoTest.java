package br.com.jkavdev.xstream.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.jkavdev.xstream.model.Produto;

public class ProdutoTest {
	
	@Test
	public void deveGerarXmlComNomePrecoDescricaoAdequados(){
		
		String xmlEsperado = 
				"<produto codigo=\"1587\">\n"
					+ "  <nome>Geladeira</nome>\n"
					+ "  <preco>1000.0</preco>\n"
					+ "  <descrição>Geladeira duas portas</descrição>\n"
				+ "</produto>";
		
		Produto geladeira = new Produto(1587, "Geladeira", 1000.0, "Geladeira duas portas");
		
		XStream xstream = new XStream();
		
		//criando apelido para a tag produto
		xstream.alias("produto", Produto.class);
		
		//criando um apelido para um campo
		xstream.aliasField("descrição", Produto.class, "descricao");
		
		//atribuindo um valor
		xstream.useAttributeFor(Produto.class, "codigo");
		
		String xmlGerado = xstream.toXML(geladeira);
		
		assertEquals(xmlEsperado, xmlGerado);
		
	}

}
