package br.com.jkavdev.models.dpj.model;

public enum EstadoCivil {

	CASADO("Casado(a)"), 
	SOLTEIRO("Solteiro(a)"), 
	VIUVO("Viuvo(a)"), 
	DIVORCIADO("Divorciado(a)"), 
	SEPARADO("Separado(a)"), 
	COMPANHEIRO("Companheiro(a)");

	private String descricao;

	private EstadoCivil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
