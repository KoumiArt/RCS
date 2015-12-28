package com.koumi.framework.product.rcs.restfulapi.generatecode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koumi.framework.product.rcs.core.database.bean.DataBaseInfo;
import com.koumi.framework.product.rcs.restfulapi.bean.ErrorCode;
import com.koumi.framework.product.rcs.service.GenerateCodeService;
import com.koumi.framework.product.rcs.util.SystemUtils;

@RequestMapping("/code")
@Controller
@SuppressWarnings("unchecked")
public class RestGenerateCode {
	
	private GenerateCodeService generateCodeService;
	
	public void setGenerateCodeService(GenerateCodeService generateCodeService) {
		this.generateCodeService = generateCodeService;
	}



	@RequestMapping("/generateCode2")
	@ResponseBody
	public Map<String,Object> generateCode(String dbConfigId,String tableName,String packageName){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			generateCodeService.execute(dbConfigId,tableName, packageName);
			result.put("errorMsg", ErrorCode.GENERATE_SUCCESS.getErrorMsg());
			result.put("errorCode", ErrorCode.GENERATE_SUCCESS.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			result.put("errorCode", ErrorCode.GENERATE_ERROR.getErrorCode());
			result.put("errorMsg", ErrorCode.GENERATE_ERROR.getErrorMsg());
		}
		return result;
	}

	@RequestMapping(value = "/generateCode" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> generateCodeByDbInfo(@RequestBody Map<String,Object> params){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Map<String,Object> dbInfoMap = (Map<String,Object>)params.get("dbInfo");
			DataBaseInfo dbInfo = SystemUtils.mapToObject(dbInfoMap, DataBaseInfo.class);
			String tableName = params.get("tableName").toString();
			String basePackage = params.get("basePackage").toString();
			ErrorCode errorCode = generateCodeService.execute(dbInfo,tableName, basePackage);
			result.put("errorMsg", errorCode.getErrorMsg());
			result.put("errorCode", errorCode.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			result.put("errorCode", ErrorCode.GENERATE_EXCEPTION.getErrorCode());
			result.put("errorMsg", ErrorCode.GENERATE_EXCEPTION.getErrorMsg());
		}
		return result;
	}
}
