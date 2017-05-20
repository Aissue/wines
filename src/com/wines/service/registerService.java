package com.wines.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wines.dao.UserDao;
import com.wines.entity.User;
import com.wines.entity.userinfo;
import com.wines.util.MD5Util;
import com.wines.util.SendMailUtil;

public class registerService extends HttpServlet{

	public void service(HttpServletRequest reqt, HttpServletResponse resp)
			throws ServletException, IOException {
		reqt.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user=new User();
		UserDao ud=new UserDao();
		String userName=reqt.getParameter("username");
		String userEmail=reqt.getParameter("email");
		String userPwd=MD5Util.encodeToHex(userName).toString().substring(8, 16);
		String userPhone="";
		String status="1";
		String loginflag="1";
		user.setUsername(userName);
		user.setUseremail(userEmail);
		user.setUserphone(userPhone);
		user.setUserpwd(MD5Util.encodeToHex(userPwd).toString());
		user.setStatus(status);
		user.setLoginflag(loginflag);
	
		if(ud.addUser(user)){
			StringBuffer content = new StringBuffer("<h2>请点击下面的链接激活帐号，链接只能使用一次，请尽快激活！</h2>");  
		    String nameMd5 = MD5Util.encodeToHex(userName+"审核通过");//创建加密字符串  
		    content.append("<a style='font-size:16px;' href='http://localhost:8080/wines/verify.form?")  
		    .append("email=" + userEmail + "&name=" + nameMd5 +"&flag="+userPwd+"'>")  
		    .append("http://localhost:8080/wines/verify.form?")  
		    .append("email=" + userEmail + "&name=" + nameMd5 + "</a><br/><br/>")  
		    .append("<span style='color:blue;font-size:20px;font-weight:bold;'>———红酒庄园在线欢迎您！<span>");  
		    SendMailUtil.send(userEmail, content.toString(),"红酒庄园在线-帐号激活");//开始发送邮件
			reqt.setAttribute("note", "RegSuccessful");
			reqt.setAttribute("detail_1", "HI,"+userName);
			reqt.setAttribute("detail_2", "Welcome to WINESTOR");
			reqt.setAttribute("detail_3", "Through the mail to complete the verification for the login password.");
			reqt.setAttribute("showback", "back to logpage");
			reqt.setAttribute("url", "./login.html");		
		}else{
			reqt.setAttribute("note", "RegFalse:(");
			reqt.setAttribute("detail_1", "HI,"+userName);
			reqt.setAttribute("detail_2", "Sorry,the network is busy");
			reqt.setAttribute("detail_3", "Please try latter...");
			reqt.setAttribute("showback", "register again");
			reqt.setAttribute("url", "./register.html");
		}
		reqt.getRequestDispatcher("allnote.jsp").forward(reqt, resp);
	    		
	}
	
}
