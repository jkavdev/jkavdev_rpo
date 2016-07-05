package br.com.jkavdev.livraria.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contato {

	private String telefone;
	private String celular;
	private String email;

	public Contato(String telefone, String celular, String email) {
		this(telefone);
		this.celular = celular;
		this.email = email;
	}

	public Contato(String telefone) {
		this();
		this.telefone = telefone;
	}

	public Contato() {
		super();
	}

	@Column(nullable = false, length = 12)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(length = 12)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(length = 100, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
