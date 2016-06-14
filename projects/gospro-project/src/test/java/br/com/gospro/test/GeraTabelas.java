package br.com.gospro.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.gospro.model.Funcionario;

public class GeraTabelas {

	@Test
	public void geraTabelas() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gosproPU");
		EntityManager manager = factory.createEntityManager();

		List<Funcionario> funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}

		manager.close();
		factory.close();

	}

}
