package br.com.jkavdev.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.repository.filter.ProdutoFilter;
import br.com.jkavdev.pedidovenda.service.NegocioException;
import br.com.jkavdev.pedidovenda.util.jpa.Transactional;

public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto salvar(Produto produto) {
		return this.manager.merge(produto);
	}
	
	@Transactional
	public void remover(Produto produto){
		try{
		produto = porId(produto.getId());
		this.manager.remove(produto);
		this.manager.flush();
		} catch(PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído");
		}
	}

	public Produto porSku(String sku) {
		String jpql = "from Produto where upper(sku) = :sku";

		try {
			return this.manager.createQuery(jpql, Produto.class)
					.setParameter("sku", sku)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(ProdutoFilter filtro) {
		Session session = this.manager.unwrap(Session.class);
//		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(Produto.class);

		if (StringUtils.isNotBlank(filtro.getSku())) {
			criteria.add(Restrictions.eq("sku", filtro.getSku()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Produto porId(Long id) {
		return this.manager.find(Produto.class, id);
	}

}
