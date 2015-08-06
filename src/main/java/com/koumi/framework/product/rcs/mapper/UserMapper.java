package com.koumi.framework.product.rcs.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koumi.framework.product.rcs.entity.User;

/**
 * @author koumi
 *
 */
@Repository
public interface UserMapper extends BaseMapper {
	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<User> selectByPage(Map<String,Object> params);
	
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
	public User selectByPkId(int pkId);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param user
	 * @return
	 */
	public User selectByObject(User user);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param user
	 * @return
	 */
	public User selectByObject(Map<String,Object> params);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<User> selectAll();
	
	
	/**
	 * 根据条件查询
	 * @param user
	 * @return
	 */
	public List<User> selectByCondition(User user);
	
	/**
	 * 根据条件查询,支持排序等
	 * @param user
	 * @return
	 */
	public List<User> selectByCondition(Map<String,Object> params);
}
