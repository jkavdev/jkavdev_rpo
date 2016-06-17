package br.com.jkavdev.cocodonto.model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Procedimento extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;

	@Column(nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
