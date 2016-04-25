package br.com.jkavdev.mysql.world.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

@Entity
@Table(name = "country")
@AttributeOverride(name = "id", column = @Column(name = "code"))
public class Country extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String name;
	private Continent continent;
	private String region;
	private Float surfaceArea;
	private Integer IndepYear;
	private Integer population;
	private Float lifeExpectancy;
	private Float GNP;
	private Float GNPOId;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Integer getIndepYear() {
		return IndepYear;
	}

	public void setIndepYear(Integer indepYear) {
		IndepYear = indepYear;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Float getGNP() {
		return GNP;
	}

	public void setGNP(Float gNP) {
		GNP = gNP;
	}

	public Float getGNPOId() {
		return GNPOId;
	}

	public void setGNPOId(Float gNPOId) {
		GNPOId = gNPOId;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

}
