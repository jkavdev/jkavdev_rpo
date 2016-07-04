package br.com.jkavdev.algaworks.spring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.algaworks.spring.model.Imovel;

@Repository
public class Imoveis {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void guardar(Imovel imovel) {
		manager.persist(imovel);
	}

}
