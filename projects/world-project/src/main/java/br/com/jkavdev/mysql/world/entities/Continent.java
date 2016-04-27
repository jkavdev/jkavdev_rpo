package br.com.jkavdev.mysql.world.entities;

public enum Continent {

	ASIA("Asia"), 
	AFRICA("Africa"), 
	ANTARTICA("Antartica"), 
	AUSTRALIA("Australia"), 
	EUROPE("Europe"), 
	NORTHAMERICA("North America"), 
	SOUTHAMERICA("South America");

	private Continent(String descricao) {
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
