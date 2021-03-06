package br.com.jkavdev.algaworks.jsf.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.repositories.Lancamentos;
import br.com.jkavdev.algaworks.jsf.services.GestaoLancamentos;
import br.com.jkavdev.algaworks.jsf.services.RegraNegocioException;
import br.com.jkavdev.algaworks.jsf.util.jpa.Repositorios;
import br.com.jkavdev.algaworks.jsf.util.jsf.FacesUtil;

@ManagedBean
public class ConsultaLancamentoBean {

	private Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<>();
	private Lancamento lancamentoSelecionado;

	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
	}

	public void excluir() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(lancamentoSelecionado);
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");

			this.inicializar();
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento já foi pago e não pode ser excluído!");
		}

	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}
