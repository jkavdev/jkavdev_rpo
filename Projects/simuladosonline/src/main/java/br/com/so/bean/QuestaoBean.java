package br.com.so.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;
import br.com.so.modelo.Opcao;

@Named
@ViewScoped
public class QuestaoBean implements Serializable {

	@Inject
	private Prova prova;
	private List<Prova> provas;
	@Inject
	private IProvaDao provaDao;
	@Inject
	private Questao questao;
	@Inject
	private List<Opcao> respostas;

	@PostConstruct
	public void init() {
		if (provas == null) {
			provas = provaDao.buscarTodos();
		}
	}

	public void adicionarOpcao() {
		
	}

	public void iniciar() {
		System.out.println("Tipo: " + questao.getTipo());
		System.out.println("Questao: " + questao.getRespostaObjetiva());
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
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

	public List<Opcao> getRespostas() {
		return respostas;
	}

}
