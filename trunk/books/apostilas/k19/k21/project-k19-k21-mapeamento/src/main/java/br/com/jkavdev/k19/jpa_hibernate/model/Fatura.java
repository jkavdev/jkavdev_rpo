package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fatura extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Collection<Ligacao> ligacoes = new ArrayList<Ligacao>();
	private Calendar vencimento;

	@OneToMany(mappedBy = "fatura")
	public Collection<Ligacao> getLigacoes() {
		return ligacoes;
	}

	public void setLigacoes(Collection<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

}
