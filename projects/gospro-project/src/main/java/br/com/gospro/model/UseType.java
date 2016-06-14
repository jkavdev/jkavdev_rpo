package br.com.gospro.model;

public enum UseType {

	ADMINISTRADOR("Administrador de Dados"), 
	USUARIO("Usuário"), 
	OPERADOR("Operador do Sistema"), 
	GERENTE("Gerente");

	private UseType(String descricao) {
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
