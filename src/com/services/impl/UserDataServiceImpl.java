package com.services.impl;

import java.util.List;

import com.dao.impl.UserDataImpl;
import com.enetity.User;
import com.services.UserDataService;

public class UserDataServiceImpl implements UserDataService {
	/* 检验用户账号 */
	public boolean checkUser(User u) {
		UserDataImpl udi = new UserDataImpl();
		List<User> users = udi.query(u);
		if(users.size()==0) {
			return false;
		}
		return true;
	}

}
