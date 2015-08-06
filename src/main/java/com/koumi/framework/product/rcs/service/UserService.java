package com.koumi.framework.product.rcs.service;

import java.util.List;
import java.util.Map;

import com.koumi.framework.product.rcs.entity.User;
import com.koumi.framework.product.rcs.util.DataGrid;

public interface UserService {

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
	public User queryUserByUserId(int userId);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param user
	 * @return
	 */
	public User queryUser(User user);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param user
	 * @return
	 */
	public User queryUser(Map<String,Object> params);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<User> queryAll();
	
	
	/**
	 * 根据条件查询
	 * @param user
	 * @return
	 */
	public List<User> queryUserByCondition(User user);
	
	/**
	 * 根据条件查询,支持排序等
	 * @param user
	 * @return
	 */
	public List<User> queryUserByCondition(Map<String,Object> params);

	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);
	
	/**
	 * 删除
	 * @param user
	 * @return
	 */
	public boolean deleteUser(User user);
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * 批了删除
	 * @param batchArr
	 * @return
	 */
	public boolean batchDeleteUser(int[] batchArr);
	
}
