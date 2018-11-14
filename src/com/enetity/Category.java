package com.enetity;

import java.io.Serializable;

public class Category implements Serializable {
	/** 分类编号 */
	private Integer id;
	/** 分类名称 */
	private String name;
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Category() {
	}
	public Category(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Edoc_category [id=" + id + ", name=" + name + "]";
	}
	
	
}
