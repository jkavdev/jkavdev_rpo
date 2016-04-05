package br.com.jkavdev.fj21.jdbc.teste;

import br.com.jkavdev.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.fj21.jdbc.modelo.Contato;

public class TestaRemove {
	
	public static void main(String[] args) {
		
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setId(1L);
		
		contatoDao.remove(contato);
		
		System.out.println("Removido");
		
	}

}
