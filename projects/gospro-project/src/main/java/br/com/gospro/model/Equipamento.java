package br.com.gospro.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.gospro.util.jpa.BaseEntity;

@Entity
@Table(name = "equipamentos")
public class Equipamento extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String marca;
	private String modelo;
	private String tipo;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
