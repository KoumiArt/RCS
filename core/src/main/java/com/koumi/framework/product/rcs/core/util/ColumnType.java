package com.koumi.framework.product.rcs.core.util;

public enum ColumnType {
	VARCHAR("varchar","String"),
	VARCHAR2("varchar2","String"),
	NUMBER("number","int"),
	DATE("date","Date"),
	DATETIME("datetime","Date"),
	INT("int","int");
	
	private String jdbcType;
	
	private String javaType;
	
	private ColumnType(String jdbcType,String javaType){
		this.jdbcType = jdbcType;
		this.javaType = javaType;
	}
	
	public static ColumnType getColumnType(String jdbcType){
		if(jdbcType.trim().equalsIgnoreCase(VARCHAR.jdbcType))
			return VARCHAR;
		if(jdbcType.trim().equalsIgnoreCase(VARCHAR2.jdbcType))
			return VARCHAR2;
		if(jdbcType.trim().equalsIgnoreCase(NUMBER.jdbcType))
			return NUMBER;
		if(jdbcType.trim().equalsIgnoreCase(DATE.jdbcType))
			return DATE;
		if(jdbcType.trim().equalsIgnoreCase(DATETIME.jdbcType))
			return DATETIME;
		if(jdbcType.trim().equalsIgnoreCase(INT.jdbcType))
			return INT;
		return null;
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
