package com.wines.test;

import com.wines.util.MD5Util;
import com.wines.util.SendMailUtil;

public class emiltest {

	public static void main(String[] args) {
		String email = "1209042946@qq.com";  
	    StringBuffer content = new StringBuffer("<h2>������������Ӽ����ʺţ�����ֻ��ʹ��һ�Σ��뾡�켤�</h2>");  
	    String nameMd5 = MD5Util.encodeToHex("123"+"���ͨ��");//���������ַ���  
	    content.append("<a style='font-size:16px;' href='http://localhost:8080/czfc/register.reg?doType=activate&")  
	    .append("email=" + email + "&name=" + nameMd5 +"'>")  
	    .append("http://localhost:8080/czfc/register.reg?doType=activate&")  
	    .append("email=" + email + "&name=" + nameMd5 + "</a><br/><br/>")  
	    .append("<span style='color:blue;font-size:20px;font-weight:bold;'>�������㽭��ɽ��ӭ����<span>");  
	    SendMailUtil.send(email, content.toString(),"");//��ʼ�����ʼ�

	}

}
