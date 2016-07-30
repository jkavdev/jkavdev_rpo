package br.com.jkavdev.algaworks.jsf.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.model.Pessoa;
import br.com.jkavdev.algaworks.jsf.model.TipoLancamento;
import br.com.jkavdev.algaworks.jsf.repositories.Pessoas;
import br.com.jkavdev.algaworks.jsf.services.GestaoLancamentos;
import br.com.jkavdev.algaworks.jsf.services.RegraNegocioException;
import br.com.jkavdev.algaworks.jsf.util.jpa.Repositorios;
import br.com.jkavdev.algaworks.jsf.util.jsf.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Repositorios repositorios = new Repositorios();
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> pessoas = new ArrayList<>();

	@PostConstruct
	public void inicializar() {
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
	}

	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void salvar() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());

		try {
			gestaoLancamentos.guardar(lancamento);

			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento salvo com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, e.getMessage());
		}

		this.lancamento = new Lancamento();
	}

	public boolean isEditando() {
		//se codigo nao for vazio está editando
		return this.lancamento.getCodigo() != null;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		//verificação por causa do conversor
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		} else {
			this.lancamento = (Lancamento) lancamento.clone();
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}