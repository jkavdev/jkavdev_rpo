package br.com.gospro.model;

public enum Cargos {

	ANALISTA("Analista de Sistemas"), 
	GERENTE("Gerente"), 
	ADMINISTRADOR("Administrador de Dados"), 
	ATENDENTE("Atendente");

	private Cargos(String descricao) {
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
