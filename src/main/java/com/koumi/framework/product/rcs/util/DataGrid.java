package com.koumi.framework.product.rcs.util;

import java.util.List;

public class DataGrid {

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 记录列表
	 */
	private List<?> rows;

	/**
	 * @return total 条数
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            条数
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return rows 记录集合
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            记录集合
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
