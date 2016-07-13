package br.com.jkavdev.livraria.model;

public enum TipoSexo {

	MASCULINO("Masculino"), 
	Feminino("Feminino");

	private String descricao;

	private TipoSexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
