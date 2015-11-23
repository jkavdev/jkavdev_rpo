package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

//backing bean sao beans que alteram os comportamentos visuais dos componentes
//tipo desabilitando um campo, mudando a cor de um botao
@ManagedBean
public class TesteBean {

	// classe que representa o componente no html
	private HtmlInputText inputText;
	private HtmlCommandButton commandButton;

	public void testar() {
		if (this.inputText.isDisabled()) {
			this.inputText.setDisabled(false);
			this.commandButton.setStyleClass("");
		} else {
			this.inputText.setDisabled(true);
			this.commandButton.setStyle("background-color:red; color:white");
		}
	}

	public HtmlInputText getInputText() {
		return inputText;
	}

	public void setInputText(HtmlInputText inputText) {
		this.inputText = inputText;
	}

	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}

}
