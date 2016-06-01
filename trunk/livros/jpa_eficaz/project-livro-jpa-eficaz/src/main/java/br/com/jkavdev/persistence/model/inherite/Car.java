package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Car extends Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer noOfPassangers;
	private Integer noOfDoors;

	@Column(name = "no_of_passangers")
	public Integer getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(Integer noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	@Column(name = "no_of_doors")
	public Integer getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(Integer noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

}
