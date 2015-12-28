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

import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;

public class GenerateCodeUtil {
	
	private String javaFilePath = SystemConfigBean.getProperty("javaFilePath");
	private String appFilePath = SystemConfigBean.getProperty("appPath");
	private String templatePath = SystemConfigBean.getProperty("templatePath");

	/**
	 * 生成Entity
	 * @param basePackage
	 */
	public void generateEntity(String tableName,String basePackage,List<Column> columns){
		Map<String, Object> baseParams = getBaseParams(tableName,basePackage);
		baseParams.put("columns", columns);
		baseParams.put("statics", new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build().getStaticModels());
		generate(tableName,basePackage,GenerateType.ENTITY,baseParams);
	}
	
	/**
	 * 生成Mapper
	 * @param basePackage
	 */
	public void generateMapper(String tableName,String basePackage){
		generate(tableName,basePackage,GenerateType.MAPPER);
	}
	
	/**
	 * 生成Service
	 * @param basePackage
	 */
	public void generateService(String tableName,String basePackage){
		generate(tableName,basePackage,GenerateType.SERVICE);
	}
	
	/**
	 * 生成ServiceImpl
	 * @param basePackage
	 */
	public void generateServiceImpl(String tableName,String basePackage){
		generate(tableName, basePackage,GenerateType.SERVICEIMPL);
	}
	
	/**
	 * 生成Controller
	 * @param basePackage
	 */
	public void generateController(String tableName,String basePackage,List<Column> columns){
		Map<String, Object> baseParams = getBaseParams(tableName,basePackage);
		baseParams.put("columns", columns);
		baseParams.put("statics", new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build().getStaticModels());
		generate(tableName, basePackage,GenerateType.CONTROLLER,baseParams);
	}
	

	
	/**
	 * 生成List页面
	 * @param basePackage
	 * @param columns
	 */
	public void generateHtmlToList(String tableName,String basePackage,List<Column> columns){
		Map<String, Object> baseParams = getBaseParams(tableName,basePackage);
		baseParams.put("columns", columns);
		generate(tableName, basePackage,GenerateType.LIST,baseParams);
	}
	
	/**
	 * 生成Edit页面
	 * @param basePackage
	 * @param columns
	 */
	public void generateHtmlToEdit(String tableName,String basePackage,List<Column> columns){
		Map<String, Object> baseParams = getBaseParams(tableName,basePackage);
		baseParams.put("columns", columns);
		generate(tableName, basePackage,GenerateType.EDIT,baseParams);
	}
	
	/**
	 * 生成js
	 * @param basePackage
	 * @param columns
	 * @param easyUIColumns
	 * @throws Exception 
	 */
	public void generateJs(String tableName,String basePackage,List<Column> columns) throws Exception{
		Map<String, Object> baseParams = getBaseParams(tableName,basePackage);
		baseParams.put("columns", columns);
		List<EasyUIColumn> easyUIColumns = this.getEasyUIColumns(columns);
		baseParams.put("easyUIColumns", JacksonUtils.toJson(easyUIColumns));
		generate(tableName, basePackage,GenerateType.JS,baseParams);
	}
	
	private void generate(String tableName,String basePackage,GenerateType generateType){
		generate(tableName, basePackage, generateType, getBaseParams(tableName,basePackage));
	}
	
	private void generate(String tableName,String basePackage,GenerateType generateType,Map<String, Object> params){
		FreemarkUtils freemark = new FreemarkUtils(templatePath,SpringUtils.getServletContext());
		freemark.setTemplateName(generateType.getTemplateName()+".ftl");
		String packageName = basePackage + generateType.getPackageName();
		String projectPath = null;
		if(generateType.getFileType().equals(".js"))
			projectPath = appFilePath + SystemUtils.toSmallCamel(tableName) + "/js";
		else if(generateType.getFileType().equals(".html"))
			projectPath = appFilePath + SystemUtils.toSmallCamel(tableName) + "/html";
		else 
			projectPath = javaFilePath + SystemUtils.convertPackageNameToPath(packageName);
		freemark.setFilePath(projectPath);
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

	private Map<String, Object> getBaseParams(String tableName,String basePackage){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("className", SystemUtils.toCamel(tableName));
		params.put("classNameVar", SystemUtils.toSmallCamel(tableName));
		params.put("contextPath",SpringUtils.getServletContextPath());
		params.put("basePackage",basePackage);
		return params;
	}
	
}
