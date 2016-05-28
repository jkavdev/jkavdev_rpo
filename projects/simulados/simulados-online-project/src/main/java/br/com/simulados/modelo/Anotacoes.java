package br.com.simulados.modelo;

public class Anotacoes {

	private String lembrete;
	private Comentario comentario;
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLembrete() {
		return lembrete;
	}

	public void setLembrete(String lembrete) {
		this.lembrete = lembrete;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

}
