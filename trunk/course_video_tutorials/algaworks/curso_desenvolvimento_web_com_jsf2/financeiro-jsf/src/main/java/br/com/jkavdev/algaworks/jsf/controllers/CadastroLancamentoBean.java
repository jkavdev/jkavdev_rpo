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
import br.com.jkavdev.algaworks.jsf.repositories.Lancamentos;
import br.com.jkavdev.algaworks.jsf.repositories.Pessoas;
import br.com.jkavdev.algaworks.jsf.util.jpa.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Repositorios repositorios = new Repositorios();
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> pessoas = new ArrayList<>();

	@PostConstruct
	public void init() {
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
	}

	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void cadastrar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		lancamentos.guardar(this.lancamento);

		this.lancamento = new Lancamento();

		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}