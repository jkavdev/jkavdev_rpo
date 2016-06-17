package br.com.jkavdev.cocodonto.model.entidade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa {

	private static final long serialVersionUID = 1L;

	private Paciente responsavelPor;

	@ManyToOne
	@JoinColumn(name = "responsavel")
	public Paciente getResponsavelPor() {
		return responsavelPor;
	}

	public void setResponsavelPor(Paciente responsavelPor) {
		this.responsavelPor = responsavelPor;
	}

}
