package br.com.jkavdev.livraria.test.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.livraria.model.Aluno;
import br.com.jkavdev.livraria.model.Contato;
import br.com.jkavdev.livraria.model.Endereco;
import br.com.jkavdev.livraria.model.TipoSexo;

public class InsertTestAluno {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {

		factory = Persistence.createEntityManagerFactory("livrariaPU");
		manager = factory.createEntityManager();

	}

	@Test
	public void insertAluno() {
		beginTransaction();
		
		Endereco itapua = criaEndereco("QR 12 CASA 15", "15", "CASA", "Planaltina", "GO", "73754012");
		
		Contato contato = criaContato("36374568");
		contato.setCelular("91940455");
		contato.setEmail("jhonatan@gmail.com");
		
		Aluno jhonatan = criaAluno("Jhonatan Kolen", "Alves Viana", TipoSexo.MASCULINO);
		jhonatan.setContato(contato);
		jhonatan.setEndereco(itapua);
		
		this.manager.persist(jhonatan);
		
		commit();

	}

	public Aluno criaAluno(String nome, String sobrenome, TipoSexo sexo) {
		return new Aluno(nome, sobrenome, sexo);
	}

	public Contato criaContato(String telefone) {
		return new Contato(telefone);
	}

	public Endereco criaEndereco(String logradouro, String numero,
			String complemento, String cidade, String uf, String cep) {
		return new Endereco(logradouro, numero, complemento, cidade, uf, cep);
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

}
