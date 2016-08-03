package br.com.jkavdev.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publisher {

	private String code;
	private String name;
	private String address;

	@Id
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

}
