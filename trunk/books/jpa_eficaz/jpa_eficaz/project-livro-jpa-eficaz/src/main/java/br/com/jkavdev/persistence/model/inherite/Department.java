package br.com.jkavdev.persistence.model.inherite;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Department {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
