package br.com.so.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.so.dao.InstituicaoDao;
import br.com.so.modelo.Instituicao;

@ManagedBean
@RequestScoped
public class InstituicaoBean implements Serializable {

	private Instituicao instituicao = new Instituicao();
	private InstituicaoDao instituicaoDao = new InstituicaoDao();

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void salvar() {
		if (!instituicaoDao.existe(instituicao)) {
			instituicaoDao.salvar(instituicao);
		} else {

		}
	}

}
