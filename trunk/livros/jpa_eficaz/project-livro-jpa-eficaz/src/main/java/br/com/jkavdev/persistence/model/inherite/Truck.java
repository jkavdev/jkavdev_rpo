package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Truck extends Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer loadCapacity;
	private Integer noOfContainers;

	@Column(name = "load_capacity")
	public Integer getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(Integer loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	@Column(name = "no_of_containers")
	public Integer getNoOfContainers() {
		return noOfContainers;
	}

	public void setNoOfContainers(Integer noOfContainers) {
		this.noOfContainers = noOfContainers;
	}

}
