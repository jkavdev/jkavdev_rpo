package br.com.jkavdev.k19.jpa_hibernate.model.heranca;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.jkavdev.k19.jpa_hibernate.model.BaseEntity;

@Entity
//será criado apenas uma tabelas para conter as entidades
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

//será criado uma entidade para cada especificacao
//@Inheritance(strategy = InheritanceType.JOINED)

//será criado apenas as tabelas especificas desta classe
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
