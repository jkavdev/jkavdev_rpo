package br.com.jkavdev.persistence.model.id.composite;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jkavdev.persistence.model.Employee;

@Entity
@Table(name = "departments")
@AttributeOverrides({
		@AttributeOverride(name = "name", column = @Column(length = 50, nullable = false)),
		@AttributeOverride(name = "description", column = @Column(name = "dep_description", nullable = false)) })
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private DepartmentId id;
	private Employee manager;

	@EmbeddedId
	public DepartmentId getId() {
		return id;
	}

	public void setId(DepartmentId id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "manager_id")
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

}
