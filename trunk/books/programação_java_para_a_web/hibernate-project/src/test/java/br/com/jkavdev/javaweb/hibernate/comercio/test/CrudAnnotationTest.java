package br.com.jkavdev.javaweb.hibernate.comercio.test;

import java.sql.Date;

import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.javaweb.hibernate.comercio.dao.ContatoDao;
import br.com.jkavdev.javaweb.hibernate.comercio.modelo.Contato;

public class CrudAnnotationTest {

	ContatoDao contatoDao;
	Transaction transaction;
	
	@Before
	public void init(){
		contatoDao = new ContatoDao();
		transaction = contatoDao.getSession().getTransaction();
	}

	@Test
	public void testInsert() {
		transaction.begin();
		
		Contato ian = criaContato("Ian Alves", "ian@gmail.com", "99346554", "Novo Cliente");
		Contato italo = criaContato("Italo Alves", "italo@gmail.com", "99446554", "Novo Cliente");
		Contato felipe = criaContato("Felipe Alves", "felipe@gmail.com", "99344554", "Novo Cliente");

		contatoDao.salvar(ian);
		contatoDao.salvar(italo);
		contatoDao.salvar(felipe);

		transaction.commit();

	}
	
	@Test
	public void updateTest(){
		transaction.begin();
		
		Contato ian = contatoDao.buscaContato(1);
		
		ian.setObservacao("Retomar Contato");
		contatoDao.atualizar(ian);

		System.out.println("Total de registros cadastrados: " + contatoDao.listar().size());
		
		transaction.commit();
	}
	
	@Test
	public void removeTest(){
		transaction.begin();
		
		Contato felipe = contatoDao.buscaContato(2);

		System.out.println("Total de registros cadastrados: " + contatoDao.listar().size());
		contatoDao.excluir(felipe);
		System.out.println("Total de registros cadastrados: " + contatoDao.listar().size());
		
		transaction.commit();
	}

	private static Contato criaContato(String nome, String email,
			String telefone, String observacao) {

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		contato.setObservacao(observacao);
		contato.setDataCadastro(new Date(System.currentTimeMillis()));

		return contato;
	}

}
