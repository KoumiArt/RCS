package com.koumi.framework.product.rcs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class SystemUtils {
	
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
	
	public static int[] convertStringArray2IntArray(String[] strArr){
		if(strArr == null || strArr.length <0)
			return null;
		int[] intArray = new int[strArr.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArr[i]);
		}
		return intArray;
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
	
	/**
     * 文件重命名
     * @param fileName
     * @return
     */
    public static String getReName(String fileName){
    	if(fileName==null || fileName.trim().length() <=0)
    		return null;
    	if(fileName.lastIndexOf(".")==-1)
    		return fileName;
    	return System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
    }
    
    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass){
    	T obj = null;
		try {
			obj = beanClass.newInstance();
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return obj; 
    }
    

    /**
     * 下划线转大驼峰
     * @param value
     * @return
     */
    public static String toCamel(String value){
    	if(value == null || value.length() <= 0)
    		return "";
    	StringBuffer returnStr = new StringBuffer();
    	if(value.contains("_")){
    		String[] split = value.split("_");
    		for (int i = 0; i < split.length; i++) {
    			returnStr.append(firstToUpperCase(split[i]));
			}
    	} else {
    		returnStr.append(firstToUpperCase(value));
    	}
    	return returnStr.toString();
    }
    
    /**
     * 下划线转小驼峰
     * @param value
     * @return
     */
    public static String toSmallCamel(String value){
    	return firstToLowerCase(toCamel(value));
    }
    
    public static String firstToLowerCase(String value){
    	if(value == null || value.length() <= 0)
    		return "";
    	return value.substring(0,1).toLowerCase() + value.substring(1);
    }
    
    public static String firstToUpperCase(String value){
    	if(value == null || value.length() <= 0)
    		return "";
    	return value.substring(0,1).toUpperCase() + value.substring(1);
    }
    
    public static String convertPackageNameToPath(String packageName){
		return packageName.replace(".", "/");
	}
    
}
