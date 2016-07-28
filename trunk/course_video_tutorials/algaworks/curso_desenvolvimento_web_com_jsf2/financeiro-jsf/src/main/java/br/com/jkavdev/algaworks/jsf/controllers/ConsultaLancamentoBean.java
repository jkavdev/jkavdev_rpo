package br.com.jkavdev.algaworks.jsf.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.util.jpa.HibernateUtil;

@ManagedBean
public class ConsultaLancamentoBean {

	private List<Lancamento> lancamentos = new ArrayList<>();
	private Lancamento lancamentoSelecionado;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		Session session = HibernateUtil.getSession();

		this.lancamentos = session.createCriteria(Lancamento.class).addOrder(Order.desc("dataVencimento")).list();

		session.close();
	}
	
	public void excluir(){
		if(this.lancamentoSelecionado.isPago()){
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento já foi pago e não pode ser excluído");	
		} else { 		
			Session session = HibernateUtil.getSession();
			
			session.getTransaction().begin();
	
			session.delete(this.lancamentoSelecionado);
			
			session.getTransaction().commit();
	
			session.close();
			
			this.init();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
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
