package br.com.simulados.modelo;

import java.util.Calendar;

public class Comentario {

	private Usuario autorComentario;
	private Calendar dataComentario;
	private Questao questao;

	public Usuario getAutorComentario() {
		return autorComentario;
	}

	public void setAutorComentario(Usuario autorComentario) {
		this.autorComentario = autorComentario;
	}

	public Calendar getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Calendar dataComentario) {
		this.dataComentario = dataComentario;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

}
