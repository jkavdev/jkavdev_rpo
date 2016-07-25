package br.com.jkavdev.persistence.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
public class Guest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String address;
	private String city;

	// utilizado na marioria das vezes com Mysql e SQLServer
	// jpa persistira o objeto, o banco de dados gerara id
	// depois de persistido, a jpa buscara o id gerado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guest_id")
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
