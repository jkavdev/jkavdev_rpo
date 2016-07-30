package br.com.jkavdev.algaworks.jsf.repositories.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.repositories.Lancamentos;

public class LancamenstosHibernate implements Lancamentos {

	private Session session;

	public LancamenstosHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> todos() {
		return session.createCriteria(Lancamento.class)
				.addOrder(Order.asc("dataVencimento"))
				.list();
	}

	@Override
	public Lancamento guardar(Lancamento lancamento) {
		return (Lancamento) session.merge(lancamento);
	}

	@Override
	public void remover(Lancamento lancamento) {
		this.session.delete(lancamento);
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		return (Lancamento) this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.ilike("descricao", lancamento.getDescricao()))
				.add(Restrictions.eq("valor", lancamento.getValor()))
				.add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento()))
				.uniqueResult();
	}

	@Override
	public Lancamento porCodigo(Integer codigo) {
		return this.session.get(Lancamento.class, codigo);
	}

}
