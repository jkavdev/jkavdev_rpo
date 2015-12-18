package com.algaworks.cursojsf2.dominio;

import java.io.Serializable;

//implementa seri
//para que seu estado atual seja gravado em bytes
//para que seja transmitido via rede ou gravando no disco
public class Produto implements Serializable{

	private String nome;
	private String fabricante;
	private String categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
