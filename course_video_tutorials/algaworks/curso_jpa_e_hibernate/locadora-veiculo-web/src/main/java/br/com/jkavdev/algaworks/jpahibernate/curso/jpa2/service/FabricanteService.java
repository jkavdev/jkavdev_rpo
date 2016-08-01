package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao.FabricanteDao;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jpa.Transactional;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null || "".equals(fabricante.getNome().trim())) {
			throw new NegocioException("O nome do fabricante é obrigatório");
		}

		this.fabricanteDao.salvar(fabricante);
	}

}