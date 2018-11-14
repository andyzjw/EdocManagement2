package com.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enetity.Entry;
import com.services.impl.EntryDataServiceImpl;

public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		EntryDataServiceImpl ed = new EntryDataServiceImpl();
		int count=ed.delete(new Entry(Integer.valueOf(id)));
		HttpSession session = req.getSession();
		if(count >0) {
			session.setAttribute("msg", "删除成功！");
			session.setAttribute("clazz", "suc");
		}else {
			session.setAttribute("msg", "删除失败！");
			session.setAttribute("clazz", "fail");
		}
		
		resp.sendRedirect(req.getContextPath());
	}

}
