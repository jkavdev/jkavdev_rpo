package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//neste tipo de heranca, esta entidade nao pode ter
//atributos not null

@Entity
@DiscriminatorValue("juridical_person")
public class JuridicalPerson extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
