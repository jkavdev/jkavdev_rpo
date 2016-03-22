package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.service.NegocioException;

@Named
@RequestScoped
public class CadastroPedidoBean {

	private List<Integer> itens;

	public CadastroPedidoBean() {
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar(){
		throw new NegocioException("Pedido nao foi salvo, pois nao foi implementado");
	}

	public List<Integer> getItens() {
		return itens;
	}
	

}
