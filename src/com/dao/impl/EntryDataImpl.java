package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseData;
import com.dao.EntryData;
import com.enetity.Entry;

public class EntryDataImpl extends BaseData<Entry> implements EntryData {
	/**
	 * 添加电子文档
	 */
	public int add(Entry t) {
		//创建Sql语句
		String sql = "INSERT INTO edoc_entry(categoryId,title,"
				+ "summary,uploadUser,createDate) VALUES (?,?,?,?,?)";
		//添加
		count = executeUpdate(sql, t.getCategoryId(),t.getTitle(),t.getSummary(),
				t.getUploadUser(),t.getCreateDate());
		return count;
	}

	/**
	 * 删除电子文档
	 */
	public int delete(Entry t) {
		//Sql语句
		StringBuffer sql = new StringBuffer("DELETE FROM edoc_entry WHERE 1=1 ");
		List<Object> param = new ArrayList<>();
		//删除
		if(t.getId()!=null) {
			sql.append(" and id = ?");
			param.add(t.getId());
		}
		if(t.getCategoryId()!=null) {
			sql.append(" and categoryId = ?");
			param.add(t.getCategoryId());
		}
		if(t.getTitle()!=null && !"".equals(t.getTitle().trim())) {
			sql.append(" and title=?");
			param.add(t.getTitle());
		}
		if(t.getSummary()!=null && !"".equals(t.getSummary().trim())) {
			sql.append(" and summary=?");
			param.add(t.getSummary());
		}
		if(t.getUploadUser()!=null&&!"".equals(t.getUploadUser().trim())) {
			sql.append(" and uploadUser = ?");
			param.add(t.getUploadUser());
		}	
		if(t.getCreateDate() !=null) {
			sql.append(" and createDate = ?");
			param.add(t.getCreateDate());
		}
		count = executeUpdate(sql.toString(),param.toArray());
		return count;
	}
	/**
	 * 修改电子文档
	 */
	public int modify(Entry t) {
		String sql ="UPDATE edoc_entry set categoryId = ?,title = ?,summary = ?,"
				+ "uploadUser=?, createDate = ? WHERE id = ?";
		count = executeUpdate(sql, t.getCategoryId(),t.getTitle(),t.getSummary(),
				t.getUploadUser(),t.getCreateDate(),t.getId());
		return count;
	}
	/** 转换为java对象 */
	public Entry translate() {
		Entry entry = new Entry();
		
		try {
			entry.setId(rs.getInt("id"));
			entry.setCategoryId(rs.getInt("categoryId"));
			entry.setTitle(rs.getString("title"));
			entry.setSummary(rs.getString("summary"));
			entry.setUploadUser(rs.getString("uploadUser"));
			entry.setCreateDate(rs.getDate("createDate"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return entry;
	}
	/**
	 * 电子文档的查询
	 */
	public List<Entry> query(Entry t) {
		StringBuffer sql = new StringBuffer("SELECT * FROM edoc_entry"
				+ " WHERE 1=1");
		List<Object> param = new ArrayList<>();
		if(t.getId()!=null) {
			sql.append(" and id = ?");
			param.add(t.getId());
		}
		if(t.getCategoryId()!=null) {
			sql.append(" and categoryId = ?");
			param.add(t.getCategoryId());
		}
		if(t.getTitle()!=null && !"".equals(t.getTitle().trim())) {
			sql.append(" and title=?");
			param.add(t.getTitle());
		}
		if(t.getSummary()!=null && !"".equals(t.getSummary().trim())) {
			sql.append(" and summary=?");
			param.add(t.getSummary());
		}
		if(t.getUploadUser()!=null&&!"".equals(t.getUploadUser().trim())) {
			sql.append(" and uploadUser = ?");
			param.add(t.getUploadUser());
		}
		if(t.getCreateDate() !=null) {
			sql.append(" and createDate = ?");
			param.add(t.getCreateDate());
		}
		return executeQuery(sql.toString(), param.toArray());
	}

	/*条件查询*/
	public List<Entry> query(Object...param) {
		
		StringBuffer sql = new StringBuffer(" where 1=1");
		List<Object> para = new ArrayList<>();
		//传参数时需要传送倆key参数
		if(param[0] != null && !((String)param[0]).trim().equals("")) {
			sql.append(" and (id like ? or title like  ?)");
			para.add("%"+param[0]+"%");
			para.add("%"+param[0]+"%");
		}
		if(param[1] != null &&!((String)param[1]).trim().equals("")) {
			sql.append(" and categoryId = ?");
			para.add(param[1]);
		}
		
		sql.append(" order by id desc");
		
		sql.append(" limit ?,?");
		para.add(param[2]);
		para.add(param[3]);
		sql.insert(0, "select * from edoc_entry");
		
		return executeQuery(sql.toString(), para.toArray());
	}

	public List<Entry> query(String sql, Object... param) {
		return executeQuery(sql, param);
	}
	/** 计算数据总条数 */
	public int count(Object...param) {
		StringBuffer sql = new StringBuffer("select count(1) from edoc_entry where 1=1");
		List<Object> para = new ArrayList<>();
		//传参数时需要传送倆key参数
		if(param[0] != null && !((String)param[0]).trim().equals("")) {
			sql.append(" and (id like ? or title like  ?)");
			para.add("%"+param[0]+"%");
			para.add("%"+param[0]+"%");
		}
		if(param[1] != null &&!((String)param[1]).trim().equals("")) {
			sql.append(" and categoryId = ?");
			para.add(param[1]);
		}
		
		sql.append(" limit ?,?");
		para.add(param[2]);
		para.add(param[3]);
		System.out.println("进来了ENTRYData");
		getPS(sql.toString(), para.toArray());
		try {
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("计算数据总条数"+count);
		return count;
	}

}
