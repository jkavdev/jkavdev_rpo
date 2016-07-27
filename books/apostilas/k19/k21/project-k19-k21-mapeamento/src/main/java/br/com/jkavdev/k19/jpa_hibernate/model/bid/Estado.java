package br.com.jkavdev.k19.jpa_hibernate.model.bid;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.jkavdev.k19.jpa_hibernate.model.BaseEntity;

@Entity
public class Estado extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Governador governador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToOne
	public Governador getGovernador() {
		return governador;
	}

	public void setGovernador(Governador governador) {
		this.governador = governador;
	}

}
