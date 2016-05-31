package br.com.jkavdev.persistence.test;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.id.composite.Music;
import br.com.jkavdev.persistence.model.id.composite.Person;
import br.com.jkavdev.persistence.model.id.composite.UniquePk;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestHibernateId {

	private EntityManager manager;

	@Before
	public void setUp() {
		this.manager = JpaUtil.geEntityManager();
	}

	@After
	public void tearDown() {
		JpaUtil.close();
	}

	@Test
	public void testInsertComplexIdTwo() {
		Music music = new Music();
		music.setName("Mais nada");
		
		Person person = new Person();
		person.setName("Jhonatan");
		person.setArtistName("jkavdev");
		
		UniquePk id = new UniquePk();
		id.setHashCode("12321231564654");
		id.setRegistDate(Calendar.getInstance().getTime());
		
		music.setAutor(person);
		music.setId(id);

		this.manager.getTransaction().begin();
		this.manager.persist(music);
		this.manager.getTransaction().commit();
	}

}
