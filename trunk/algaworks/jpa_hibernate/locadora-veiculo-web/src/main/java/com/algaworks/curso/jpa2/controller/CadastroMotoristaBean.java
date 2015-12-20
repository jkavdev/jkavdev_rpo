package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroMotoristaService cadastroMotoristaService;
	private Motorista motorista;

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void salvar() {
		try {
			this.cadastroMotoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista " + motorista.getNome() + " salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	private void limpar() {
		motorista = new Motorista();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}
