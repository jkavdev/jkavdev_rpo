package br.com.jkavdev.persistence.model.id;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Calendar dateFrom;
	private Calendar dateTo;

	// o generatedValue com AUTO ou sem argumentos sao a mesma coisa
	// quando selecionado, a jpa escolhera qual a opcao de geramento
	// para aquele id,
	// na maioria das vezes eh criado um um hibernate_sequence, contendo o id
	@Id
	// @GeneratedValue
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_from")
	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_to")
	public Calendar getDateTo() {
		return dateTo;
	}

	public void setDateTo(Calendar dateTo) {
		this.dateTo = dateTo;
	}

}
