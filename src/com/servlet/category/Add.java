package com.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enetity.Entry;
import com.services.impl.EntryDataServiceImpl;

public class Add extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String uploadUser = request.getParameter("uploadUser");
		String createDate = request.getParameter("createDate");
		String categoryId = request.getParameter("classify");
		EntryDataServiceImpl eds = new EntryDataServiceImpl();
		eds.add(new Entry(Integer.valueOf(categoryId),title,summary,uploadUser,createDate));
		response.sendRedirect("/EdocManagement");
	}
}
