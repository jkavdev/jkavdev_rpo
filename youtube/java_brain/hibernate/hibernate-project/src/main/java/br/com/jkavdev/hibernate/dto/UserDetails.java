package br.com.jkavdev.hibernate.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	private String description;
	private Address homeAddress;
	private Address officeAddress;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// apesar de informarmos o nome, o hibernate busca o valor do get
	@Column(name = "user_name")
	// anotacao padrao que indica que este atributo tem que ser persistido
	@Basic
	public String getUserName() {
		// return userName + " valor do getter";
		return userName;
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

	// para objetos grandes
	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// dados desta classe sendo embutidos nesta entidade
	@Embedded
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
				name="street", 
				column=@Column(name="home_street_name")),
		@AttributeOverride(
				name="city", 
				column=@Column(name="home_city_name")),
		@AttributeOverride(
				name="state", 
				column=@Column(name="home_state_name")),
		@AttributeOverride(
				name="pincode", 
				column=@Column(name="home_pin_code")),
	})
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

}
