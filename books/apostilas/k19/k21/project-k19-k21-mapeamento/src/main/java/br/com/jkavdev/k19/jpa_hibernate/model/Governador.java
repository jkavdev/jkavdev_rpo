package br.com.jkavdev.k19.jpa_hibernate.model;

import javax.persistence.Entity;

@Entity
public class Governador extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
