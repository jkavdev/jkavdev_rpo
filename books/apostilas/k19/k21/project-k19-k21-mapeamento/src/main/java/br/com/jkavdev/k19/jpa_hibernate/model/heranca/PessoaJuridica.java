package br.com.jkavdev.k19.jpa_hibernate.model.heranca;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
