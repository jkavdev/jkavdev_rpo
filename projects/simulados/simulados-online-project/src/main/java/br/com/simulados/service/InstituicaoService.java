package br.com.simulados.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.simulados.dao.IInstituicaoDao;
import br.com.simulados.modelo.Instituicao;

public class InstituicaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	// IInstituicaoDao instituicaoDao = new HibernateInstituicaoDao();
	@Inject
	IInstituicaoDao instituicaoDao;

	public void salvar(Instituicao instituicao) throws NegocioException {

		if (instituicao == null || "".trim().equals(instituicao.getNome())) {
			throw new NegocioException("O nome da instituição é obrigatório!");
		}

		instituicaoDao.salvar(instituicao);
	}

}
