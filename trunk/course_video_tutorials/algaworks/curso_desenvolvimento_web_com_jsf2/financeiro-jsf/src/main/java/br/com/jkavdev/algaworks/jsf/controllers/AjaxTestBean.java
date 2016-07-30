package br.com.jkavdev.algaworks.jsf.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AjaxTestBean {

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
