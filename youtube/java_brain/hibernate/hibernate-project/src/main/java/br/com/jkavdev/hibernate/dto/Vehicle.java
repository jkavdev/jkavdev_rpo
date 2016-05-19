package br.com.jkavdev.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	private int vehicleId;
	private String vehicleName;
	private UserOneToMany ser;

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
	public UserOneToMany getSer() {
		return ser;
	}

	public void setSer(UserOneToMany ser) {
		this.ser = ser;
	}

}
