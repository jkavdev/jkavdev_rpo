package br.com.jkavdev.pedidovenda.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.jkavdev.pedidovenda.model.Produto;

public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto salvar(Produto produto) {
		this.manager.persist(produto);
		return this.manager.merge(produto);
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

}
