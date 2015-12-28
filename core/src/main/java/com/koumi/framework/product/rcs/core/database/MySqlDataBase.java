package com.koumi.framework.product.rcs.core.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koumi.framework.product.rcs.core.database.bean.Column;
import com.koumi.framework.product.rcs.core.database.bean.DataBaseInfo;
import com.koumi.framework.product.rcs.core.database.bean.PrimaryKey;
import com.koumi.framework.product.rcs.core.database.bean.TableInfo;
import com.koumi.framework.product.rcs.core.exception.DataBaseException;
import com.koumi.framework.product.rcs.core.util.ColumnType;
import com.koumi.framework.product.rcs.util.SystemConfigBean;

public class MySqlDataBase implements IDataBase {
	
	private String driverClassName = SystemConfigBean.getProperty("database.driverClassName");  
	
	private String url = SystemConfigBean.getProperty("database.url");
	
	private String userName = SystemConfigBean.getProperty("database.userName");
	
	private String password = SystemConfigBean.getProperty("database.password");
	
	private Connection con;
	
	private PreparedStatement ps;
	
	
	public MySqlDataBase() throws DataBaseException{
		try {
			openSession();
		} catch (DataBaseException e) {
			throw new DataBaseException("数据源连接打开异常！",e);
		}
	}
	
	private void closeSession() throws DataBaseException{
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (con != null && !con.isClosed()){
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			throw new DataBaseException("数据源连接关闭异常！",e);
		}
	}

	private void openSession()  throws DataBaseException{
		try {
			if(con != null && !con.isClosed())
				return;
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			throw new DataBaseException("数据源连接打开异常！",e);
		}
	}
	
	public void openSession(DataBaseInfo dbInfo)  throws DataBaseException{
		try {
			con = null;
			ps = null;
			Class.forName(dbInfo.getDriverClassName());
			con = DriverManager.getConnection(dbInfo.getUrl(), dbInfo.getUserName(), dbInfo.getPassword());
		} catch (Exception e) {
			throw new DataBaseException(e);
		}
	}

	public List<Column> selectColumns(String tableName) throws DataBaseException {
		List<Column> columns = new ArrayList<Column>();
		try {
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet rs = metaData.getColumns(null, "test", tableName, "%");
			while(rs.next()){
				Column column = new Column();
				column.setColumnName(rs.getString("COLUMN_NAME")); 
				column.setRemark(rs.getString("REMARKS"));
				column.setType(rs.getString("TYPE_NAME")); 
				column.setSize(rs.getInt("COLUMN_SIZE")); 
				column.setDigits(rs.getInt("DECIMAL_DIGITS")); 
				column.setIsNULL(rs.getInt("NULLABLE")); 
				column.setPrimaryKeys(getPrimaryKeys(metaData, tableName));
				ColumnType columnType = ColumnType.getColumnType(rs.getString("TYPE_NAME"));
				column.setColumnType(columnType);
				columns.add(column);
			}
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			throw new DataBaseException(e);
		} finally {
			closeSession();
		} 
		return columns;
	}
	
	private List<PrimaryKey> getPrimaryKeys(DatabaseMetaData metaData,String tableName) throws SQLException{
		List<PrimaryKey> primaryKeys = new ArrayList<PrimaryKey>();
		ResultSet rs = metaData.getPrimaryKeys(null, null, tableName);
		while(rs.next()){
			PrimaryKey primaryKey = new PrimaryKey();
			primaryKey.setTableCat(rs.getString(1)); 
			primaryKey.setTableSchem(rs.getString(2)); 
			primaryKey.setTableName(rs.getString(3)); 
			primaryKey.setColumnName(rs.getString(4)); 
			primaryKey.setKeySeq(rs.getInt(5)); 
			primaryKey.setPkName(rs.getString(6)); 
			primaryKeys.add(primaryKey);
		}
		if(rs != null)
			rs.close();
		return primaryKeys;
	}
	
	public List<PrimaryKey> selectPrimaryKeys(String tableName) throws DataBaseException {
		List<PrimaryKey> primaryKeys = new ArrayList<PrimaryKey>();
		try {
			DatabaseMetaData metaData = con.getMetaData();
			primaryKeys = getPrimaryKeys(metaData, tableName);
		} catch (Exception e) {
			throw new DataBaseException(e);
		} finally {
			closeSession();
		}
		return primaryKeys;
	}

	public List<TableInfo> selectTables() throws DataBaseException {
		List<TableInfo> tables = new ArrayList<TableInfo>();
		try {
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet rs = metaData.getTables(null, "%", null, new String[]{"TABLE"});
			while(rs.next()){
				TableInfo table = new TableInfo();
				table.setTableName(rs.getString("TABLE_NAME"));
				tables.add(table);
			}
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			throw new DataBaseException(e);
		} finally {
			
			closeSession();
		} 
		return tables;
	}
	
}
