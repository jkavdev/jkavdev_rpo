package br.com.jkavdev.mysql.world.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

@Entity
@Table(name = "city")
public class City extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String name;
	private Country countryCode;
	private String destrict;
	private Integer population;

	public City(String name, Country countryCode, String destrict, Integer population) {
		this();
		this.name = name;
		this.countryCode = countryCode;
		this.destrict = destrict;
		this.population = population;
	}

	public City() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_code")
	public Country getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Country countryCode) {
		this.countryCode = countryCode;
	}

	public String getDestrict() {
		return destrict;
	}

	public void setDestrict(String destrict) {
		this.destrict = destrict;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

}
