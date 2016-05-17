package br.com.jkavdev.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_details")
public class UserDetails {

	private int userId;
	private String userName;

	@Id
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//apesar de informarmos o nome, o hibernate busca o valor do get
	@Column(name = "user_name")
	public String getUserName() {
		return userName + " valor do getter";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
