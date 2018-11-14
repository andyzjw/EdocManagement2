package com;

import com.enetity.Entry;
import com.services.impl.EntryDataServiceImpl;

public class test {
	public static void main(String[] args) {
		add();
	}
	
	private static void add() {
		EntryDataServiceImpl eds = new EntryDataServiceImpl();
		Entry e = new Entry();
		for(int i = 0;i <50;i++) {
			int categoryId =  (int) (Math.random()*4)+1;
			String title = getTitle();
			String uploadUser = getname();
			String time = "200"+(int)(Math.random()*9)+'-'+((int)(Math.random()*12)+1)
					+'-'+((int)(Math.random()*28)+1);
			e.setTitle(title);
			e.setUploadUser(uploadUser);
			e.setCreateDate(time);
			e.setCategoryId(categoryId);
			eds.add(e);
		}
	}
	
	private static String getTitle() {
		int n = (int) (Math.random()*3)+6;
		StringBuffer sb = new StringBuffer();
		for(int i =0;i < n;i++) {
			char title = (char) ((int)(Math.random()*26)+97);
			sb.append(title);
		}
		return sb.toString();
	}
	private static String getname() {
		int n = (int) (Math.random()*3)+4;
		StringBuffer sb = new StringBuffer();
		for(int i =0;i < n;i++) {
			char title = (char) ((int)(Math.random()*26)+97);
			sb.append(title);
		}
		return sb.toString();
	}
	
	
	
}
