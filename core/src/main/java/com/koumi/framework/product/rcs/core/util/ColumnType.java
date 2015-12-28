package com.koumi.framework.product.rcs.core.util;

import com.koumi.framework.product.rcs.core.exception.UndefinedDataBaseColumnTypeException;

public enum ColumnType {
	VARCHAR("varchar","String"),
	VARCHAR2("varchar2","String"),
	NUMBER("number","int"),
	DATE("date","Date"),
	DATETIME("datetime","Date"),
	INT("int","int"),
	TINYINT("tinyint","int"),
	DECIMAL("decimal","double");
	
	private String jdbcType;
	
	private String javaType;
	
	private ColumnType(String jdbcType,String javaType){
		this.jdbcType = jdbcType;
		this.javaType = javaType;
	}
	
	public static ColumnType getColumnType(String jdbcType) throws UndefinedDataBaseColumnTypeException{
		for (ColumnType columnType : ColumnType.values()) {
			if(jdbcType.trim().equalsIgnoreCase(columnType.getJdbcType()))
				return columnType;
		}
		throw new UndefinedDataBaseColumnTypeException("无法失败的类型:"+jdbcType);
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	
}
