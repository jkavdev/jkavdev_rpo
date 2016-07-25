package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Editora;

public class JpaTest {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("k21PU");
		manager = factory.createEntityManager();
	}

	@After
	public void clean() {
		manager.close();
		factory.close();
	}

	@Test
	public void geraTabelas() {

		manager.close();
		factory.close();
	}

	@Test
	public void insertEditora() {
		Editora k19 = criaEditora("K19 - Livros", "k19@email.com");

		beginTransaction();

		manager.persist(k19);

		commit();
	}

	@Test
	public void selectEditora() {

		// traz o objeto imediatamente
		Editora editora = manager.find(Editora.class, 1L);
		// traz o objeto apenas quando o get e chamado
		Editora editora2 = manager.getReference(Editora.class, 1L);

		System.out.println("Find: " + editora.getNome());
		System.out.println("Reference: " + editora2.getNome());

	}

	@Test
	public void updateEditora() {
		
		//retornando editorar para realizar alteração
		Editora editora = manager.find(Editora.class, 1L);

		beginTransaction();

		//realizando alteração
		editora.setNome("K19 - Nice Courses");

		commit();

	}

	@Test
	public void removeEditora() {

		Editora editora = manager.find(Editora.class, 1L);

		beginTransaction();

		//removendo editora buscado do banco
		manager.remove(editora);

		commit();

	}

	@Test
	public void listAllEditoras() {
		//realizando query que busca todas as editoras do banco
		List<Editora> editoras = manager.createQuery("from Editora", Editora.class).getResultList();

		for (Editora editora : editoras) {
			System.out.println(editora.getNome());
		}
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public Editora criaEditora(String nome, String email) {
		Editora editora = new Editora();
		editora.setNome(nome);
		editora.setEmail(email);

		return editora;
	}

}
