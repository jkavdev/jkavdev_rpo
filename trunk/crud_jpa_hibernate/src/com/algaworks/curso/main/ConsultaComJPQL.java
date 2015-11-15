package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultaComJPQL {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_pu");
		EntityManager manager = factory.createEntityManager();

		List<Cliente> clientes = manager.createQuery("from Cliente where sexo = 'M'", Cliente.class).getResultList();

		for (Cliente cliente : clientes) {
			System.out.println("Código : " + cliente.getId());
			System.out.println("Nome : " + cliente.getNome());
			System.out.println("Sexo : " + cliente.getSexo());
			System.out.println("---------------------------");
		}

	}

}
