package br.com.jkavdev.livraria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "autores")
public class Autor extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sobrenome;
	private List<Livro> livrosEscritos;

	public Autor() {
		super();
	}

	public Autor(String nome, String sobrenome) {
		this();
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	@Column(length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 100, nullable = false)
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "livros_por_autor", joinColumns = @JoinColumn(name = "livro_id", nullable = false), foreignKey = @ForeignKey(name = "fk_autor_livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_autor_autor_id"))
	public List<Livro> getLivrosEscritos() {
		return livrosEscritos;
	}

	public void setLivrosEscritos(List<Livro> livros) {
		this.livrosEscritos = livros;
	}

	public void adicionaLivro(Livro livro) {
		if (this.livrosEscritos == null) {
			this.livrosEscritos = new ArrayList<>();
		}

		this.livrosEscritos.add(livro);
	}

}
