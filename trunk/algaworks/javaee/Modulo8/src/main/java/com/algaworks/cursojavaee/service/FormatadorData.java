package com.algaworks.cursojavaee.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.enterprise.inject.Produces;

public class FormatadorData {

	//produces indica que eh um produto da class DateFormat
	
	//no caso temos dois produtores, que teremos que modificar seus qualificadores
	
	//caso queira usar o do brasil, tem que informar apenas o qualificador brasil
	@Produces @Brasil
	public DateFormat getFormatadorDataBrasil() {
		return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
	}

	//por default sera o dos eua
	@Produces
	public DateFormat getFormatadorDataEUA() {
		return new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
	}

}
