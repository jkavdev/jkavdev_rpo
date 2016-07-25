package br.com.jkavdev.persistence.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.Employee;
import br.com.jkavdev.persistence.model.id.composite.Project;
import br.com.jkavdev.persistence.model.id.composite.UniquePk;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestIDComposites {

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
	public void testComplexEmbbedId() {
		Project project = new Project();
		project.setDescription("Contrução do Maracana");
		project.setEndDate(Calendar.getInstance());
		project.setStartDate(Calendar.getInstance());
		project.setSpent(BigDecimal.valueOf(1566654f));
		
		Employee manager = new Employee();
		manager.setNome("Jhonatan");
		
		UniquePk id = new UniquePk();
		id.setHashCode("12321231564654");
		id.setRegistDate(Calendar.getInstance().getTime());
		
		project.setManager(manager);
		project.setId(id);

		this.manager.getTransaction().begin();
		this.manager.persist(project);
		this.manager.getTransaction().commit();
	}

}
