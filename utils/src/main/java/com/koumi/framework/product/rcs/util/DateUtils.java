package com.koumi.framework.product.rcs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/**
	 * 于当前时间做对比 小于等于当前时间 返回false反之为true
	 * @param date
	 * @return
	 */
	public static boolean checkCurDate(String dateStr){
		if(dateStr == null || dateStr.equals("") || dateStr.trim().length() <0)
			return false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		try {
			Date date = sdf.parse(dateStr);
			long comptime = date.getTime();
			Calendar instance = Calendar.getInstance();
			int hour = instance.get(Calendar.HOUR);
			instance.set(Calendar.HOUR, hour+1);
			long curtime = instance.getTime().getTime();
			if(comptime <= curtime){
				return false;
			}
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 于当前时间做对比 小于等于当前时间 返回false反之为true
	 * @param date
	 * @return
	 */
	public static boolean checkCurDate(Date date){
		if(date == null)
			return false;
		long comptime = date.getTime();
		Calendar instance = Calendar.getInstance();
		int hour = instance.get(Calendar.HOUR);
		instance.set(Calendar.HOUR, hour+1);
		long curtime = instance.getTime().getTime();
		if(comptime <= curtime){
			return false;
		}
		return true;
	}
	
	/**
	 * 获取今天的开始时间
	 * @return
	 */
	public static String getDayStarTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = sdf.format(new Date());
		return formatDate + " 00:00:00";
	}
	
	/**
	 * 获取今天的结束时间
	 * @return
	 */
	public static String getDayEndTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = sdf.format(new Date());
		return formatDate + " 23:59:59";
	}
	
}
