package br.com.jkavdev.hibernate.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//aqui estamos atribuindo o nome para a
//entidade e para a tabela no banco
//entidade - como o java reconhece a tabela
//@Entity(name = "user_details")
@Entity

// atribui nome apenas para a tabela no banco
@Table(name = "user_details")
public class UserDetails {

	private int userId;
	private String userName;
	private Date joinedDate;
	private String address;
	private String description;

	@Id
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// apesar de informarmos o nome, o hibernate busca o valor do get
	@Column(name = "user_name")
	//anotacao padrao que indica que este atributo tem que ser persistido
	@Basic
	public String getUserName() {
		return userName + " valor do getter";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.DATE)
	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//para objetos grandes
	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
