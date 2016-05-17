package br.com.so.modelo;

import java.io.Serializable;

public class Cargo implements Serializable {

	private String nomeCargo;

	public Cargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
