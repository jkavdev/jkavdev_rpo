package br.com.jkavdev.mysql.world.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

@Entity
@Table(name = "country_language")
public class CountryLanguage extends BaseEntity<LanguagePK> {

	private static final long serialVersionUID = 1L;

	private IsOfficial official;
	private Float percentage;

	@Enumerated(EnumType.STRING)
	public IsOfficial getOfficial() {
		return official;
	}

	public void setOfficial(IsOfficial official) {
		this.official = official;
	}

	@Column(nullable = false, precision = 4, scale = 1)
	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

}
