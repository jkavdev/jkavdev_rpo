package br.com.jkavdev.cocodonto.model.entidade;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.cocodonto.model.util.jpa.BaseEntity;

@Entity
@Table(name = "contatos")
public class Contato extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String telefone;
	private String celular;

	public Contato() {
	}

	public Contato(String email, String telefone, String celular) {
		this();
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}