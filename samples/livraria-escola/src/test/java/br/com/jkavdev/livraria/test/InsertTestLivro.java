package br.com.jkavdev.livraria.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.livraria.model.Genero;
import br.com.jkavdev.livraria.model.Livro;

public class InsertTestLivro {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {

		factory = Persistence.createEntityManagerFactory("livrariaPU");
		manager = factory.createEntityManager();

	}

	@Test
	public void insertLivro() {

		beginTransaction();
		
		List<Genero> generos = manager.createQuery("from Genero", Genero.class).getResultList();
		
		for (Genero genero : generos) {			
			if (genero.getNomeGenero().equalsIgnoreCase("ação")) {
				Livro amarrilion = criaLivro("23121", "Amarrilion", genero);
				
				this.manager.persist(amarrilion);
			}else if (genero.getNomeGenero().equalsIgnoreCase("romance")) {
				Livro primeiroBeijo = criaLivro("25113", "Primeiro Beijo", genero);
				
				this.manager.persist(primeiroBeijo);
			}
			
		}

		commit();

	}

	@Test
	public void insertGenero() {
		beginTransaction();

		Genero terror = criaGenero("Terror");
		Genero acao = criaGenero("Ação");
		Genero romance = criaGenero("Romance");
		Genero comedia = criaGenero("Comédia");
		Genero drama = criaGenero("Drama");

		this.manager.persist(terror);
		this.manager.persist(acao);
		this.manager.persist(romance);
		this.manager.persist(comedia);
		this.manager.persist(drama);

		commit();
	}

	public Livro criaLivro(String isbn, String titulo, Genero genero) {
		Livro livro = new Livro(isbn, titulo, genero);
		return livro;
	}

	public Genero criaGenero(String nomeGenero) {
		Genero genero = new Genero();
		genero.setNomeGenero(nomeGenero);
		return genero;
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

}
