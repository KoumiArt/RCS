package com.koumi.framework.product.rcs.restfulapi.generatecode.bean;

import java.util.List;

import com.koumi.framework.product.rcs.core.database.bean.Column;

public class GenerateCodeInfo {

	private String tableName;

	/**
	 * 实例名
	 */
	private String classNameVar;

	/**
	 * 类名
	 */
	private String className;

	/**
	 * 
	 */
	private String nameSpaceName;

	/**
	 * 
	 */
	private List<Column> columns;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassNameVar() {
		return classNameVar;
	}

	public void setClassNameVar(String classNameVar) {
		this.classNameVar = classNameVar;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNameSpaceName() {
		return nameSpaceName;
	}

	public void setNameSpaceName(String nameSpaceName) {
		this.nameSpaceName = nameSpaceName;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

}
