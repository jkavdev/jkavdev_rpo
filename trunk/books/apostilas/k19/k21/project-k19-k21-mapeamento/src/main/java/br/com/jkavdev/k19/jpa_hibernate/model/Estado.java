package br.com.jkavdev.k19.jpa_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Estado extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Governador governador;

	@OneToOne(optional = false)
	@JoinColumn(name = "governador_id")
	public Governador getGovernador() {
		return governador;
	}

	public void setGovernador(Governador governador) {
		this.governador = governador;
	}

}
