package br.com.jkavdev.k19.jpa_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ligacao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Fatura fatura;
	private Integer duracao;

	@ManyToOne
	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

}
