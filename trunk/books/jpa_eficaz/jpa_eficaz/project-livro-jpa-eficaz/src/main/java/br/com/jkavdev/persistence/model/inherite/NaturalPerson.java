package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("natural_person")
public class NaturalPerson extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
