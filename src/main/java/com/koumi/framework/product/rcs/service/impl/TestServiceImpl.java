package com.koumi.framework.product.rcs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.koumi.framework.product.rcs.entity.Test;
import com.koumi.framework.product.rcs.mapper.TestMapper;
import com.koumi.framework.product.rcs.service.TestService;
import com.koumi.framework.product.rcs.util.DataGrid;

@Service("testService")
public class TestServiceImpl implements TestService {

	private TestMapper testMapper;

	public void setTestMapper(TestMapper testMapper) {
		this.testMapper = testMapper;
	}

	@Override
	public boolean saveTest(Test test) {
		int result = testMapper.insert(test);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean deleteTest(Test test) {
		int result = testMapper.delete(test);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean updateTest(Test test) {
		int result = testMapper.update(test);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean batchDeleteTest(int[] batchArr) {
		int result = testMapper.batchDelete(batchArr);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public DataGrid queryDataGrid(Map<String, Object> params) {
		DataGrid dataGrid = new DataGrid();
		dataGrid.setTotal(testMapper.selectPageCount(params));
		List<Test> exams = testMapper.selectByPage(params);
		dataGrid.setRows(exams);
		return dataGrid;
	}

	@Override
	public Test queryTestByTestId(int testId) {
		return testMapper.selectByPkId(testId);
	}

	@Override
	public Test queryTest(Test test) {
		return testMapper.selectByObject(test);
	}

	@Override
	public Test queryTest(Map<String, Object> params) {
		return testMapper.selectByObject(params);
	}

	@Override
	public List<Test> queryAll() {
		return testMapper.selectAll();
	}

	@Override
	public List<Test> queryTestByCondition(Test test) {
		return testMapper.selectByCondition(test);
	}

	@Override
	public List<Test> queryTestByCondition(Map<String, Object> params) {
		return testMapper.selectByCondition(params);
	}

}
