package br.com.jkavdev.models.dpj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "delegacias")
public class Delegacia extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String tipoDelegacia;
	
	public Delegacia() {
	}

	public Delegacia(String tipoDelegacia) {
		this.tipoDelegacia = tipoDelegacia;
	}

	@Column(name = "tipo_delegacia", length = 200, nullable = false)
	public String getTipoDelegacia() {
		return tipoDelegacia;
	}

	public void setTipoDelegacia(String tipoDelegacia) {
		this.tipoDelegacia = tipoDelegacia;
	}

}
