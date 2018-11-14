package com.enetity;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private String userName;
	private String pwd;
	private Integer gender;
	private Date time;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User(String userName, String pwd, Integer gender, Date time) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.gender = gender;
		this.time = time;
	}
	public User() {
		super();
	}
	public User(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}
	
	
	
}
