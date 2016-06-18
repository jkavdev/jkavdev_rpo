package br.com.jkavdev.cocodonto.model.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jkavdev.cocodonto.model.util.jpa.BaseEntity;

@Entity
@Table(name = "consultas")
public class Consulta extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Dentista dentista;
	private Paciente paciente;
	private BigDecimal valor;
	private Procedimento tratamento;
	private Odontograma odontograma;

	@ManyToOne
	@JoinColumn(name = "dentista_id")
	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@OneToOne
	@JoinColumn(name = "tratamento_id")
	public Procedimento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Procedimento tratamento) {
		this.tratamento = tratamento;
	}

	@OneToOne
	@JoinColumn(name = "odontograma_id")
	public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

}
