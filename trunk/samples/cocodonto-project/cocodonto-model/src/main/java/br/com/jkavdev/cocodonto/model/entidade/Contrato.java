package br.com.jkavdev.cocodonto.model.entidade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contratos")
public class Contrato extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Paciente contratante;
	private Dentista contratada;

	@OneToOne
	@JoinColumn(name = "paciente_id")
	public Paciente getContratante() {
		return contratante;
	}

	public void setContratante(Paciente contratante) {
		this.contratante = contratante;
	}

	@OneToOne
	@JoinColumn(name = "dentista_id")
	public Dentista getContratada() {
		return contratada;
	}

	public void setContratada(Dentista contratada) {
		this.contratada = contratada;
	}
}
