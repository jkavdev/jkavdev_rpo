package br.com.jkavdev.samples.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class FormatadorData {

	@Produces
	@Brasil
	public DateFormat getFormatadorDataBrasil() {
		return new SimpleDateFormat("dd 'de' MM 'de' yyyy", new Locale("pt", "BR"));
	}

	@Produces
	@Default
	public DateFormat getFormatadorDataEUA() {
		return new SimpleDateFormat("MM dd, yyyy", Locale.US);
	}

}
