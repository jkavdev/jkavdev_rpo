package br.com.jkavdev.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.pedidovenda.model.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Categoria> raizes() {
		String jpql = "from Categoria where categoriaPai is null";

		return this.manager.createQuery(jpql, Categoria.class).getResultList();
	}

	public Categoria porId(Long id) {
		return this.manager.find(Categoria.class, id);
	}

	public List<Categoria> SubcategoriasDe(Categoria categoriaPai) {
		String jpql = "from Categoria where categoriaPai = :categoriaPai";

		return this.manager.createQuery(jpql, Categoria.class)
				.setParameter("categoriaPai", categoriaPai)
				.getResultList();
	}

}
