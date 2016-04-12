package br.com.jkavdev.financeiro.conta;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jkavdev.financeiro.usuario.Usuario;

public class ContaDaoHibernate implements ContaDao {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Conta conta) {
		this.session.saveOrUpdate(conta);
	}

	@Override
	public void excluir(Conta conta) {
		this.session.delete(conta);
	}

	@Override
	public Conta carregar(Integer conta) {
		return (Conta) this.session.get(Conta.class, conta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> listar(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Conta.class);		
		criteria.add(Restrictions.eq("usuario", usuario));				//trazendo apenas as contas vinculadas ao usuario informado
		return criteria.list();
	}

	@Override
	public Conta buscarFavorita(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));				//trara a conta favorita do usuario		
		criteria.add(Restrictions.eq("favorita", true));				//apenas um resultado		
		return (Conta) criteria.uniqueResult();
	}

}
