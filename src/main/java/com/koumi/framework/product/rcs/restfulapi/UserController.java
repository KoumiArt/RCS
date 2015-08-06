package com.koumi.framework.product.rcs.restfulapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koumi.framework.product.rcs.entity.User;
import com.koumi.framework.product.rcs.service.UserService;
import com.koumi.framework.product.rcs.util.DataGrid;


@Controller
public class UserController {
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/userList")
	@ResponseBody
	public DataGrid getUserList(int page, int rows,User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", ((page-1)*rows)+1);
		map.put("end", page*rows);
		map.put("user", user);
		return userService.queryDataGrid(map);
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public boolean addUser(User user){
		boolean result = false;
		if(user.getUserId() >0){
			result = userService.updateUser(user);
		} else {
			result = userService.saveUser(user);
		}
		return result;
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(int userId){
		return userService.queryUserByUserId(userId);
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public boolean deleteUser(User user){
		return userService.deleteUser(user);
	}
	
	@RequestMapping("/batchDeleteUser")
	@ResponseBody
	public boolean batchDeleteUser(int[] userArr){
		return userService.batchDeleteUser(userArr);
	}
}
