package com.wines.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wines.dao.UserDao;
import com.wines.entity.User;

public class checkService extends HttpServlet{
	public UserDao ud=new UserDao();
	
	protected void service(HttpServletRequest reqt, HttpServletResponse resp)
			throws ServletException, IOException {
		reqt.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String pr_url=reqt.getRequestURI();
		String url=pr_url.substring(pr_url.lastIndexOf("/"),pr_url.lastIndexOf("."));
		System.out.println(url);
		if(url.equals("/check_username")){
			String result=check_username(reqt.getParameter("userName"));
			System.out.println(result);
			out.print(result);
			out.flush();
		}else if(url.equals("/check_email")){
			String result=check_email(reqt.getParameter("email"));
			out.print(result);
		}
	}
	public String check_username(String username){
		System.out.println(username);
		User user=ud.findUser(null, 0, username);
		String s=user.getUseremail();
		if(s==null){
			return "用户名可用";
		}else{
			return "用户名不可用";
		}
	}
	public String check_email(String email){
		String format = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		String result=null;
		User user=ud.findUser(email, 0, null);
		String useremail=user.getUseremail();
		System.out.println(email+"|"+email.matches(format));
		if(email.matches(format) && useremail==null){
			result="邮箱可用";
		}else{
			result="邮箱不可用";
		}
		return result;
	}
	

}
