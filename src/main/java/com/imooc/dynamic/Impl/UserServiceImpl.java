package com.imooc.dynamic.Impl;

import com.imooc.dynamic.service.UserService;

public class UserServiceImpl implements UserService {

	public void addUser() {
		System.out.println("新增用户");
	}

	public void updateUser() {
		System.out.println("修改用户");
	}

	public void deleteUser() {
		System.out.println("删除用户");
	}

}
