package br.com.jkavdev.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroPedidoBean {

	private List<Integer> itens;

	public CadastroPedidoBean() {
		this.itens = new ArrayList<>();
		this.itens.add(1);
	}

	public List<Integer> getItens() {
		return this.itens;
	}

}
