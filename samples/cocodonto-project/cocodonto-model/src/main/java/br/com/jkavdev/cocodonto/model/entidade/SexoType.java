package br.com.jkavdev.cocodonto.model.entidade;

public enum SexoType {

	M("Masculino"), 
	F("Feminino");

	private SexoType(String descricacao) {
		this.descricacao = descricacao;
	}

	private String descricacao;

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

}
