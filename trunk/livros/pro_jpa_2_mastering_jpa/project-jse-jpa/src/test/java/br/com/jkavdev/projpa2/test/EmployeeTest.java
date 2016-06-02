package br.com.jkavdev.projpa2.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jkavdev.projpa2.model.Employee;
import br.com.jkavdev.projpa2.service.EmployeeService;

public class EmployeeTest {

	static EntityManagerFactory factory;
	EntityManager manager = factory.createEntityManager();
	EmployeeService service = new EmployeeService(manager);

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("jpaPostgresPU");
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void createAndPersist() {
		this.manager.getTransaction().begin();
		Employee jhonatan = service.createEmployee(1, "Jhonatan Kolen", 15448L);
		Employee lucas = service.createEmployee(2, "Lucas Alves", 15448L);
		Employee douglas = service.createEmployee(3, "Douglas Alves", 15448L);
		Employee ismael = service.createEmployee(4, "Ismael Delmondes", 15448L);
		Employee eilane = service.createEmployee(5, "Eilane Delmondes", 15448L);
		this.manager.getTransaction().commit();

		List<Employee> employees = new ArrayList<>();
		employees.add(eilane);
		employees.add(ismael);
		employees.add(jhonatan);
		employees.add(lucas);
		employees.add(douglas);

		for (Employee employee : employees) {
			System.out.println("Persisted: " + employee.getName());
		}

	}

	@Test
	public void findEmployee() {
		Employee employee = this.service.findEmployee(1);

		System.out.println("Found: " + employee.getName());
	}

	@Test
	public void findAllEmployees() {
		List<Employee> emps = service.findAll();
		for (Employee e : emps)
			System.out.println("Found employee: " + e.getName() + " - "
					+ e.getSalary());
	}

	@Test
	public void alterEmployee() {
		this.manager.getTransaction().begin();
		Employee employee = service.raiseEmployeeSalary(1, 1000L);
		this.manager.getTransaction().commit();
		System.out.println("Updated " + employee.getName());
	}

	@Test
	public void removeEmployee() {
		this.manager.getTransaction().begin();
		service.remove(1);
		this.manager.getTransaction().commit();

		System.out.println("Removed Employee 1");
	}
}
