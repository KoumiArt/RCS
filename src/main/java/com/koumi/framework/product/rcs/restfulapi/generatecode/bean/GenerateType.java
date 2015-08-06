package com.koumi.framework.product.rcs.restfulapi.generatecode.bean;

public enum GenerateType {
	ENTITY("Entity", ".java" , ""),
	CONTROLLER("Controller", ".java","Controller"), 
	SERVICE("Service", ".java","Service"), 
	SERVICEIMPL("ServiceImpl", ".java","ServiceImpl"),
	MAPPER("Mapper", ".java","Mapper"),
	JS("JS", ".js","List"), 
	LIST("List", ".html","List"), 
	EDIT("Edit", ".html","Edit");

	private GenerateType(String templateName, String fileType,String suffix) {
		this.templateName = templateName;
		this.fileType = fileType;
		this.suffix = suffix;
	}

	private String templateName;

	private String fileType;
	
	private String suffix;
	
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
