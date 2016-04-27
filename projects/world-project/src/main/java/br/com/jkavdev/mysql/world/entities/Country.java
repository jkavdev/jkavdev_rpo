package br.com.jkavdev.mysql.world.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

@Entity
@Table(name = "country")
@AttributeOverride(name = "id", column = @Column(name = "code", length = 3))
public class Country extends BaseEntity<String> {

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

	public Country() {
	}

	@Column(nullable = false, length = 52)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@Column(nullable = false, length = 26)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "surface_area", nullable = false, precision = 10, scale = 2)
	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	@Column(name = "indepence_year", nullable = false, length = 6)
	public Integer getIndepYear() {
		return IndepYear;
	}

	public void setIndepYear(Integer indepYear) {
		IndepYear = indepYear;
	}

	@Column(nullable = false, length = 11)
	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	@Column(name = "life_expectancy", nullable = false, precision = 3, scale = 1)
	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	@Column(nullable = false, precision = 10, scale = 2)
	public Float getGNP() {
		return GNP;
	}

	public void setGNP(Float gNP) {
		GNP = gNP;
	}

	@Column(nullable = false, precision = 10, scale = 2)
	public Float getGNPOId() {
		return GNPOId;
	}

	public void setGNPOId(Float gNPOId) {
		GNPOId = gNPOId;
	}

	@Column(name = "local_name", nullable = false, length = 45)
	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Column(name = "government_form", nullable = false, length = 45)
	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	@Column(name = "head_of_state", nullable = false, length = 60)
	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	@Column(nullable = false, length = 11)
	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	@Column(nullable = false, length = 2)
	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

}
