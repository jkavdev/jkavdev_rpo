package br.com.jkavdev.caelum.fj21.util.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static String formataData(Calendar data) {
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		String dataFormatada = formatador.format(data.getTime());

		return dataFormatada;
	}

	public static Calendar formataDataCalendar(String data) throws ParseException {
		Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data);

		Calendar dataCalendar = Calendar.getInstance();
		dataCalendar.setTime(dataFormatada);

		return dataCalendar;
	}

}
