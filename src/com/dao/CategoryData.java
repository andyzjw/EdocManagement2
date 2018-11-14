package com.dao;

import java.util.List;

import com.enetity.Category;


public interface CategoryData {
	/** 增加数据 */
	public abstract int add(Category c);
	/** 删除数据 */
	public abstract int delete(Category c);
	/** 修改数据 */
	public abstract int modify(Category c);
	/**  查询数据 */
	public abstract List<Category> query(Category c);
	public abstract List<Category> query(String sql,Object...param);
}
