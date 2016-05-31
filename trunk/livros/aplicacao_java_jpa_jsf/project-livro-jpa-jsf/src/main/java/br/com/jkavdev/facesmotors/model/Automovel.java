package br.com.jkavdev.facesmotors.model;

public class Automovel {

	private Long id;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String marca;;
	private String observacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "Automovel [ id = " + id + ", "
				+ "modelo = " + modelo 
				+ ", anoFabricacao = " + anoFabricacao 
				+ ", anoModelo = " + anoModelo + 
				", marca = " + marca + 
				", observacoes = " + observacoes + "]";
	}
	
	

}
