package br.com.jkavdev.mysql.world.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LanguagePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String String;
	private String language;

	public LanguagePK(String String, String language) {
		this();
		this.String = String;
		this.language = language;
	}

	public LanguagePK() {
	}

	@Column(name = "country_code")
	public String getString() {
		return String;
	}

	public void setString(String String) {
		this.String = String;
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
		result = prime * result + ((String == null) ? 0 : String.hashCode());
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
		if (String == null) {
			if (other.String != null)
				return false;
		} else if (!String.equals(other.String))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
