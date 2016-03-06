package com.algaworks.javaee;

import java.io.Serializable;

public class Interesse implements Serializable {

	private static final long serialVersionUID = 1L;

	//descricao do interesse
	private String descricao;
	//nome do icone do interesse
	private String nomeIcone;

	public Interesse() {
	}

	public Interesse(String descricao, String nomeIcone) {
		this.descricao = descricao;
		this.nomeIcone = nomeIcone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeIcone() {
		return nomeIcone;
	}

	public void setNomeIcone(String nomeIcone) {
		this.nomeIcone = nomeIcone;
	}

}
