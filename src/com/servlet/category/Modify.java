package com.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enetity.Entry;
import com.services.impl.EntryDataServiceImpl;

public class Modify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("123");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String uploadUser = request.getParameter("uploadUser");
		String createDate = request.getParameter("createDate");
		String categoryId = request.getParameter("categoryId");
		String id = request.getParameter("id");
		EntryDataServiceImpl eds = new EntryDataServiceImpl();
		eds.modify(new Entry(Integer.valueOf(id),Integer.valueOf(categoryId),title,summary,uploadUser,createDate));
		response.sendRedirect("/EdocManagement");
	}
 
}
