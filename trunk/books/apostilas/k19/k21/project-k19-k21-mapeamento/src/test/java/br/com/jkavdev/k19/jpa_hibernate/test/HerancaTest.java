package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.heranca.PessoaFisica;
import br.com.jkavdev.k19.jpa_hibernate.model.heranca.PessoaJuridica;

public class HerancaTest extends AbstractJUnitConfig{
	
	@Test
	public void insertPessoa(){
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpf("0454564");
		pessoaFisica.setNome("Jhonatan");
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj("65465498");
		pessoaJuridica.setNome("Banco Nacional");
		
		beginTransaction();
		
		this.getManager().persist(pessoaJuridica);
		this.getManager().persist(pessoaFisica);
		
		commit();
		
	}

}
