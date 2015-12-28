package com.koumi.framework.product.rcs.restfulapi.generatecode.bean;

public enum GenerateType {
	ENTITY("Entity", ".java" , "",".entity"),
	CONTROLLER("Controller", ".java","Controller",".restful.api"), 
	SERVICE("Service", ".java","Service",".service"), 
	SERVICEIMPL("ServiceImpl", ".java","ServiceImpl",".service.impl"),
	MAPPER("Mapper", ".java","Mapper",".mapper"),
	JS("Js", ".js","List",""), 
	LIST("List", ".html","List",""), 
	EDIT("Edit", ".html","Edit","");
	
	private GenerateType(String templateName, String fileType,String suffix,String packageName) {
		this.templateName = templateName;
		this.fileType = fileType;
		this.suffix = suffix;
		this.packageName = packageName;
	}

	private String templateName;

	private String fileType;
	
	private String suffix;
	
	private String packageName;
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getFileType() {
		return fileType;
	}

	public String getTemplateName() {
		return templateName;
	}
}
