package br.com.so.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Prova;

@Named
@ViewScoped
public class QuestaoBean {

	@Inject
	private Prova prova;
	private List<Prova> provas;
	@Inject
	private IProvaDao provaDao;

	@PostConstruct
	public void init() {
		if (provas == null) {
			provas = provaDao.buscarTodos();
		}
	}

	public void iniciar() {

	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public IProvaDao getProvaDao() {
		return provaDao;
	}

	public void setProvaDao(IProvaDao provaDao) {
		this.provaDao = provaDao;
	}

	public List<Prova> getProvas() {
		return provas;
	}

}
