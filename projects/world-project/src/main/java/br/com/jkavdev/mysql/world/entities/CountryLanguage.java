package br.com.jkavdev.mysql.world.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.entities.util.BaseEntity;

@Entity
@Table(name = "country_language")
public class CountryLanguage extends BaseEntity<Long> {

	private IsOfficial official;
	private Float percentage;

}
