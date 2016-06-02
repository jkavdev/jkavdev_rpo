package br.com.jkavdev.projpa2.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jkavdev.projpa2.model.Employee;

public class EmployeeService {

	private EntityManager entityManager;

	
	//manager sera passado pelo construtor
	public EmployeeService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Employee createEmployee(Integer id, String name, Long salary) {
		Employee employee = new Employee(id, name, salary);

		this.entityManager.persist(employee);

		return employee;
	}

	public Employee findEmployee(Integer id) {
		return this.entityManager.find(Employee.class, id);
	}

	public void remove(Integer id) {
		Employee employee = this.entityManager.find(Employee.class, id);

		//removera apenas se a entidade existe no banco
		if (employee != null) {
			this.entityManager.remove(employee);
		}
	}

	public Employee raiseEmployeeSalary(Integer id, Long raise) {
		Employee employee = this.entityManager.find(Employee.class, id);
		
		//alterara employee apenas se existir no banco
		if (employee != null) {
			employee.setSalary(employee.getSalary() + raise);
		}

		return employee;
	}

	public List<Employee> findAll() {
		List<Employee> employees = 
				this.entityManager.createQuery("select e from Employee e", Employee.class)
					.getResultList();

		return employees;
	}

}
