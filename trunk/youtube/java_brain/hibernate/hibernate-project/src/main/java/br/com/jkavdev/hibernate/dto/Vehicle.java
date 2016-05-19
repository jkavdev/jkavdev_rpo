package br.com.jkavdev.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	private int vehicleId;
	private String vehicleName;
	private UserOneToMany user;

	@Id
	@GeneratedValue
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public UserOneToMany getUser() {
		return user;
	}

	public void setUser(UserOneToMany user) {
		this.user = user;
	}

}
