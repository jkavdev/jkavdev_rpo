package br.com.simulados.modelo;

import javax.persistence.Entity;

import br.com.simulados.util.jpa.PersistenceObject;

@Entity
public class Banca extends PersistenceObject<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
