package com.koumi.framework.product.rcs.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koumi.framework.product.rcs.entity.Test;

/**
 * @author koumi
 *
 */
@Repository
public interface TestMapper extends BaseMapper {
	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<Test> selectByPage(Map<String,Object> params);
	
	/**
	 * 分页查询的count
	 * @param params
	 * @return
	 */
	public int selectPageCount(Map<String,Object> params);
	
	/**
	 * 根据主键查询
	 * @param pkId
	 * @return
	 */
	public Test selectByPkId(int pkId);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param test
	 * @return
	 */
	public Test selectByObject(Test test);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param params
	 * @return
	 */
	public Test selectByObject(Map<String,Object> params);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Test> selectAll();
	
	
	/**
	 * 根据条件查询
	 * @param test
	 * @return
	 */
	public List<Test> selectByCondition(Test test);
	
	/**
	 * 根据条件查询,支持排序等
	 * @param params
	 * @return
	 */
	public List<Test> selectByCondition(Map<String,Object> params);
}
