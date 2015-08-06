package com.koumi.framework.product.rcs.core.database.bean;

import java.util.List;

import com.koumi.framework.product.rcs.util.SystemUtils;

/**
 * @author koumi 数据库列
 * 
 */
public class Column {

	/**
	 * 字段名
	 */
	private String columnName;
	
	private int isNULL;
	
	private int digits; 
	
	private int size;
	
	private String type;
	
	private ColumnType columnType;
	
	public ColumnType getColumnType() {
		columnType = ColumnType.getColumnType(type);
		return columnType;
	}

	private List<PrimaryKey> primaryKeys;
	
	private int pk;
	
	private int fk;
	
	private String property;
	
	public String getProperty() {
		property = SystemUtils.toSmallCamel(columnName);
		return property;
	}

	public int getFk() {
		return fk;
	}

	public void setFk(int fk) {
		this.fk = fk;
	}

	public int getPk() {
		if (primaryKeys != null && primaryKeys.size() > 0) {
			for (PrimaryKey primaryKey : primaryKeys) {
				if(primaryKey.getColumnName().equalsIgnoreCase(this.columnName))
					pk = 1;
					return pk;
			}
		}
		pk = 0;
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	/**
	 * 字段的描述名
	 */
	private String remark;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getIsNULL() {
		return isNULL;
	}

	public void setIsNULL(int isNULL) {
		this.isNULL = isNULL;
	}

	public int getDigits() {
		return digits;
	}

	public void setDigits(int digits) {
		this.digits = digits;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PrimaryKey> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(List<PrimaryKey> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

}
