package br.com.jkavdev.persistence.model.id.composite;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jkavdev.persistence.model.Employee;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	private UniquePk id;
	private Employee manager;
	private String description;
	private Calendar startDate;
	private Calendar endDate;
	private BigDecimal spent;

	@Id
	@OneToOne
	@JoinColumn(name = "project_id")
	public UniquePk getId() {
		return id;
	}

	public void setId(UniquePk id) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getSpent() {
		return spent;
	}

	public void setSpent(BigDecimal spent) {
		this.spent = spent;
	}

}
