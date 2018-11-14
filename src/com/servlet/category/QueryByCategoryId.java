package com.servlet.category;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enetity.Entry;
import com.services.EntryDataService;
import com.services.impl.EntryDataServiceImpl;
import com.util.PageAssistant;
/**
 * 根据分类ID进行查询
 * @author andy
 *
 */
public class QueryByCategoryId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		EntryDataServiceImpl edsi = new EntryDataServiceImpl();
		
		String categoryId = request.getParameter("categoryId");
		Integer id =Integer.valueOf(categoryId);
		System.out.println("分类ID"+id);
		EntryDataService ed = new EntryDataServiceImpl();
		List<Entry> list = null;
		if(id==0) {
			String pageSize = request.getParameter("pageSize");
			String currPage = request.getParameter("currPage");
			//创建pa对象
			PageAssistant pa = new PageAssistant();
			pa.setCount(edsi.count());
			if(pageSize!=null&&!"".equals(pageSize)) {
				pa.setPageSize(Integer.parseInt(pageSize));
				System.out.println(Integer.parseInt(pageSize));
			}
			if(currPage!=null&&!"".equals(currPage)) {
				pa.setCurrPage(Integer.parseInt(currPage));
				System.out.println(Integer.parseInt(currPage));
			}
			//放入会话作用域
			session.setAttribute("pa", pa);
			list = edsi.query(pa.getIdentifier(),pa.getPageSize());
			
		}else {
		 list = ed.query(new Entry(null,id));
		}
		Collections.reverse(list);
		
		session.setAttribute("Entry", list);
		session.setAttribute("categoryId", categoryId);
		response.sendRedirect("main.jsp");
	}

}
