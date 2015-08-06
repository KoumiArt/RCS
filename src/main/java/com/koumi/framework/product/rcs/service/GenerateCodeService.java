package com.koumi.framework.product.rcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koumi.framework.product.rcs.core.database.DataBaseFactory;
import com.koumi.framework.product.rcs.core.database.IDataBase;
import com.koumi.framework.product.rcs.core.database.bean.Column;
import com.koumi.framework.product.rcs.core.database.bean.DataBaseInfo;
import com.koumi.framework.product.rcs.restfulapi.bean.ErrorCode;
import com.koumi.framework.product.rcs.restfulapi.generatecode.util.GenerateCodeUtil;

@Service("generateCodeService")
public class GenerateCodeService {

	public void execute(String dbConfigId,String tableName,String packageName) throws Exception{
		IDataBase db = DataBaseFactory.create();
		DataBaseInfo dbInfo = new DataBaseInfo();
		db.openSession(dbInfo);
		List<Column> columns = db.selectColumns(tableName);
		GenerateCodeUtil util = new GenerateCodeUtil();
		util.generateMapper(tableName, packageName);
		util.generateService(tableName, packageName);
		util.generateServiceImpl(tableName, packageName);
		//util.generateController(tableName, packageName);
		util.generateHtmlToList(tableName, packageName, columns);
		util.generateHtmlToEdit(tableName, packageName, columns);
		util.generateJs(tableName, packageName, columns);
	}

	public ErrorCode execute(DataBaseInfo dbInfo, String tableName,String packageName) throws Exception {
		IDataBase db = DataBaseFactory.create(dbInfo.getType());
		db.openSession(dbInfo);
		List<Column> columns = db.selectColumns(tableName);
		if(columns == null || columns.size() <= 0)
			return ErrorCode.GENERATE_ERROR;
		GenerateCodeUtil generateCodeUtil = new GenerateCodeUtil();
		generateCodeUtil.generateEntity(tableName, packageName, columns);
		generateCodeUtil.generateMapper(tableName, packageName);
		generateCodeUtil.generateService(tableName, packageName);
		generateCodeUtil.generateServiceImpl(tableName, packageName);
		generateCodeUtil.generateController(tableName, packageName,columns);
		generateCodeUtil.generateHtmlToList(tableName, packageName, columns);
		generateCodeUtil.generateHtmlToEdit(tableName, packageName, columns);
		generateCodeUtil.generateJs(tableName, packageName, columns);
		return ErrorCode.GENERATE_SUCCESS;
	}
	
}
