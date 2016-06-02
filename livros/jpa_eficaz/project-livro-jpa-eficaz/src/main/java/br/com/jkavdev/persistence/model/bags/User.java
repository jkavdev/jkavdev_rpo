package br.com.jkavdev.persistence.model.bags;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String password;
	private List<String> emails = new ArrayList<>();
	private List<String> fones = new ArrayList<>();
	private List<Dog> dogs = new ArrayList<>();
	private List<Car> cars = new ArrayList<>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ElementCollection
	@CollectionTable(name = "user_emails")
	@Column(name = "email")
	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@ElementCollection
	@CollectionTable(name = "user_phones")
	@Column(name = "phone")
	public List<String> getFones() {
		return fones;
	}

	public void setFones(List<String> fones) {
		this.fones = fones;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
