package br.com.jkavdev.fj21.jdbc.teste;

import java.util.Calendar;

import br.com.jkavdev.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.fj21.jdbc.modelo.Contato;

public class TestaAtualizacao {
	
	public static void main(String[] args) {
		
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setId(2L);
		contato.setNome("caelum");
		contato.setDataNascimento(Calendar.getInstance());
		
		contatoDao.alterar(contato);
		
		System.out.println("Alterou");
		
	}

}
