package br.com.jkavdev.algaworks.jsf.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.util.jpa.HibernateUtil;

@ManagedBean
public class ConsultaLancamentoBean {

	private List<Lancamento> lancamentos = new ArrayList<>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		Session session = HibernateUtil.getSession();
		
		this.lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
		
		session.close();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
