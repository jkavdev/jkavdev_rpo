package br.com.so.modelo;

import java.io.Serializable;
import java.util.List;

public class Instituicao implements Serializable {

	private String nome;
	private List<Cargo> cargos;

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
