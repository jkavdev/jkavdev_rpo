package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
public class OlaMundoBean {

	private String nome;
	private HtmlInputText campo;
	private HtmlCommandButton botao;

	public void enviar() {
		this.setNome(this.getNome().toUpperCase());
	}

	public void testar() {
		if (this.campo.isDisabled()) {
			this.campo.setDisabled(false);
			this.botao.setStyle("");
		} else {
			this.campo.setDisabled(true);
			this.botao.setStyle("background-color: red; color: white;");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HtmlInputText getCampo() {
		return campo;
	}

	public void setCampo(HtmlInputText campo) {
		this.campo = campo;
	}

	public HtmlCommandButton getBotao() {
		return botao;
	}

	public void setBotao(HtmlCommandButton botao) {
		this.botao = botao;
	}

}
