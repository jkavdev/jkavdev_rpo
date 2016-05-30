package br.com.so.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.so.dao.interfacesDao.IInstituicaoDao;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

public class InstituicaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	IInstituicaoDao instituicaoDao;

	public void salvar(Instituicao instituicao) {

		if (instituicao != null && instituicao.getNome() != null && !instituicao.getNome().isEmpty()) {
			instituicaoDao.salvar(instituicao);
		} else {
			FacesUtil.addWarnMessage("Todos os Campos devem ser Preenchidos!");
		}
	}

}
