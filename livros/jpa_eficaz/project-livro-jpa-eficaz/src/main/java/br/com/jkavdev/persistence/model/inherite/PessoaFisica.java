package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.Entity;

//insert custoso, pois alem de inserir em pessoa Fisica
//tera tambem um insert em Pessoa
//permite campos null

@Entity
public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
