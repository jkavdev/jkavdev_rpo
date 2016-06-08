package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.so.dao.interfacesDao.IDisciplinaDao;
import br.com.so.dao.interfacesDao.IProvaDao;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;
import br.com.so.util.AlfabetoUtil;
import br.com.so.util.jsf.FacesUtil;
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
	private Map<String, Opcao> opcoes;
	private String nomeOpcaoSelecionada;
	private List<String> keyList;

	private int contador = 0;

	@PostConstruct
	public void init() {
		if (provas == null) {
			provas = provaDao.buscarTodos();
		}
		if (disciplinas == null) {
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

	public void cadastrar() {
		if (questao.getEnunciado() != null && !questao.getEnunciado().trim().equals("")) {
			if (questao.getTipo().equals("Multipla Escolha")) {
				if (opcoes != null && !opcoes.isEmpty() && questao.getDisciplina() != null
						&& !questao.getDisciplina().getNome().trim().equals("") && questao.getResposta() != null
						&& !questao.getResposta().trim().equals("")) {
					List<Opcao> listaOpcoes = new ArrayList<>();
					for (Map.Entry<String, Opcao> nomes : opcoes.entrySet()) {
						nomes.getValue().setNome(nomes.getKey() + ") " + nomes.getValue().getNome());
						listaOpcoes.add(nomes.getValue());
					}
					questao.setOpcoes(listaOpcoes);
					limpaPainel();
					FacesUtil.addSuccessMessage("Questão Cadastrada com Sucesso!");
				} else {
					FacesUtil.addWarnMessage("Todos os campos devem ser preenchidos!");
				}
			} else if (questao.getTipo().equals("Certo ou Errado")) {
				if (questao.getResposta() != null && !questao.getResposta().trim().equals("")) {
					limpaPainel();
					FacesUtil.addSuccessMessage("Questão Cadastrada com Sucesso!");
				} else {
					FacesUtil.addWarnMessage("Selecione uma resposta para Questão!");
				}
			} else {
				FacesUtil.addWarnMessage("Selecione um tipo para a Questão!");
			}
		} else {
			FacesUtil.addWarnMessage("Todos os campos devem ser preenchidos!");
		}
	}

	private void limpaPainel() {
		opcoes = new HashMap<>();
		keyList = new ArrayList<>();
		questao.setEnunciado(null);
		questao.setResposta(null);
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

	public Map<String, Opcao> getOpcoes() {
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

}
