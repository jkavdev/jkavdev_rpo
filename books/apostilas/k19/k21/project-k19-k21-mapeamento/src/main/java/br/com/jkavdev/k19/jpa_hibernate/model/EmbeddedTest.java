package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.test.AbstractJUnitConfig;

public class EmbeddedTest extends AbstractJUnitConfig{
	
	@Test
	public void insertCandidato(){
		
		Endereco endereco = new Endereco();
		endereco.setEstado("São Paulo");
		endereco.setCidade("São Paulo");
		endereco.setLogradouro("Qr 12 Casa 15");
		endereco.setNumero(25);
		
		Candidato candidato = new Candidato();
		candidato.setNome("Jhonatan");
		candidato.setNascimento(new GregorianCalendar(10, 5, 1994));
		candidato.setEndereco(endereco);
		
		beginTransaction();
		
		this.getManager().persist(candidato);
		
		commit();
	}

}
