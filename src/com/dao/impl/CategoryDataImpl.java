package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseData;
import com.dao.CategoryData;
import com.enetity.Category;

public class CategoryDataImpl extends BaseData<Category> implements CategoryData {
	
	public int add(Category t) {
		String sql = "INSERT INTO edoc_category(`name`) VALUES" + "(?)";
		count = executeUpdate(sql, t.getName());
		return count;
	}

	public int delete(Category t) {
		// Sql语句
		String sql = "DELETE FROM edoc_category WHERE id = ?";
		// 删除
		count = executeUpdate(sql, t.getId());
		return count;
	}

	@Override
	public int modify(Category t) {
		String sql = "UPDATE edoc_category SET	`name` = ?"
				+ " WHERE id=?";
		count = executeUpdate(sql, t.getName(),t.getId());
		return count;
	}

	public Category translate() {
		Category c = new Category();
		try {
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public List<Category> query(Category t) {
		StringBuffer sql = new StringBuffer(" SELECT * FROM edoc_category "
				+ " WHERE 1 = 1");
		List<Object> param = new ArrayList<Object>();
		if(t.getId()!=null) {
			sql.append(" AND id = ?");
			param.add(t.getId());
		}
		if(t.getName() != null && !"".equals(t.getName().trim())) {
			sql.append(" AND name = ?");
			param.add(t.getName());
		}
		return executeQuery(sql.toString(), param.toArray());
	}

	@Override
	public List<Category> query(String sql, Object... param) {
		return query(sql, param);
	}
	

}
