package com.koumi.framework.product.rcs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.koumi.framework.product.rcs.entity.User;
import com.koumi.framework.product.rcs.mapper.UserMapper;
import com.koumi.framework.product.rcs.service.UserService;
import com.koumi.framework.product.rcs.util.DataGrid;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public boolean saveUser(User user) {
		int result = userMapper.insert(user);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		int result = userMapper.delete(user);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		int result = userMapper.update(user);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean batchDeleteUser(int[] batchArr) {
		int result = userMapper.batchDelete(batchArr);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public DataGrid queryDataGrid(Map<String, Object> params) {
		DataGrid dataGrid = new DataGrid();
		dataGrid.setTotal(userMapper.selectPageCount(params));
		List<User> exams = userMapper.selectByPage(params);
		dataGrid.setRows(exams);
		return dataGrid;
	}

	@Override
	public User queryUserByUserId(int userId) {
		return userMapper.selectByPkId(userId);
	}

	@Override
	public User queryUser(User user) {
		return userMapper.selectByObject(user);
	}

	@Override
	public User queryUser(Map<String, Object> params) {
		return userMapper.selectByObject(params);
	}

	@Override
	public List<User> queryAll() {
		return userMapper.selectAll();
	}

	@Override
	public List<User> queryUserByCondition(User user) {
		return userMapper.selectByCondition(user);
	}

	@Override
	public List<User> queryUserByCondition(Map<String, Object> params) {
		return userMapper.selectByCondition(params);
	}

}
