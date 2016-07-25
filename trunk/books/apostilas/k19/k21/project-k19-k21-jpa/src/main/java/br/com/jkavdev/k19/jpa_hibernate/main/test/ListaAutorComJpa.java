package br.com.jkavdev.k19.jpa_hibernate.main.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jkavdev.k19.jpa_hibernate.model.Autor;

public class ListaAutorComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21PU");
		EntityManager manager = factory.createEntityManager();

		List<Autor> autores = manager.createQuery("from Autor", Autor.class).getResultList();

		if(autores != null && !autores.isEmpty()){
			for (Autor autor : autores) {
				System.out.println(autor.getNome());
			}
		}else{
			System.out.println("Não foram encontradas editoras");
		}

		manager.close();
		factory.close();

	}
}