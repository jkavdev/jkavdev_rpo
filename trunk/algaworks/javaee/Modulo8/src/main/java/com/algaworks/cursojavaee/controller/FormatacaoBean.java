package com.algaworks.cursojavaee.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.Brasil;

@Named
@RequestScoped
public class FormatacaoBean {

	//quando fazemos o inject
	//o cdi verifica se tem algum produtor para aquela classe
	//caso nao tenha ela apenas a instancia
	
	//caso tenha um produtor, ele usura este produto
	//no caso temos dois produtores, e especificamos qual usaremos com o qualificador
	@Inject @Brasil
	private DateFormat formatadorData;

	private Date dataInformada;
	private String dataFormatada;
	
	public void enviar(){
		dataFormatada = formatadorData.format(dataInformada);
	}

	public Date getDataInformada() {
		return dataInformada;
	}

	public void setDataInformada(Date dataInformada) {
		this.dataInformada = dataInformada;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

}
