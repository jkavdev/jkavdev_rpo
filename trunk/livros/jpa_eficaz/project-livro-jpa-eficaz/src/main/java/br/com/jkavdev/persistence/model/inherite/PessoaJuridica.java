package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
