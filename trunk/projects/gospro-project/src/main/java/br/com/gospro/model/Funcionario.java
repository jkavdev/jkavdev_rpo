package br.com.gospro.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "func_codigo")
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
