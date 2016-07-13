package br.com.jkavdev.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "grupos")
public class Grupo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;

	@Column(nullable = false, length = 40)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, length = 80)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
