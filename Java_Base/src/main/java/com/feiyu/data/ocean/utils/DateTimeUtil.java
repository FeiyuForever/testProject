package com.feiyu.data.ocean.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间共工具类 Created by lzhu.raymond
 */
public class DateTimeUtil {

	/**
	 * Get date string of today.
	 * 
	 * @return
	 */
	public static String getDateString() {
		return getDateString(0, "yyyyMMdd");
	}

	/**
	 * Get date string of Nth months before/after current day.
	 * 
	 * @param monthsOffset
	 * @return
	 */
	public static String getDateString(int monthsOffset) {
		return getDateString(monthsOffset, "yyyyMMdd");
	}

	/**
	 * Get date string of Nth months before/after current day.
	 * 
	 * @param monthsOffset
	 * @param format
	 * @return
	 */
	public static String getDateString(int monthsOffset, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthsOffset);
		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * Convert given date string with srcFormat to specify tarFormat.
	 * @param srcDate
	 * @param srcFormat
	 * @param tarFormat
	 * @return
	 */
	public static String convertDateFormat(String srcDate, String srcFormat, String tarFormat) {
	    try {
			DateFormat srcFormatter = new SimpleDateFormat(srcFormat);
			Date src = srcFormatter.parse(srcDate);

			DateFormat tarFormatter = new SimpleDateFormat(tarFormat);
			return tarFormatter.format(src);
		} catch(Exception e) {
	    	return srcDate;
		}
	}

	/**
	 * 柴荣臻 将英文日期格式转化为短日期格式 Thu May 10 08:00:00 CST 2001 => 2001-05-10
	 * 
	 * @param dateString
	 *            Thu May 10 08:00:00 CST 2001
	 * @return
	 */
	public static String convertShortDateString(String dateString) {
		/*
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"EEE MMM d HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
			return newFormat.format(date);
		} catch (Exception e) {
			return dateString;
		}*/
		return convertShortDateString(dateString, "yyyy-MM-dd");

	}

	public static String convertShortDateString(String dateString, String format) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"EEE MMM d HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			SimpleDateFormat newFormat = new SimpleDateFormat(format);
			return newFormat.format(date);
		} catch (Exception e) {
			return dateString;
		}
	}

	/**
	 * 将日期转为格式 yyyy-MM-dd
	 * 
	 * @return 2001-05-10
	 */
	public static String convertDateToString(Date date) {
		try {
			SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
			return newFormat.format(date);
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 将字符串日期进行转化
	 */
	public static String convertDate(String date){
		try {
			SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = newFormat.parse(date);
			SimpleDateFormat dateString = new SimpleDateFormat(date);
			return dateString.format(date1);
		}catch (Exception e){
			return date;
		}
	}

}
