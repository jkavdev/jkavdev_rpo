package br.com.jkavdev.algaworks.jsf.repositories.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.jkavdev.algaworks.jsf.model.Pessoa;
import br.com.jkavdev.algaworks.jsf.repositories.Pessoas;

public class PessoasHibernate implements Pessoas {

	private Session session;

	public PessoasHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todas() {
		return session.createCriteria(Pessoa.class)
				.addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return session.get(Pessoa.class, codigo);
	}

}
