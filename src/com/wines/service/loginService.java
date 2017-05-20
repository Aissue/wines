package com.wines.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wines.dao.UserDao;
import com.wines.entity.User;
import com.wines.util.MD5Util;

public class loginService extends HttpServlet{
	protected void service(HttpServletRequest reqt, HttpServletResponse resp)
			throws ServletException, IOException {
		reqt.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String useremail=reqt.getParameter("useremail").trim();
		String password=reqt.getParameter("password").trim();
		UserDao ud=new UserDao();
		User user=ud.findUser(useremail, 0,null);
		if(user!=null && 
			MD5Util.encodeToHex(password).toString().equals(user.getUserpwd())){
			user.setLoginflag("0");
			ud.modifyUser(user);
			reqt.setAttribute("user", user);
			reqt.getRequestDispatcher("index.jsp").forward(reqt, resp);
		}else{
			reqt.setAttribute("note", "LOGINFAISE");
			reqt.setAttribute("detail_1", "HI...");
			reqt.setAttribute("detail_2", "Sorry,login false");
			reqt.setAttribute("detail_3", "Please register first or try latter...");
			reqt.setAttribute("showback", "home page");
			reqt.setAttribute("url", "./index.html");
			reqt.getRequestDispatcher("allnote.jsp").forward(reqt, resp);
		}
		

	}
	
}
