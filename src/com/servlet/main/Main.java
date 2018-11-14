package com.servlet.main;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CategoryData;
import com.dao.impl.CategoryDataImpl;
import com.enetity.Category;
import com.enetity.Entry;
import com.services.impl.EntryDataServiceImpl;
import com.util.PageAssistant;

public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntryDataServiceImpl edsi = new EntryDataServiceImpl();
		HttpSession session = req.getSession();
		//获取页面条件
		String key = req.getParameter("key");
		String categoryId = req.getParameter("select");
		//接收页面信息
		String pageSize = req.getParameter("pageSize");
		String currPage = req.getParameter("currPage");
		//创建pa对象
		PageAssistant pa = new PageAssistant();
//		System.out.println(pa.getIdentifier()+pa.getPageSize());
		pa.setCount(edsi.count(key,categoryId,pa.getIdentifier(),pa.getPageSize()));
		if(pageSize!=null&&!"".equals(pageSize)) {
			pa.setPageSize(Integer.parseInt(pageSize));
			System.out.println(Integer.parseInt(pageSize));
		}
		if(currPage!=null&&!"".equals(currPage)) {
			pa.setCurrPage(Integer.parseInt(currPage));
			System.out.println(Integer.parseInt(currPage));
		}
		//判断来自网页页数是否大于总页数
		if(pa.getCurrPage()>pa.getTotalPage()) {
			pa.setCurrPage(1);
		}
		
		//放入会话作用域
		session.setAttribute("pa", pa);
		
		
		List<Entry> list = edsi.query(key,categoryId,pa.getIdentifier(),pa.getPageSize());

		//将查询结果放入
		session.setAttribute("Entry", list);
		
		 /*初始化查询电子文档分类   */
		CategoryData cd = new CategoryDataImpl();
		Category c = new Category();
		List<Category> list2 = cd.query(c);
		//category集合
		session.setAttribute("category", list2);
		//设置关键字和category类编号
		session.setAttribute("key", key);
		session.setAttribute("categoryId", categoryId);
		
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}
