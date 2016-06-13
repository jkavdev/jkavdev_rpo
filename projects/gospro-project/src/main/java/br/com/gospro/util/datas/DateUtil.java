package br.com.gospro.util.datas;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Calendar getCalendarByString(String data) {

		Date date = new Date(data);
		Calendar dataFormatada = Calendar.getInstance();

		dataFormatada.setTime(date);

		return dataFormatada;
	}

}
