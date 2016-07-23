package br.com.jkavdev.algaworks.jsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
@RequestScoped
public class TesteBean {

	private HtmlInputText inputText;
	private HtmlCommandButton commandButton;

	public void testar() {
		
		if (this.inputText.isDisabled()) {
			this.inputText.setDisabled(false);
			this.commandButton.setStyle("");
		} else {
			this.inputText.setDisabled(true);
			this.commandButton.setStyle("background-color: red; color: white;");
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
