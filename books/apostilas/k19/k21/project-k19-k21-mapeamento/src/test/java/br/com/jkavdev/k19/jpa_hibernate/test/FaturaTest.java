package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Fatura;
import br.com.jkavdev.k19.jpa_hibernate.model.Ligacao;

public class FaturaTest extends AbstractJUnitConfig{
	
	@Test
	public void insertLigacao(){
		
		Ligacao ligacao = new Ligacao();
		ligacao.setDuracao(162);
		
		Ligacao ligacao1 = new Ligacao();
		ligacao1.setDuracao(324);
		
		Fatura fatura = new Fatura();
		fatura.setVencimento(new GregorianCalendar(2012, 11, 20));
		
		fatura.getLigacoes().add(ligacao);
		fatura.getLigacoes().add(ligacao1);
		
		ligacao.setFatura(fatura);
		ligacao1.setFatura(fatura);
		
		beginTransaction();
		
		this.getManager().persist(fatura);
		this.getManager().persist(ligacao);
		this.getManager().persist(ligacao1);
		
		commit();
		
	}

}
