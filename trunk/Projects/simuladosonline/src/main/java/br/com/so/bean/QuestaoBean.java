package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.so.dao.interfacesDao.IDisciplinaDao;
import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;
import br.com.so.util.AlfabetoUtil;
import br.com.so.modelo.Disciplina;
import br.com.so.modelo.Opcao;

@Named
@ViewScoped
public class QuestaoBean implements Serializable {

	@Inject
	private Prova prova;
	private List<Prova> provas;
	private List<Disciplina> disciplinas;
	@Inject
	private IProvaDao provaDao;
	@Inject
	private IDisciplinaDao disciplinaDao;

	@Inject
	private Questao questao;
	private HashMap<String, Opcao> opcoes;
	private String nomeOpcaoSelecionada;
	private List<String> keyList;
	@Inject
	private Disciplina disciplia;

	private int contador = 0;

	@PostConstruct
	public void init() {
		if (provas == null) {
			provas = provaDao.buscarTodos();
		}
		if (disciplinas != null) {
			disciplinas = disciplinaDao.buscarTodos();
		}
	}

	public void remover(String key) {
		this.opcoes.remove(key);
		this.keyList.remove(key);
	}

	public void adicionarOpcao() {
		if (opcoes == null) {
			opcoes = new HashMap<>();
		}

		if (nomeOpcaoSelecionada != null && !nomeOpcaoSelecionada.trim().equals("")) {
			Opcao opcao = new Opcao();
			opcao.setNome(nomeOpcaoSelecionada);
			int posicao = verificaPosicao();
			opcoes.put(AlfabetoUtil.pegaLetra(posicao), opcao);
			keyList = new ArrayList<String>(opcoes.keySet());
			nomeOpcaoSelecionada = "";
			contador++;
		}
	}

	private int verificaPosicao() {
		for (int i = 0; i < contador; i++) {
			if (!keyList.contains(AlfabetoUtil.pegaLetra(i))) {
				return i;
			}
		}
		return contador;
	}

	public void iniciar() {
		if (questao != null) {
			if (!questao.getDisciplina().getNome().equals("")) {
				if (questao.getTipo().equalsIgnoreCase("Certo ou Errado")) {

				} else if (questao.getTipo().equalsIgnoreCase("Multipla Escolha")) {

				} else {

				}
			}
		}
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

	public HashMap<String, Opcao> getOpcoes() {
		return opcoes;
	}

	public String getNomeOpcaoSelecionada() {
		return nomeOpcaoSelecionada;
	}

	public void setNomeOpcaoSelecionada(String nomeOpcaoSelecionada) {
		this.nomeOpcaoSelecionada = nomeOpcaoSelecionada;
	}

	public List<String> getKeyList() {
		return keyList;
	}

	public Disciplina getDisciplia() {
		return disciplia;
	}

	public void setDisciplia(Disciplina disciplia) {
		this.disciplia = disciplia;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

}
