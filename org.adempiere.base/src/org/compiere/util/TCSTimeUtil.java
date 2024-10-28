package org.compiere.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TCSTimeUtil {
	/**
	 * @author Stephan
	 * @param Day
	 * @return Last date in year
	 */
	public static Timestamp getLastMonthInYear(Timestamp day){
		if (day == null)
			day = new Timestamp(System.currentTimeMillis());
		GregorianCalendar cal = new GregorianCalendar(Language.getLoginLanguage().getLocale());
		cal.setTimeInMillis(day.getTime());
		cal.set(Calendar.MONTH,11);
		return new Timestamp (cal.getTimeInMillis());
	}
	
	/**
	 * @author Stephan
	 * @param Day
	 * @return Year
	 */
	public static int getYear(Timestamp day){
		if (day == null)
			day = new Timestamp(System.currentTimeMillis());
		GregorianCalendar cal = new GregorianCalendar(Language.getLoginLanguage().getLocale());
		cal.setTimeInMillis(day.getTime());
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * @author Stephan
	 * @param Day
	 * @return Month
	 */
	public static int getMonth(Timestamp day){
		if (day == null)
			day = new Timestamp(System.currentTimeMillis());
		GregorianCalendar cal = new GregorianCalendar(Language.getLoginLanguage().getLocale());
		cal.setTimeInMillis(day.getTime());
		return cal.get(Calendar.MONTH);
	}
	
	/**
	 * @author Stephan
	 * @param Date
	 * @return number of days in month
	 */
	public static int getNumberOfDaysInMonth(Timestamp date){
		if (date == null)
			date = new Timestamp(System.currentTimeMillis());
		GregorianCalendar cal = new GregorianCalendar(Language.getLoginLanguage().getLocale());
		cal.setTimeInMillis(date.getTime());
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * @author Stephan
	 * @param Date
	 * @return number of days in year
	 */
	public static int getNumberOfDaysInYear(Timestamp date){
		if (date == null)
			date = new Timestamp(System.currentTimeMillis());
		GregorianCalendar cal = new GregorianCalendar(Language.getLoginLanguage().getLocale());
		cal.setTimeInMillis(date.getTime());
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}
}
