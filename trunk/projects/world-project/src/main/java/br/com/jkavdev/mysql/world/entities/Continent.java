package br.com.jkavdev.mysql.world.entities;

public enum Continent {

	ASIA("Asia"), 
	AFRICA("Africa"), 
	ANTARTICA("Antartica"), 
	AUSTRALIA("Australia"), 
	EUROPE("Europe"), 
	NORTHAMERICA("North America"), 
	SOUTHAMERICA("South America");

	private Continent(String description) {
		this.description = description;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
