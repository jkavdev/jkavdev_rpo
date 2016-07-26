package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {

	private Long id;
	private String email;
	private Calendar dataDeCadastro;
	private byte[] foto;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Lob
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
