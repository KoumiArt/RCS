package com.koumi.framework.product.rcs.core.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koumi.framework.product.rcs.util.SystemConfigBean;
import com.koumi.framework.product.rcs.core.exception.DataBaseException;
import com.koumi.framework.product.rcs.core.util.DataBaseType;

public class DataBaseFactory {
	
	private static Logger logger = LoggerFactory.getLogger(DataBaseFactory.class);
	
	public static IDataBase create() throws DataBaseException{
		IDataBase dataBase = null;
		try {
			String type = SystemConfigBean.getProperty("database.type");
			if(type == DataBaseType.MYSQL.getValue())
				dataBase = new MySqlDataBase();
		} catch (Exception e) {
			logger.error("DataBaseFactory创建实例异常！",e);
			throw new DataBaseException("创建实例异常！");
		} finally {
			if(dataBase == null){
				throw new DataBaseException("创建实例异常！");
			}
		}
		return dataBase; 
	}
	
	public static IDataBase create(String type) throws DataBaseException{
		IDataBase dataBase = null;
		try {
			if(type.equalsIgnoreCase(DataBaseType.MYSQL.getValue()))
				dataBase = new MySqlDataBase();
		} catch (Exception e) {
			logger.error("DataBaseFactory创建实例异常！",e);
			throw new DataBaseException("创建实例异常！");
		} finally {
			if(dataBase == null){
				throw new DataBaseException("创建实例异常！");
			}
		}
		return dataBase; 
	}
	
}
