package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String email;
	private Calendar dataDeCadastro;
	private byte[] foto;

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
	// informando que est campo não será retornado
	// apenas se for solicitado
	@Basic(fetch = FetchType.LAZY)
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
