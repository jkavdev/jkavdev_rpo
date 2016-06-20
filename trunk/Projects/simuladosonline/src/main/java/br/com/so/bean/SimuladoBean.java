package br.com.so.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;
import br.com.so.util.QuestaoConstantes;
import br.com.so.util.jsf.FacesUtil;

@Named
@ViewScoped
public class SimuladoBean implements Serializable {
	private int numero = 2;
	private String formato = "Min";
	private int intervalo = 60;
	private static Prova prova;
	private String cor = "black";
	private Map<Questao, String> mapaAuxiliar = new HashMap<Questao, String>();
	private String resposta;
	@Inject
	private Questao questao;
	@Inject
	private QuestaoConstantes qConstantes;
	private static List<Questao> questoes = new ArrayList<>();

	public void decrementa() {
		if (numero != 0) {
			numero--;
			if (numero == 1 && intervalo == 60) {
				numero = 60;
				formato = "Seg";
				cor = "red";
				intervalo = 1;
				RequestContext.getCurrentInstance().update("formulario");
			}
		} else {
			intervalo = 1000;
			FacesUtil.addWarnMessage("Acabou o Tempo!");
		}
	}

	public int getNumero() {
		return numero;
	}

	public String getFormato() {
		return formato;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public String getCor() {
		return cor;
	}

	public static void setQuestoes(List<Questao> questoes) {
		if (SimuladoBean.questoes != null) {
			SimuladoBean.questoes = null;
		}
		SimuladoBean.questoes = questoes;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public Prova getProva() {
		return prova;
	}

	public static void setProva(Prova prova) {
		SimuladoBean.prova = prova;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public void processaResposta() throws InstantiationException, IllegalAccessException {
//		int index = resposta.indexOf('|');
//		index += 1;
//		String endereco = resposta.substring(index, resposta.length());
//		endereco = endereco.trim();
//		try {
//			Class qst = Class.forName(endereco);
//			questao = (Questao) qst.newInstance();
//			System.out.println(questao.getEnunciado());
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		System.out.println(questao.getEnunciado());
		System.out.println(resposta);
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public String getCertoErrado() {
		return qConstantes.getCertoErrado();
	}

	public String getMultiplaEscolha() {
		return qConstantes.getMultiplaEscolha();
	}
}
