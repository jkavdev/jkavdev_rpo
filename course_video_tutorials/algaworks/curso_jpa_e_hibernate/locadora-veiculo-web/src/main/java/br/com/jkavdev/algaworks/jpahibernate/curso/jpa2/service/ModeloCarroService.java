package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao.ModeloCarroDao;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.ModeloCarro;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDao modeloDao;

	@Transactional
	public void salvar(ModeloCarro modelo) throws NegocioException {
		if (modelo.getDescricao() == null || "".equals(modelo.getDescricao().trim())) {
			throw new NegocioException("O nome do modelo é obrigatório");
		}

		if (modelo.getFabricante() == null) {
			throw new NegocioException("O fabricante é obrigatório");
		}

		this.modeloDao.salvar(modelo);
	}

}
