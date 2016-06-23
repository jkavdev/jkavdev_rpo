package br.com.jkavdev.samples.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.samples.service.Brasil;

@Named
@RequestScoped
public class FormatacaoBean {

	@Inject
	// @Default
	@Brasil
	private DateFormat formatadorData;
	private Date dataInformada;
	private String dataFormatada;

	public void enviar() {
		this.dataFormatada = this.formatadorData.format(this.dataInformada);
	}

	public Date getDataInformada() {
		return this.dataInformada;
	}

	public void setDataInformada(Date dataInformada) {
		this.dataInformada = dataInformada;
	}

	public String getDataFormatada() {
		return this.dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

}
