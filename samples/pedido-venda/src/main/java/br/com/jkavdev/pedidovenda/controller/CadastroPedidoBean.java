package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.jkavdev.pedidovenda.model.EnderecoEntrega;
import br.com.jkavdev.pedidovenda.model.Pedido;
import br.com.jkavdev.pedidovenda.service.NegocioException;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> itens;
	private Pedido pedido;

	public CadastroPedidoBean() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		this.itens = new ArrayList<>();
		this.itens.add(1);
	}

	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo!");
	}

	public List<Integer> getItens() {
		return this.itens;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
