package br.com.so.util;

import java.io.Serializable;

public class QuestaoConstantes implements Serializable{

	private static final String MULTIPLA_ESCOLHA = "Multipla Escolha";
	private static final String CERTO_ERRADO = "Certo ou Errado";

	public String getMultiplaEscolha() {
		return QuestaoConstantes.MULTIPLA_ESCOLHA;
	}

	public String getCertoErrado() {
		return QuestaoConstantes.CERTO_ERRADO;
	}

}
