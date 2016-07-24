package br.com.jkavdev.algaworks.jsf.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultaLancamentoBean {

	private List<String> lancamentos = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 20; i++) {
			lancamentos.add("");
		}
	}

	public List<String> getLancamentos() {
		return lancamentos;
	}

}
