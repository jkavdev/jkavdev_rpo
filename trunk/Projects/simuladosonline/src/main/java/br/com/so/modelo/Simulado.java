package br.com.so.modelo;

import java.util.Calendar;

public class Simulado {
	
	private int pontuacao;
	private Calendar data;
	private String nome;
	private int numeroQuestoes;
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroQuestoes() {
		return numeroQuestoes;
	}
	public void setNumeroQuestoes(int numeroQuestoes) {
		this.numeroQuestoes = numeroQuestoes;
	}

}
