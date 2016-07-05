package br.com.jkavdev.livraria.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "livros")
public class Livro extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String isbn;
	private String titulo;
	private Genero genero;
	private Integer numeroDeCopias;
	private BigDecimal preco;
	private Calendar DataDePublicacao;
	private List<Emprestimo> emprestimos;

	public Livro() {
		super();
	}

	public Livro(String isbn, String titulo, Genero genero, Integer numeroDeCopias, BigDecimal preco, Calendar dataDePublicacao) {
		this(isbn, titulo, genero);
		this.numeroDeCopias = numeroDeCopias;
		this.preco = preco;
		DataDePublicacao = dataDePublicacao;
	}

	public Livro(String isbn, String titulo, Genero genero) {
		this();
		this.isbn = isbn;
		this.titulo = titulo;
		this.genero = genero;
	}

	@Column(name = "isbn", length = 100, nullable = false, unique = true)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "titulo", length = 100, nullable = false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne
	@JoinColumn(name = "genero_id", nullable = false)
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Column(name = "numero_de_copias")
	public Integer getNumeroDeCopias() {
		return numeroDeCopias;
	}

	public void setNumeroDeCopias(Integer numeroDeCopias) {
		this.numeroDeCopias = numeroDeCopias;
	}

	@Column(name = "preco", precision = 10, scale = 2)
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Column(name = "data_de_publicacao")
	@Temporal(TemporalType.DATE)
	public Calendar getDataDePublicacao() {
		return DataDePublicacao;
	}

	public void setDataDePublicacao(Calendar dataDePublicacao) {
		DataDePublicacao = dataDePublicacao;
	}

	@OneToMany(mappedBy = "livro")
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

}
