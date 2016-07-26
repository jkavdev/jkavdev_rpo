package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Autor extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Collection<Livro> livros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany
	public Collection<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Collection<Livro> livros) {
		this.livros = livros;
	}

}
