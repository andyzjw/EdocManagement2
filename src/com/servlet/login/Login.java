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

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("进入登陆后台");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String name = request.getParameter("userName");
		String password = request.getParameter("pwd");
		//设置cookie
		if(request.getCookies()!=null) {
			Cookie[] coo=request.getCookies();
			
			String  userName="";
			String pwd = "";
			for(int i =0;i<coo.length;i++) {
				System.out.println(coo.length);
				if(coo[i].getName().equals("userName")) {
					userName=URLDecoder.decode(coo[i].getValue());
					System.out.println(userName);
					continue;
				}
				if(coo[i].getName().equals("pwd")) {
					pwd = coo[i].getValue();
					System.out.println(pwd);
					break;
				}
			}
			
			
			session.setAttribute("userName", userName);
			session.setAttribute("pwd", pwd);
		}
		
		
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

}
