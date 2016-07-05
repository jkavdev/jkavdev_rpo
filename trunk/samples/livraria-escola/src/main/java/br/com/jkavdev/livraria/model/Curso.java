package br.com.jkavdev.livraria.model;

import java.util.ArrayList;
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
@Table(name = "cursos")
public class Curso extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nomeCurso;
	private String descricao;
	private List<Livro> livros;

	public Curso(String nomeCurso, String descricao) {
		this();
		this.nomeCurso = nomeCurso;
		this.descricao = descricao;
	}

	public Curso() {
		super();
	}

	@Column(name = "course_name", length = 100, nullable = false)
	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Column(columnDefinition = "text")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "livros_indicados", 
			joinColumns = @JoinColumn(name = "livro_id", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "curso_id", nullable = false))
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void adicionaLivroIndicado(Livro indicado) {
		if(livros == null) {
			this.livros = new ArrayList<>();
		}
		this.livros.add(indicado);
	}

}
