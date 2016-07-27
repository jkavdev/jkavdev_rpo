package br.com.jkavdev.k19.jpa_hibernate.model.heranca;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.jkavdev.k19.jpa_hibernate.model.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
