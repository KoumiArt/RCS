package com.koumi.framework.product.rcs.restfulapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koumi.framework.product.rcs.entity.Test;
import com.koumi.framework.product.rcs.service.TestService;
import com.koumi.framework.product.rcs.util.DataGrid;


@Controller
public class TestController {
	
	private TestService testService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@RequestMapping("/testList")
	@ResponseBody
	public DataGrid getTestList(int page, int rows,Test test){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", ((page-1)*rows)+1);
		map.put("end", page*rows);
		map.put("test", test);
		return testService.queryDataGrid(map);
	}
	
	@RequestMapping("/saveTest")
	@ResponseBody
	public boolean saveTest(Test test){
		boolean result = false;
		if(test.getId() >0){
			result = testService.updateTest(test);
		} else {
			result = testService.saveTest(test);
		}
		return result;
	}

	@RequestMapping("/getTest")
	@ResponseBody
	public Test getTest(int testId){
		return testService.queryTestByTestId(testId);
	}
	
	@RequestMapping("/deleteTest")
	@ResponseBody
	public boolean deleteTest(Test test){
		return testService.deleteTest(test);
	}
	
	@RequestMapping("/batchDeleteTest")
	@ResponseBody
	public boolean batchDeleteTest(int[] testArr){
		return testService.batchDeleteTest(testArr);
	}
}