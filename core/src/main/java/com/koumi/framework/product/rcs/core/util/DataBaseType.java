package com.koumi.framework.product.rcs.core.util;

public enum DataBaseType {
	MYSQL("mysql"), ORACLE("oracle"), SQLSERVER("sqlserver");
	
	private String value;

	private DataBaseType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
