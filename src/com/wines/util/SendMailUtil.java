package com.wines.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtil {
	public static final String HOST = "smtp.163.com";  
    public static final String PROTOCOL = "smtp";  
    public static final int PORT = 25;  
    public static final String SENDER = "sendadm@163.com";//�˴���Ҫ��host��ͬ����վ  
    public static final String SENDERPWD = "aissue1314";  
      
    /** 
     * ��ȡ���ڷ����ʼ���Session 
     * @return 
     */  
    public static Session getSession() {  
        Properties props = new Properties();  
        props.put("mail.smtp.host", HOST);//���÷�������ַ  
        props.put("mail.store.protocol" , PROTOCOL);//����Э��  
        props.put("mail.smtp.port", PORT);//���ö˿�  
        props.put("mail.smtp.auth" , true);  
          
        Authenticator authenticator = new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(SENDER, SENDERPWD);  
            }  
        };  
        Session session = Session.getDefaultInstance(props,authenticator);  
        return session;  
    }  
      
    /** 
     * �����ʼ� 
     * @param receiver 
     * @param content 
     */  
    public static void send(String receiver, String content,String subject) {  
        Session session = getSession();  
        try {  
            System.out.println("-------��ʼ����-------");  
            Message msg = new MimeMessage(session);  
            //����message����  
            msg.setFrom(new InternetAddress(SENDER));  
            InternetAddress[] addrs = {new InternetAddress(receiver)};  
            msg.setRecipients(Message.RecipientType.TO, addrs);  
            msg.setSubject(subject);  
            msg.setSentDate(new Date());  
            msg.setContent(content,"text/html;charset=utf-8");  
            //��ʼ����  
            Transport.send(msg);  
                        System.out.println("-------�������-------");  
        } catch (AddressException e) {  
            e.printStackTrace();  
        } catch (MessagingException e) {  
            e.printStackTrace();  
        }  
    }  

}
