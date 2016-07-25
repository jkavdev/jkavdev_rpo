package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer noOfPassangers;
	private Integer saddleHeight;

	@Column(name = "no_of_passangers")
	public Integer getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(Integer noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	@Column(name = "saddle_height")
	public Integer getSaddleHeight() {
		return saddleHeight;
	}

	public void setSaddleHeight(Integer saddleHeight) {
		this.saddleHeight = saddleHeight;
	}

}
