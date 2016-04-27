package br.com.jkavdev.mysql.world.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LanguagePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String country;
	private String language;

	public LanguagePK(String country, String language) {
		this();
		this.country = country;
		this.language = language;
	}

	public LanguagePK() {
	}

	@Column(name = "country_code", length = 3)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(length = 30)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguagePK other = (LanguagePK) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
