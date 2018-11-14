package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dao.BaseData;
import com.dao.UserData;
import com.enetity.User;

public class UserDataImpl extends BaseData<User> implements UserData {
	
	
	@Override
	public User translate() {
		User u = new User();
		try {
			u.setUserName(rs.getString("userName"));
			u.setPwd(rs.getString("pwd"));
			u.setGender(rs.getInt("gender"));
			u.setTime(rs.getDate("createDate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public List<User> query(User u) {
		String sql = "select * from edoc_user where userName = ? and pwd = ?";
		return executeQuery(sql, u.getUserName(),u.getPwd());
	}

}
