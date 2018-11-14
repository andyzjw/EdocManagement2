package com.services.impl;

import java.util.List;

import com.dao.impl.CategoryDataImpl;
import com.enetity.Category;
import com.services.CategoryDataService;

public class CategoryDataServiceImpl implements CategoryDataService {
	private CategoryDataImpl cd;

	public CategoryDataServiceImpl() {
		cd = new CategoryDataImpl();
	}

	public List<Category> query(Category c) {
		return cd.query(c);
	}

}
