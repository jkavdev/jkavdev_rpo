package br.com.jkavdev.projpa2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	private Integer id;
	private String name;
	private Long salary;

	public Employee(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}

	public Employee(Integer id, String name, Long salary) {
		this(id);
		this.name = name;
		this.salary = salary;
	}

	public Employee(Integer id) {
		this();
		this.id = id;
	}

	public Employee() {
		super();
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
