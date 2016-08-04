package br.com.caelum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	// podemos solucionar o problema do lazy com join fetch
	public List<Produto> getProdutos() {
		// usamos o distinct pois o relacionamento e manytomany
		// podendo ocorrer repeticao de resultados
		// caso uma varias categorias tenha um mesmo produto

		// join fetch indicando que quando o produto for
		// buscado tambem traga as categorias associadas
		
		//tambem e uma solucao para o problema do n+1
		//no qual e realizado varias buscas para match de buscas
		 return em.createQuery("select distinct p from Produto p join fetch p.categorias", Produto.class).getResultList();
		
//		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {

		Session session = em.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Produto.class);

		if (!nome.isEmpty()) {
			criteria.add(Restrictions.like("nome", "%" + nome + "%"));
		}

		if (lojaId != null) {
			criteria.add(Restrictions.eq("loja.id", lojaId));
		}

		if (categoriaId != null) {
			criteria.setFetchMode("categorias", FetchMode.JOIN).createAlias("categorias", "c")
					.add(Restrictions.eq("c.id", categoriaId));
		}

		return criteria.list();

	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
