package br.com.jkavdev.livraria.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
@Table(name = "livros_emprestados")
public class Emprestimo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Livro livro;
	private Aluno aluno;
	private boolean perdido;
	private boolean multaPaga;
	private boolean atrasado;
	private Calendar dataDoEmprestimo;
	private Calendar dataDoEmprestimoVencimento;
	private Calendar dataDeEntrega;

	@ManyToOne
	@JoinColumn(name = "livro_id", nullable = false)
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

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

	public void setDataDoEmprestimoVencimento( Calendar dataDoEmprestimoVencimento) {
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
	
	public void adicionarAluno(Aluno aluno){
		this.setAluno(aluno);
		aluno.getEmprestimos().add(this);
	}
	
	public void adicionarLivro(Livro livro){
		this.setLivro(livro);
		livro.getEmprestimos().add(this);
	}

}
