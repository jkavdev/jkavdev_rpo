package br.com.simulados.service;

import br.com.simulados.dao.InstituicaoDao;
import br.com.simulados.modelo.Instituicao;

public class CadastroInstituicaoService {

	private InstituicaoDao instituicaoDao;

	public CadastroInstituicaoService() {
		instituicaoDao = new InstituicaoDao();
	}

	public void salvar(Instituicao instituicao) throws NegocioException {
		if (instituicao.getNome() == null || instituicao.getNome().trim().equals("")) {
			throw new NegocioException("O nome da Instituição é obrigatório!");
		}

		this.instituicaoDao.salvar(instituicao);
	}

	public InstituicaoDao getInstituicaoDao() {
		return instituicaoDao;
	}

	public void setInstituicaoDao(InstituicaoDao instituicaoDao) {
		this.instituicaoDao = instituicaoDao;
	}

}
