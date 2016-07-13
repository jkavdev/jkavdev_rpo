package br.com.jkavdev.livraria.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "emprestimos_de_livros")
public class Emprestimo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private boolean perdido;
	private boolean multaPaga;
	private boolean atrasado;
	private Calendar dataDoEmprestimo;
	private Calendar dataDoEmprestimoVencimento;
	private Calendar dataDeEntrega;
	private List<Livro> livros;
	private Aluno aluno;

	@Column(nullable = false)
	public boolean isPerdido() {
		return perdido;
	}

	public void setPerdido(boolean perdido) {
		this.perdido = perdido;
	}

	@Column(nullable = false, name = "multa_paga")
	public boolean isMultaPaga() {
		return multaPaga;
	}

	public void setMultaPaga(boolean multaPaga) {
		this.multaPaga = multaPaga;
	}

	@Column(nullable = false)
	public boolean isAtrasado() {
		return atrasado;
	}

	public void setAtrasado(boolean atrasado) {
		this.atrasado = atrasado;
	}

	@Column(nullable = false, name = "data_emprestimo")
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}

	public void setDataDoEmprestimo(Calendar dataDoEmprestimo) {
		this.dataDoEmprestimo = dataDoEmprestimo;
	}

	@Column(nullable = false, name = "data_vencimento_emprestimo")
	@Temporal(TemporalType.DATE)
	public Calendar getDataDoEmprestimoVencimento() {
		return dataDoEmprestimoVencimento;
	}

	public void setDataDoEmprestimoVencimento(
			Calendar dataDoEmprestimoVencimento) {
		this.dataDoEmprestimoVencimento = dataDoEmprestimoVencimento;
	}

	@Column(nullable = false, name = "data_entrega")
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(Calendar dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	@ManyToMany
	@JoinTable(name = "livros_emprestados", joinColumns = @JoinColumn(name = "livro_id"), foreignKey = @ForeignKey(name = "fk_livro_emprestado_livro_id"), inverseJoinColumns = @JoinColumn(name = "emprestimo_id"), inverseForeignKey = @ForeignKey(name = "fk_livro_emprestado_emprestimo_id"))
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false, foreignKey = @ForeignKey(name = "fk_emprestimo_aluno_id"))
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void adicionarAluno(Aluno aluno) {
		this.setAluno(aluno);
		aluno.getEmprestimos().add(this);
	}

	public void adicionarLivro(Livro livro) {
		if (this.livros == null) {
			this.livros = new ArrayList<>();
		}

		this.getLivros().add(livro);
	}

}
