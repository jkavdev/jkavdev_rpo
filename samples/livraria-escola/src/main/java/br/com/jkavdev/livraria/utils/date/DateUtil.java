package br.com.jkavdev.livraria.utils.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	private static final int MS_IN_HOUR = 1000 * 60 * 60;
	private static final int MS_IN_Day = 24 * MS_IN_HOUR;

	private DateUtil() {
	}

	public static void removeTimeFrom(final Calendar c) {
		c.clear(Calendar.AM_PM);
		c.clear(Calendar.HOUR_OF_DAY);
		c.clear(Calendar.HOUR);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.SECOND);
		c.clear(Calendar.MILLISECOND);
	}

	public static int daysBetween(final Date d1, final Date d2) {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(d1);
		GregorianCalendar c2 = new GregorianCalendar();
		c2.setTime(d2);

		final long t1 = c1.getTimeInMillis();
		final long t2 = c2.getTimeInMillis();
		long diff = t2 - t1;

		final boolean startInDst = c1.getTimeZone().inDaylightTime(d1);
		final boolean endInDst = c2.getTimeZone().inDaylightTime(d2);

		if (startInDst && !endInDst) {
			diff -= MS_IN_HOUR;
		}
		if (!startInDst && endInDst) {
			diff += MS_IN_HOUR;
		}

		return (int) (diff / MS_IN_Day);
	}
}
