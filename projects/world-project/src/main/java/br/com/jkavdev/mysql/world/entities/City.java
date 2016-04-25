package br.com.jkavdev.mysql.world.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

@Entity
@Table(name = "city")
public class City extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String name;
	private Country country;
	private String destrict;
	private Integer population;

	public City(Long id, String name, Country country, String destrict, Integer population) {
		this(name, country, destrict, population);
		this.setId(id);
	}

	public City(String name, Country country, String destrict, Integer population) {
		this();
		this.name = name;
		this.country = country;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
