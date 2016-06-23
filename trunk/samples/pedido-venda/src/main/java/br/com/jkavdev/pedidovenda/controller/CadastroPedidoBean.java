package br.com.jkavdev.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.jkavdev.pedidovenda.service.NegocioException;

@Named
@RequestScoped
public class CadastroPedidoBean {

	private List<Integer> itens;

	public CadastroPedidoBean() {
		this.itens = new ArrayList<>();
		this.itens.add(1);
	}

	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo!");
	}

	public List<Integer> getItens() {
		return this.itens;
	}

}
