package br.com.jkavdev.k19.jpa_hibernate.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable(true)
public class Cidade extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nomeDaCidade;
	private String nomeDoEstado;

	public String getNomeDaCidade() {
		return nomeDaCidade;
	}

	public void setNomeDaCidade(String nomeDaCidade) {
		this.nomeDaCidade = nomeDaCidade;
	}

	public String getNomeDoEstado() {
		return nomeDoEstado;
	}

	public void setNomeDoEstado(String nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado;
	}

}
