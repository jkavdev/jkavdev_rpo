package br.com.gospro.model;

public enum Sexo {

	MASCULINO("Masculino"), 
	FEMININO("Femino");

	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
