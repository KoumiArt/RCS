package com.koumi.framework.product.rcs.core.database;

import java.util.List;

import com.koumi.framework.product.rcs.core.database.bean.Column;
import com.koumi.framework.product.rcs.core.database.bean.DataBaseInfo;
import com.koumi.framework.product.rcs.core.database.bean.PrimaryKey;
import com.koumi.framework.product.rcs.core.database.bean.TableInfo;
import com.koumi.framework.product.rcs.core.exception.DataBaseException;


public interface IDataBase {
	
	public void openSession(DataBaseInfo dbInfo)  throws DataBaseException;
	
	public List<Column> selectColumns(String tableName)  throws DataBaseException;
	
	public List<PrimaryKey> selectPrimaryKeys(String tableName) throws DataBaseException;
	
	public List<TableInfo> selectTables() throws DataBaseException;
	
}
