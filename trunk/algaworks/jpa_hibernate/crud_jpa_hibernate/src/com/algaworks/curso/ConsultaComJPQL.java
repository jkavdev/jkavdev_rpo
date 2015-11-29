package com.algaworks.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultaComJPQL {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();

		List<Cliente> clientes = manager.createQuery("from Cliente",
				Cliente.class).getResultList();

		for (Cliente cliente : clientes) {
			System.out.println(cliente.getCodigo() + " - " + cliente.getNome());
		}

	}

}
