package com.cong.service.impl;

import com.cong.dao.IUserDao;
import com.cong.dao.impl.UserDaoImpl;
import com.cong.domain.User;
import com.cong.service.UserService;

public class UserServiceImpl implements UserService{
	
	IUserDao userDao = new UserDaoImpl();
	
	public User findCompanyname(User user) {
		return userDao.findCompanyname(user.getCompanyno(), user.getCompanyname());
	}
}
