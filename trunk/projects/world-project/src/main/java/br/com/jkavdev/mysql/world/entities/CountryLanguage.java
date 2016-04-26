package br.com.jkavdev.mysql.world.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

//@Entity
//@Table(name = "country_language")
public class CountryLanguage extends BaseEntity<Long> {

	private Long id;
	private IsOfficial official;
	private Float percentage;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IsOfficial getOfficial() {
		return official;
	}

	public void setOfficial(IsOfficial official) {
		this.official = official;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

}
