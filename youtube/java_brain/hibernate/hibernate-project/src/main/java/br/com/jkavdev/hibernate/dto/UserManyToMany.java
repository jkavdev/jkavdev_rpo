package br.com.jkavdev.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserManyToMany {

	private int userId;
	private String userName;
	private Collection<VehicleManyToMany> vehicles = new ArrayList<>();

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManyToMany
	
	public Collection<VehicleManyToMany> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<VehicleManyToMany> vehicles) {
		this.vehicles = vehicles;
	}

}