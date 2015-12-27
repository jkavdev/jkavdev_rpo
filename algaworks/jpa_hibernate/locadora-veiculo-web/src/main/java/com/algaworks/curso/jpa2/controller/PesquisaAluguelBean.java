package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

@Named
@ViewScoped
public class PesquisaAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ModeloCarro> modelosCarros;
	private Aluguel aluguel;
	private Carro carro;
	private List<Aluguel> alugueis;
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	@Inject
	private AluguelDAO aluguelDAO;

	@PostConstruct
	public void init() {
		this.aluguel = new Aluguel();
		this.carro = new Carro();
		this.modelosCarros = modeloCarroDAO.buscarTodos();
		this.alugueis = new ArrayList<>();
	}
	
	public void pesquisar(){
		this.alugueis = aluguelDAO.buscarPorDataDeEntregaEModeloCarro(this.aluguel.getDataEntrega(), this.carro.getModelo());
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}

	public Carro getCarro() {
		return carro;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

}
