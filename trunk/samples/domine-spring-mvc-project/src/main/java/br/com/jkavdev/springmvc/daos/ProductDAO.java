package br.com.jkavdev.springmvc.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.jkavdev.springmvc.model.Product;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Product produto) {
		manager.persist(produto);
	}

	public List<Product> list() {
		return manager.createQuery("select p from Product p", Product.class).getResultList();
	}

	public Product find(Integer id) {
		TypedQuery<Product> query = manager
				.createQuery("select distinct(p) from Product p join fetch p.prices where p.id=:id", Product.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}
}
