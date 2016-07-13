package br.com.jkavdev.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "generos")
public class Genero extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nomeGenero;

	@Column(name = "nome_genero", length = 100, nullable = false, unique = true)
	public String getNomeGenero() {
		return nomeGenero;
	}

	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero == null ? null : nomeGenero.toUpperCase();
		;
	}

}
