package br.com.jkavdev.persistence.model.composite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@SecondaryTables({
	@SecondaryTable(
			name = "cities", //nome da tabela 
			pkJoinColumns = { @PrimaryKeyJoinColumn(name = "country_id") }), //nome do campo que referenciara para esta tabela
	@SecondaryTable(
			name = "country_language", 
			pkJoinColumns = { @PrimaryKeyJoinColumn(name = "country_id") })
})
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String continent;
	private String capital;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}	

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
