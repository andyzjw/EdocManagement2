 package com.servlet.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enetity.Entry;
import com.services.impl.EntryDataServiceImpl;

public class GetCurrentData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		EntryDataServiceImpl ed = new EntryDataServiceImpl();
		List<Entry> list = ed.query(new Entry(Integer.valueOf(req.getParameter("id"))));
		HttpSession session = req.getSession();
		System.out.println(list.get(0).getTitle());
		session.setAttribute("edoc", list.get(0));
		req.getRequestDispatcher("pages/modify.jsp").forward(req, resp);
	}

}
