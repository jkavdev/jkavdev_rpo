package com.algaworks.curso.jpa2.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;

@Named
@ViewScoped
public class PesquisaModeloCarroBean {
	
	@Inject
	private ModeloCarroDAO modeloCarroDAO;

}
