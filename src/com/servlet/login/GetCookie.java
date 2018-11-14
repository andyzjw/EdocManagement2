package com.servlet.login;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enetity.User;
import com.services.impl.UserDataServiceImpl;
import com.sun.xml.internal.fastinfoset.Decoder;

public class GetCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String name = request.getParameter("userName");
		String password = request.getParameter("pwd");
		
		
		if(name !=null && !"".equals(name.trim())&&password!=null&&!"".equals(password.trim())) {
			Cookie coo = new Cookie("userName", URLEncoder.encode(name));
			Cookie coo1 = new Cookie("pwd", password);
			response.addCookie(coo);
			response.addCookie(coo1);
		}
		
		
		User u = new User(name, password);
		
		UserDataServiceImpl uds = new UserDataServiceImpl();
		if(uds.checkUser(u)) {
			session.setAttribute("user", u);
			response.sendRedirect(request.getContextPath()+"/pages/frame/main.jsp");
		}else {
			session.setAttribute("loginMsg", "账号密码错误");
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
	}
	
}
