package br.com.gospro.model;

import java.util.Calendar;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverride(name = "codigo", joinColumns = @JoinColumn(name = "funcionario_codigo"))
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	public Funcionario() {
	}

	public Funcionario(Calendar dataCadastro, String nome, String sobrenome, Calendar dataNascimento, String sexo, String cpf, String rg, String cargo) {
		super(dataCadastro, nome, sobrenome, dataNascimento, sexo, cpf, rg);
		this.cargo = cargo;
	}

	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
