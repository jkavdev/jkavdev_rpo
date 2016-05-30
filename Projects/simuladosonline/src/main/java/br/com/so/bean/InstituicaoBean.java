package br.com.so.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.IInstituicaoDao;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

@Named
@RequestScoped
public class InstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	IInstituicaoDao instituicaoDao;
	private Instituicao instituicao;

	public void salvar() {
		if (instituicao != null && instituicao.getNome() != null && !instituicao.getNome().trim().equals("")) {
			if (!instituicaoDao.existe(instituicao)) {
				instituicaoDao.salvar(instituicao);
				FacesUtil.addSuccessMessage("Instituição salva com Sucesso!");
			}
		} else {
			FacesUtil.addWarnMessage("Todos os Campos devem ser Preenchidos!");
		}
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
