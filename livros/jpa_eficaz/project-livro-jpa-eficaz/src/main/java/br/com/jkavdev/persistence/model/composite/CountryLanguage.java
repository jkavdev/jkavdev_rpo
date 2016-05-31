package br.com.jkavdev.persistence.model.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country_language")
public class CountryLanguage implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String language;
	private Official isOfficial;
	private Float percentage;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "is_official")
	@Enumerated(EnumType.STRING)
	public Official getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(Official isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

}
