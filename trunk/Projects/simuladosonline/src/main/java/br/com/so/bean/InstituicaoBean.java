package br.com.so.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.InstituicaoDao;
import br.com.so.modelo.Instituicao;

@Named
@RequestScoped
public class InstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instituicao instituicao = new Instituicao();
	@Inject
	private InstituicaoDao instituicaoDao;

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void salvar() {
		if (instituicaoDao != null) {
			if (!instituicaoDao.existe(instituicao)) {
				instituicaoDao.salvar(instituicao);
			} else {

			}
		}
	}

}
