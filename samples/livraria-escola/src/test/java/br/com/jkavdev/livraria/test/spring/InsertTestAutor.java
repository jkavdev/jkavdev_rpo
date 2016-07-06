package br.com.jkavdev.livraria.test.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.livraria.model.Autor;
import br.com.jkavdev.livraria.model.Livro;

public class InsertTestAutor {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {

		factory = Persistence.createEntityManagerFactory("livrariaPU");
		manager = factory.createEntityManager();

	}

	@Test
	public void insertAutorSemLivro() {

		beginTransaction();

		Autor jhonatan = criaAutor("Jhonatan Kolen", "Alves Viana");
		Autor ian = criaAutor("Ian", "Mendez");
		Autor marcos = criaAutor("Marcos", "Sousa Carlos");
		Autor daniel = criaAutor("Daniel", "Mattos");

		this.manager.persist(daniel);
		this.manager.persist(jhonatan);
		this.manager.persist(marcos);
		this.manager.persist(ian);

		commit();

	}

	@Test
	public void insertAutorComLivro() {
		beginTransaction();
		
		List<Livro> livros = this.manager .createQuery("from Livro", Livro.class).getResultList();
		List<Autor> autores = this.manager.createQuery("from Autor", Autor.class).getResultList();

		for (Livro livro : livros) {
			for (Autor autor : autores) {
				if (autor.getNome().equals("Ian")) {
					autor.adicionaLivro(livro);
				}
			}
		}
		
		
		
		commit();

	}

	public Autor criaAutor(String nome, String sobrenome) {
		return new Autor(nome, sobrenome);
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

}
