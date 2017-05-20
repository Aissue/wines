package com.wines.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wines.dao.UserDao;
import com.wines.entity.User;
import com.wines.util.MD5Util;
import com.wines.util.SendMailUtil;

public class verifyService extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		String userName = request.getParameter("name");  
		String email = request.getParameter("email"); 
		String password=request.getParameter("flag");
		UserDao userDao = new UserDao();  
		User user = userDao.findUser(email, 0,null);
		if (user == null) {  
			request.setAttribute("note", "NOTFOUND");
			request.setAttribute("detail_1", "HI...");
			request.setAttribute("detail_2", "Sorry,can not find register infomation");
			request.setAttribute("detail_3", "Please register first...");
			request.setAttribute("showback", "register again");
			request.setAttribute("url", "./register.html");
		}  
		else {  
		    String userNameMd5 = MD5Util.encodeToHex(user.getUsername()+"���ͨ��");  
		    if(!(userName.equals(userNameMd5))){  
		    	request.setAttribute("note", "LINKUNAVAIL");
				request.setAttribute("detail_1", "HI,"+user.getUsername());
				request.setAttribute("detail_2", "Sorry,the link out of date");
				request.setAttribute("detail_3", "Please register latter...");
				request.setAttribute("showback", "register again");
				request.setAttribute("url", "./register.html");
		    }  
		    else { 
		    	if(user.getStatus().equals("0")){
		    		request.setAttribute("note", "ACTIVE");
					request.setAttribute("detail_1", "HI,"+user.getUsername());
					request.setAttribute("detail_2", "You can login without verify...");
					request.setAttribute("detail_3", "Say Hi from WINESRORE~");
					request.setAttribute("showback", "login soon");
					request.setAttribute("url", "./login.html");
		    	}else{
		    		user.setStatus("0");
			        boolean done = userDao.modifyUser(user); 
			        if (done) {  
			            StringBuffer content = new StringBuffer("<h2>�˺��Ѿ�������ׯ԰��ӭ����</h2>");  
					    content.append("<p><b>�û�����"+user.getUsername()+"</b></p>")
					    .append("<p><b>���룺"+password+"</b></p>")
					    .append("<p>��¼����޸���Ϣ...</p>")
					    .append("<p>���ׯ԰���ϡ�</p>");  
					    SendMailUtil.send(email, content.toString(),"���ׯ԰����-����ɹ�֪ͨ");//��ʼ�����ʼ�
					    request.setAttribute("note", "SUCCESSFUL");
						request.setAttribute("detail_1", "HI,"+user.getUsername());
						request.setAttribute("detail_2", "Welcome to join us!");
						request.setAttribute("detail_3", "Please get your password to login...");
						request.setAttribute("showback", "login soon");
						request.setAttribute("url", "./login.html");
			        }  
			        else {  
			        	request.setAttribute("note", "LINKUNAVAIL");
						request.setAttribute("detail_1", "HI,"+user.getUsername());
						request.setAttribute("detail_2", "Sorry,the link out of date");
						request.setAttribute("detail_3", "Please register latter...");
						request.setAttribute("showback", "register again");
						request.setAttribute("url", "./register.html");
			        }
		    	}		    	  
		    }  
		}
		request.getRequestDispatcher("allnote.jsp").forward(request, respone);
		
	}
	
}
