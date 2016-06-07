package br.com.so.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.IDisciplinaDao;
import br.com.so.modelo.Disciplina;
import br.com.so.util.jsf.FacesUtil;

@Named
@RequestScoped
public class DisciplinaBean implements Serializable {

	@Inject
	private Disciplina disciplina;

	@Inject
	private IDisciplinaDao disciplinaDao;

	public void salvar() {
		if (disciplina != null && disciplina.getNome() != null && !disciplina.getNome().trim().equals("")) {
			if (!disciplinaDao.existe(disciplina)) {
				disciplinaDao.salvar(disciplina);
				FacesUtil.addSuccessMessage("Disciplina salva com Sucesso!");
			}
		} else {
			FacesUtil.addWarnMessage("Todos os Campos devem ser Preenchidos!");
		}
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
