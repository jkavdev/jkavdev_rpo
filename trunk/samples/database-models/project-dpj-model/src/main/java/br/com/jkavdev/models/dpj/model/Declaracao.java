package br.com.jkavdev.models.dpj.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "declaracoes")
public class Declaracao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Artigo artigo;
	private Autoridade autoridade;
	private Cargo cargo;
	private Delegacia delegacia;
	private Endereco endereco;
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "artigo_id", nullable = false)
	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	@ManyToOne
	@JoinColumn(name = "autoridade_id", nullable = false)
	public Autoridade getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(Autoridade autoridade) {
		this.autoridade = autoridade;
	}

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@ManyToOne
	@JoinColumn(name = "delegacia_id", nullable = false)
	public Delegacia getDelegacia() {
		return delegacia;
	}

	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}

	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
