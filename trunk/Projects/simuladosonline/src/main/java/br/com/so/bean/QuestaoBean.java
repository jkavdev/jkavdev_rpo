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
	private HashMap<String, Opcao> opcoes;
	private String nomeOpcaoSelecionada;
	private List<String> keyList;

	private static int contador = 0;
	private char[] alfaLetra = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	@PostConstruct
	public void init() {
		keyList = new ArrayList<>();
		if (provas == null) {
			provas = provaDao.buscarTodos();
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
			opcoes.put(String.valueOf(alfaLetra[contador]).toUpperCase(), opcao);
			keyList = new ArrayList<String>(opcoes.keySet());
			nomeOpcaoSelecionada = "";
			contador++;
		}
	}

	public void iniciar() {
		System.out.println("Tipo: " + questao.getTipo());
		System.out.println("Opções:");
		for (String chave : keyList) {
			System.out.println(chave + ") " + opcoes.get(chave));
		}
		System.out.println("Resposta: " + questao.getResposta());
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

}
