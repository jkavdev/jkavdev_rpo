package br.com.jkavdev.fj21.jdbc.teste;

import br.com.jkavdev.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.fj21.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {

		ContatoDao contatoDao = new ContatoDao();

		Contato contato = contatoDao.pesquisar(1L);

		System.out.println(contato);

	}

}
