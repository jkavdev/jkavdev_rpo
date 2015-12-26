package com.algaworks.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.algaworks.curso.modelo.Cliente;

public class ConsultaComCriteria {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();

		// todos os clientes

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
//		criteriaQuery.from(Cliente.class);
//
//		List<Cliente> clientes = manager.createQuery(criteriaQuery).getResultList();
//
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente.getCodigo() + " " + cliente.getNome());
//		}

		// select c from Cliente c where c.nome like 'fernando%'
		Root<Cliente> c = criteriaQuery.from(Cliente.class);
		criteriaQuery.select(c);
		criteriaQuery.where(builder.like(c.<String>get("nome"), "%a%"));
		
		List<Cliente> clientesFiltrados = manager.createQuery(criteriaQuery).getResultList();

		for (Cliente cliente : clientesFiltrados) {
			System.out.println(cliente.getCodigo() + " " + cliente.getNome());
		}
		
		manager.close();

	}

}
