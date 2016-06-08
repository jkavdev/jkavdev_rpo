package br.com.gospro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String email;
	private String telefone;
	private String celular;
	private Pessoa pessoa;

	public Contato() {
		super();
	}

	public Contato(String email, String telefone, String celular) {
		this();
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long id) {
		this.codigo = id;
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

	@ManyToOne
	@JoinColumn(name = "pessoa_codigo")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
