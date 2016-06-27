package br.com.jkavdev.models.dpj.model;

public enum Corporacao {

	PC("Policia Civíl"), 
	PM("Policia Militar");

	private String descricao;

	private Corporacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
