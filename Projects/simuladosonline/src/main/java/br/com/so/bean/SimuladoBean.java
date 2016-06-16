package br.com.so.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.so.util.jsf.FacesUtil;

@Named
@ViewScoped
public class SimuladoBean implements Serializable {
	private int numero = 2;
	private String formato = "Min";
	private int intervalo = 20;
	private String cor = "black";

	public void decrementa() {
		if (numero != 0) {
			numero--;
			if (numero == 1 && intervalo == 20) {
				numero = 60;
				formato = "Seg";
				cor = "red";
				intervalo = 1;
				RequestContext.getCurrentInstance().update("formulario:painel");
			}
		} else {
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

}
