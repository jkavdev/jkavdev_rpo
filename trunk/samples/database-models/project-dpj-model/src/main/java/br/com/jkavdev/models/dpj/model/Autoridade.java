package br.com.jkavdev.models.dpj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "autoridades")
public class Autoridade extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nomeAutoridade;

	@Column(name = "nome_autoridade", nullable = false, length = 64)
	public String getNomeAutoridade() {
		return nomeAutoridade;
	}

	public void setNomeAutoridade(String nomeAutoridade) {
		this.nomeAutoridade = nomeAutoridade;
	}

}
