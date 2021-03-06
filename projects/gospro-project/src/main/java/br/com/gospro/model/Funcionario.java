package br.com.gospro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String carteiraTrabalho;
	private Cargos cargo;
	private Date dataAdmissao;

	@Column(name = "carteira_trabalho")
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	@Enumerated(EnumType.STRING)
	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	@Column(name = "data_admissao")
	@Temporal(TemporalType.DATE)
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

}
