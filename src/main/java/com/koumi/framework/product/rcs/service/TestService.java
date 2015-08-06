package com.koumi.framework.product.rcs.service;

import java.util.List;
import java.util.Map;

import com.koumi.framework.product.rcs.entity.Test;
import com.koumi.framework.product.rcs.util.DataGrid;

public interface TestService {

	/**
	 * 获取jquery easyui DataGrid数据
	 * @param params
	 * @return
	 */
	public DataGrid queryDataGrid(Map<String, Object> params);
	
	/**
	 * 根据主键查询
	 * @param pkId
	 * @return
	 */
	public Test queryTestByTestId(int testId);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param test
	 * @return
	 */
	public Test queryTest(Test test);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param test
	 * @return
	 */
	public Test queryTest(Map<String,Object> params);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Test> queryAll();
	
	
	/**
	 * 根据条件查询
	 * @param test
	 * @return
	 */
	public List<Test> queryTestByCondition(Test test);
	
	/**
	 * 根据条件查询,支持排序等
	 * @param test
	 * @return
	 */
	public List<Test> queryTestByCondition(Map<String,Object> params);

	/**
	 * 添加
	 * @param test
	 * @return
	 */
	public boolean saveTest(Test test);
	
	/**
	 * 删除
	 * @param test
	 * @return
	 */
	public boolean deleteTest(Test test);
	
	/**
	 * 修改
	 * @param test
	 * @return
	 */
	public boolean updateTest(Test test);
	
	/**
	 * 批了删除
	 * @param batchArr
	 * @return
	 */
	public boolean batchDeleteTest(int[] batchArr);
	
}
