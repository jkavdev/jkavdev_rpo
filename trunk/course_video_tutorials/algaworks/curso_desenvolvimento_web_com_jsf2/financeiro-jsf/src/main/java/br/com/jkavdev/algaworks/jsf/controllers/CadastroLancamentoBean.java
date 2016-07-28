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

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.model.Pessoa;
import br.com.jkavdev.algaworks.jsf.model.TipoLancamento;
import br.com.jkavdev.algaworks.jsf.util.jpa.HibernateUtil;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> pessoas = new ArrayList<>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		Session session = HibernateUtil.getSession();

		this.pessoas = session.createCriteria(Pessoa.class)
				.addOrder(Order.asc("nome"))
				.list();

		session.close();
	}

	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void cadastrar() {
		Session session = HibernateUtil.getSession();
		
		session.getTransaction().begin();
		
		session.merge(this.lancamento);
		
		session.getTransaction().commit();
		
		session.close();

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