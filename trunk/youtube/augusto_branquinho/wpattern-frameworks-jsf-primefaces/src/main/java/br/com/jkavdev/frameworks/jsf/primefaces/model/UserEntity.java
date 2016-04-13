package br.com.jkavdev.frameworks.jsf.primefaces.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseEntities;

@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "UserID"))
public class UserEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 1L;

	private String name;
	private String username;
	private String password;
	private String role;
	
	public UserEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
