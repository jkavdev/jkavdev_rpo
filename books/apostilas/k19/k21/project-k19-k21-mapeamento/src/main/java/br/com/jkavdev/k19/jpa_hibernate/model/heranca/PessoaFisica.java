package br.com.jkavdev.k19.jpa_hibernate.model.heranca;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
