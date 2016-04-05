package br.com.jkavdev.fj21.jdbc.teste;

import java.util.List;

import br.com.jkavdev.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.fj21.jdbc.modelo.Contato;

public class TestaLista {
	
	public static void main(String[] args) {
		
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> contatos = contatoDao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNascimento() + "\n");
		}
		
	}

}
