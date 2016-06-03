package br.com.so.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static Date getDateByString(String data) {
		Date d = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			d = (Date) formatter.parse(data.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static boolean validaData(String data) {
		try {
			Date d;
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			d = (Date) formatter.parse(data.toString());
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static Date getDateByCalendar(Calendar data) {
		return data.getTime();
	}

}
