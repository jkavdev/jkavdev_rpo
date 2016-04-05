package br.com.jkavdev.fj21.jdbc.teste;

import java.util.Calendar;

import br.com.jkavdev.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.fj21.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setNome("Jhonatan");
		contato.setEmail("jhonatan@gmail.com");
		contato.setEndereco("Qr 12 Casa 15");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		
		contatoDao.adiciona(contato);
		
		System.out.println("Gravado");

	}

}
