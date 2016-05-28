package br.com.simulados.modelo;

import javax.persistence.Entity;

import br.com.simulados.util.jpa.PersistenceObject;

@Entity
public class Area extends PersistenceObject<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;

	public Area(String area) {
		this.nome = area;
	}

	public Area() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
