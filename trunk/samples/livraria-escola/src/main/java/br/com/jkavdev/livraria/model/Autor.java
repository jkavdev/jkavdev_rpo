package br.com.jkavdev.livraria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	private List<Livro> livros;

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
	@JoinTable(
			name = "livros_por_autor", 
			joinColumns = @JoinColumn(name = "livro_id", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "autor_id", nullable = false))
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void adicionaLivro(Livro livro){
		this.livros.add(livro);
	}

}
