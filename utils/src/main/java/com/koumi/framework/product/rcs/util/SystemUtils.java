package com.koumi.framework.product.rcs.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class SystemUtils {
	
	public static int[] convertIntArray(String[] strArr){
		if(strArr == null || strArr.length <0)
			return null;
		int[] intArray = new int[strArr.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArr[i]);
		}
		return intArray;
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
