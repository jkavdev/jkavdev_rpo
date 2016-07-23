package br.com.jkavdev.algaworks.jsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OlaMundoBean {

	private String nome;

	public void enviar() {
		this.setNome(this.getNome().toUpperCase());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
