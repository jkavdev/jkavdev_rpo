package br.com.simulados.modelo;

import javax.persistence.Entity;

import br.com.simulados.util.jpa.PersistenceObject;

@Entity
public class Cargo extends PersistenceObject<Long> {

	private static final long serialVersionUID = 1L;

	private String nomeCargo;

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
