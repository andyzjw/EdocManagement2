package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.ConfigManager;

public abstract class BaseData<T> {
	/** 数据库连接对象 */
	protected Connection conn;
	/** 数据库执行对象 */
	protected PreparedStatement ps;
	/** 受影响的行数 */
	protected int count;
	/** 结果集对象 */
	protected ResultSet rs;
	
	
	/** 将结果集记录转换为 java对象 */
	public abstract T translate();

	
	protected List<T> executeQuery(String sql,Object...param){
		//创建集合
		List<T> list = new ArrayList<T>();
		//获取PS对象
		getPS(sql, param);
		try {
			//执行查询,并接受结果集
			rs = ps.executeQuery();
			//循环遍历结果
			while(rs.next()) {
				//将结果集记录转换为 java对象，并添加到集合中
				list.add(translate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		shutDown();
		System.out.println("查询成功");
		return list;
	}
	
	/**
	 * 执行增删改操作
	 * @param sql
	 * @param param
	 * @return
	 */
	protected int executeUpdate(String sql,Object...param) {
		//获取执行对象
		getPS(sql, param);
		try {
			//执行
			count = ps.executeUpdate();
			System.out.println("执行成功，影响："+count+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 获取PS对象
	 * @param sql
	 * @param param
	 */
	protected void getPS(String sql,Object...param) {
		// 获取连接
		getConnection();
		try {
			//获取对象
			ps = conn.prepareStatement(sql);
			//替换占位符
			for(int i = 0;i<param.length;i++) {
				ps.setObject(i+1, param[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 */
	protected void getConnection() {
		final String DRIVER = ConfigManager.getInstance().getString("driver");
		final String URL = ConfigManager.getInstance().getString("url");
		final String PWD = ConfigManager.getInstance().getString("password");
		final String USERNAME = ConfigManager.getInstance().getString("userName");
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 *关闭资源 
	 */
	protected void shutDown() {
		try {
			if(rs==null) {
				rs.close();
			}
			if(ps==null) {
				ps.close();
			}
			if(conn==null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
