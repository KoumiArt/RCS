package com.koumi.framework.product.rcs.restfulapi.generatecode.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.koumi.framework.product.rcs.core.database.bean.Column;
import com.koumi.framework.product.rcs.restfulapi.generatecode.bean.EasyUIColumn;
import com.koumi.framework.product.rcs.restfulapi.generatecode.bean.GenerateType;
import com.koumi.framework.product.rcs.util.FreemarkUtils;
import com.koumi.framework.product.rcs.util.JacksonUtils;
import com.koumi.framework.product.rcs.util.SpringUtils;
import com.koumi.framework.product.rcs.util.SystemConfigBean;
import com.koumi.framework.product.rcs.util.SystemUtils;

import freemarker.ext.beans.BeansWrapper;

public class GenerateCodeUtil {
	
	private String projectPath = SystemConfigBean.getProperty("projectPath");
	private String templatePath = SystemConfigBean.getProperty("templatePath");

	/**
	 * 生成Entity
	 * @param packageName
	 */
	public void generateEntity(String tableName,String packageName,List<Column> columns){
		packageName = packageName + ".entity";
		Map<String, Object> baseParams = getBaseParams(tableName,packageName);
		baseParams.put("columns", columns);
		baseParams.put("statics", BeansWrapper.getDefaultInstance().getStaticModels());
		generate(tableName,packageName,GenerateType.ENTITY,baseParams);
	}
	
	/**
	 * 生成Mapper
	 * @param packageName
	 */
	public void generateMapper(String tableName,String packageName){
		packageName = packageName + ".mapper";
		generate(tableName,packageName,GenerateType.MAPPER);
	}
	
	/**
	 * 生成Service
	 * @param packageName
	 */
	public void generateService(String tableName,String packageName){
		packageName = packageName + ".service";
		generate(tableName,packageName,GenerateType.SERVICE);
	}
	
	/**
	 * 生成ServiceImpl
	 * @param packageName
	 */
	public void generateServiceImpl(String tableName,String packageName){
		packageName = packageName + ".service.impl";
		generate(tableName, packageName,GenerateType.SERVICEIMPL);
	}
	
	/**
	 * 生成Controller
	 * @param packageName
	 */
	public void generateController(String tableName,String packageName,List<Column> columns){
		packageName = packageName + ".restfulapi";
		Map<String, Object> baseParams = getBaseParams(tableName,packageName);
		baseParams.put("columns", columns);
		baseParams.put("statics", BeansWrapper.getDefaultInstance().getStaticModels());
		generate(tableName, packageName,GenerateType.CONTROLLER,baseParams);
	}
	

	
	/**
	 * 生成List页面
	 * @param packageName
	 * @param columns
	 */
	public void generateHtmlToList(String tableName,String packageName,List<Column> columns){
		Map<String, Object> baseParams = getBaseParams(tableName,packageName);
		baseParams.put("columns", columns);
		generate(tableName, packageName,GenerateType.LIST,baseParams);
	}
	
	/**
	 * 生成Edit页面
	 * @param packageName
	 * @param columns
	 */
	public void generateHtmlToEdit(String tableName,String packageName,List<Column> columns){
		Map<String, Object> baseParams = getBaseParams(tableName,packageName);
		baseParams.put("columns", columns);
		generate(tableName, packageName,GenerateType.EDIT,baseParams);
	}
	
	/**
	 * 生成js
	 * @param packageName
	 * @param columns
	 * @param easyUIColumns
	 * @throws Exception 
	 */
	public void generateJs(String tableName,String packageName,List<Column> columns) throws Exception{
		Map<String, Object> baseParams = getBaseParams(tableName,packageName);
		baseParams.put("columns", columns);
		List<EasyUIColumn> easyUIColumns = this.getEasyUIColumns(columns);
		baseParams.put("easyUIColumns", JacksonUtils.beanToJson(easyUIColumns));
		generate(tableName, packageName,GenerateType.JS,baseParams);
	}
	
	private void generate(String tableName,String packageName,GenerateType generateType){
		generate(tableName, packageName, generateType, getBaseParams(tableName,packageName));
	}
	
	private void generate(String tableName,String packageName,GenerateType generateType,Map<String, Object> params){
		FreemarkUtils freemark = new FreemarkUtils(templatePath,SpringUtils.getServletContext());
		freemark.setTemplateName(generateType.getTemplateName()+".ftl");
		freemark.setFilePath(projectPath+SystemUtils.convertPackageNameToPath(packageName));
		freemark.setFileName(SystemUtils.toCamel(tableName)+generateType.getSuffix()+generateType.getFileType());
		freemark.create(params);
	}
	
	private List<EasyUIColumn> getEasyUIColumns(List<Column> columns) {
		List<EasyUIColumn> easyUIColumns = new ArrayList<EasyUIColumn>();
		for (Column column : columns) {
			EasyUIColumn eColumn = new EasyUIColumn();
			eColumn.setField(column.getColumnName());
			eColumn.setTitle(column.getRemark());
			eColumn.setWidth(200);    
			eColumn.setAlign("center");    
			easyUIColumns.add(eColumn);
		}
		return easyUIColumns;
	}

	private Map<String, Object> getBaseParams(String tableName,String packageName){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("className", SystemUtils.toCamel(tableName));
		params.put("classNameVar", SystemUtils.toSmallCamel(tableName));
		params.put("contextPath",SpringUtils.getServletContextPath());
		params.put("package",packageName);
		return params;
	}
	
}
