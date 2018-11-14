package com.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.EntryDataImpl;
import com.enetity.Entry;

public class test {
	public static void main(String[] args) {
//		EntryDataServiceImpl ed = new EntryDataServiceImpl();
//		List<Entry> e = ed.query(new Entry());
//		System.out.println(e);
		
		aas(1);
		
	}
	
	public static void aas(Object...param) {
		
		int[] num = new int[3];
		for(int i = 0; i < num.length;i++) {
			if(param[i]!= null) {
				num[i]=(int) param[i];
			}
		}
		for(int i : num) {
			System.out.println(i);
		}
		
	}
}
