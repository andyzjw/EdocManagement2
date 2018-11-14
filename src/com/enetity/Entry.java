package com.enetity;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Entry implements Serializable{
	/**	文档编号*/
	private Integer id;
	/** 分类编号 */
	private Integer categoryId;
	/** 文档名称 */
	private String title;
	/** 摘要 */
	private String summary;
	/** 上传人 */
	private String uploadUser;
	/** 上传时间 */
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setCreateDate(String createDate) {
		getTime(createDate);
	}
	
	public Entry(Integer id,Integer categoryId) {
		this.id = id;
		this.categoryId = categoryId;
	}
	public Entry(Integer id) {
		this.id = id;
	}
	public Entry(Integer id, Integer categoryId, String title, String summary, String uploadUser, Date createDate) {
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.uploadUser = uploadUser;
		this.createDate = createDate;
	}
	public Entry(Integer id, Integer categoryId, String title, String summary, String uploadUser, String createDate) {
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.uploadUser = uploadUser;
		getTime(createDate);
	}
	public Entry() {
	}
	public Entry(Integer categoryId, String title, String summary, String uploadUser, Date createDate) {
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.uploadUser = uploadUser;
		this.createDate = createDate;
	}
	public Entry(Integer categoryId, String title, String summary, String uploadUser, String createDate) {
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.uploadUser = uploadUser;
		getTime(createDate);
	}
	
	public Entry(String title, String summary, String uploadUser,String createDate) {
		this.title = title;
		this.summary = summary;
		this.uploadUser = uploadUser;
		getTime(createDate);
	}
	
	
	@Override
	public String toString() {
		return "Entry [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", summary=" + summary
				+ ", uploadUser=" + uploadUser + ", createDate=" + createDate + "]";
	}
	private  void getTime(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			this.createDate= new Date(format.parse(time).getTime());
		} catch (ParseException e) {
			this.createDate = new Date(new java.util.Date().getTime());
		}
	}
}
