package br.com.gospro.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name = "cli_codigo")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	public Cliente() {
	}

	public Cliente(Calendar dataCadastro, String nome, String sobrenome, Calendar dataNascimento, String sexo, String cpf, String rg, Calendar dataCadastro2, boolean liberado) {
		super(dataCadastro, nome, sobrenome, dataNascimento, sexo, cpf, rg);
		dataCadastro = dataCadastro2;
		this.liberado = liberado;
	}

	private Calendar dataCadastro;
	private boolean liberado;

	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}

}
