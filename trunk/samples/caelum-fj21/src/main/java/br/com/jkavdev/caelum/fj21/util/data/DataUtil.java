package br.com.jkavdev.caelum.fj21.util.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

	public static String formataData(Calendar data) {
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		String dataFormatada = formatador.format(data.getTime());

		return dataFormatada;
	}

}
