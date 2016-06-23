package br.com.jkavdev.pedidovenda.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.pedidovenda.model.Cliente;
import br.com.jkavdev.pedidovenda.model.Endereco;
import br.com.jkavdev.pedidovenda.model.TipoPessoa;

public class InsertTest {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {
		this.factory = Persistence.createEntityManagerFactory("pedidoPU");
		this.manager = this.factory.createEntityManager();
	}

	@After
	public void close() {
		this.manager.close();
		this.factory.close();
	}

	@Test
	public void insertCliente() {

		Cliente jhonatan = criaCliente("Jhonatan", "jhonatan@gmail.com", TipoPessoa.FISICA, "04488289100");
		Endereco itapua = criaEndereco("73754012", "Planaltina", "Casa", "QR 12 CASA 15", "15", "GO");

		jhonatan.adicionaEndereco(itapua);

		beginTransaction();

		this.manager.persist(jhonatan);

		commit();

	}

	public void beginTransaction() {
		this.manager.getTransaction().begin();
	}

	public void commit() {
		this.manager.getTransaction().commit();
	}

	public Endereco criaEndereco(String cep, String cidade, String complemento, String logradouro,
			String numero, String uf) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setUf(uf);

		return endereco;
	}

	private Cliente criaCliente(String nome, String email, TipoPessoa tipoPessoa, String documentoReceitaFederal) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setDocumentoReceitaFederal(documentoReceitaFederal);
		return cliente;
	}

}
