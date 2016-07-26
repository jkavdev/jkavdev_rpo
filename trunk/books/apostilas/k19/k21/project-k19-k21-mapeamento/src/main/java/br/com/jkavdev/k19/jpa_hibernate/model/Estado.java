package br.com.jkavdev.k19.jpa_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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

	@OneToOne(optional = false)
	@JoinColumn(name = "governador_id")
	public Governador getGovernador() {
		return governador;
	}

	public void setGovernador(Governador governador) {
		this.governador = governador;
	}

}
