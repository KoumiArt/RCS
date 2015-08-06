package com.koumi.framework.product.rcs.restfulapi.bean;

public enum ErrorCode {
	GENERATE_SUCCESS("0000","生成成功！"),GENERATE_ERROR("0001","生成失败！"),GENERATE_EXCEPTION("0002","生成异常！");
	
	private String errorCode;
	private String errorMsg;
	
	private ErrorCode(String errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
}
