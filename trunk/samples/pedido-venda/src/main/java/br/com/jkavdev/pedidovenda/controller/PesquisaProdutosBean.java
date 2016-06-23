package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> produtosFiltrados;

	public PesquisaProdutosBean() {
		this.produtosFiltrados = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			this.produtosFiltrados.add(i);
			System.out.println(i);
		}
	}

	public List<Integer> getProdutosFiltrados() {
		return this.produtosFiltrados;
	}

}
