package br.com.jkavdev.cocodonto.model.entidade;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dentistas")
public class Dentista extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cro;

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

}
