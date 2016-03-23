package com.algaworks.pedidovenda.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.TipoPessoa;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidoPU");
		EntityManager manager = factory.createEntityManager();

//		EntityTransaction transaction = manager.getTransaction();
//
//		transaction.begin();
//
//		Cliente cliente = new Cliente();
//		cliente.setNome("Jhonatan");
//		cliente.setEmail("jhonatan@gmail.com");
//		cliente.setDocumentoReceitaFederal("044.882.891-00");
//		cliente.setTipo(TipoPessoa.FISICA);
//
//		Endereco endereco = new Endereco();
//		endereco.setLogradouro("Qr 12 Casa 15");
//		endereco.setNumero("15");
//		endereco.setCidade("Planaltina de Goiais");
//		endereco.setUf("GO");
//		endereco.setCep("73754012");		
//		endereco.setCliente(cliente);
//		
//		cliente.getEnderecos().add(endereco);
//		
//		manager.persist(cliente);
//
//		transaction.commit();

	}

}
