package br.com.jkavdev.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleManyToMany {

	private int vehicleId;
	private String vehicleName;
	private Collection<UserManyToMany> users = new ArrayList<>();

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

	@ManyToMany(mappedBy = "vehicles")
	public Collection<UserManyToMany> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserManyToMany> users) {
		this.users = users;
	}

}
