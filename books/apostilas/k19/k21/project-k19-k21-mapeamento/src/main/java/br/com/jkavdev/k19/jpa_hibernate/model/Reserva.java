package br.com.jkavdev.k19.jpa_hibernate.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Reserva extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private LocalDate inicio;
	private LocalDate termino;

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getTermino() {
		return termino;
	}

	public void setTermino(LocalDate termino) {
		this.termino = termino;
	}

}
