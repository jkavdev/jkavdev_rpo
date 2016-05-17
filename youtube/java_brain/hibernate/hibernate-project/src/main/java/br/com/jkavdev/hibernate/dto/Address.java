package br.com.jkavdev.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//informando que esta classe pode ser embutida
@Embeddable
public class Address {

	private String street;
	private String city;
	private String state;
	private String pincode;

	@Column(name = "street_name")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "city_name")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_name")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "pin_code")
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
