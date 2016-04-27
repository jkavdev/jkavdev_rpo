package br.com.jkavdev.mysql.world.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	private Country country;
	private String destrict;
	private Integer population;

	public City(String name, Country country, String destrict, Integer population) {
		this();
		this.name = name;
		this.country = country;
		this.destrict = destrict;
		this.population = population;
	}

	public City() {
	}

	@Column(nullable = false, length = 35)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "country_code", nullable = false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(nullable = false, length = 20)
	public String getDestrict() {
		return destrict;
	}

	public void setDestrict(String destrict) {
		this.destrict = destrict;
	}

	@Column(nullable = false, length = 11)
	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

}
