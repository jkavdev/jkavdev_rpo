package br.com.jkavdev.persistence.model.id;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
		name = Country.IDS_TABLE_NAME,	//nome do gerador de tabela
		table = Country.IDS_TABLE_NAME,	//nome da tabela gerada no banco
		pkColumnName = "tabela",		//nome da coluna na tabela do banco 
		pkColumnValue = "country",		//valor para coluna, no caso sera o nome da tabela que contera o id
		valueColumnName = "id_atual",	//nome da coluna que contera os ids atuais de cada tabela
		initialValue = 1,				//valor inicial = 1
		allocationSize = 1)			//valores em memoria
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String IDS_TABLE_NAME = "tabela_de_ids";

	private Long id;
	private String currency;
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = IDS_TABLE_NAME)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
