package com.wines.test;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wines.entity.MyUser;
import com.wines.util.DBUtil;


public class springTest1 {
	
	//@Test
	public  void hellospring() {
		String cfg="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(cfg);
		Calendar cl=(Calendar)ac.getBean("greobj");
		Calendar c2=ac.getBean("greobj",Calendar.class);
		System.out.println(cl);
		System.out.println(c2);
	}
	
	//@Test
	public void hellosping2(){
		String cfg="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(cfg);
		MyUser myuser=ac.getBean("myuser", MyUser.class);
	}
	//@Test
	public void collectT(){
		String cfg="applicationContext2.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(cfg);
		collectionSpringTest ct=ac.getBean("wagaga",collectionSpringTest.class);
		System.out.println(ct.getCities());
		System.out.println(ct.getNames());
		System.out.println(ct.getGreads());
		
	}
	@Test
	public void myDButil(){
		String cfg="applicationContext2.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(cfg);
		DBUtil db=ac.getBean("myDBUtil",DBUtil.class);
		System.out.println(db.getDirver());
		System.out.println(db.getPassword());
		System.out.println(db.getUrl());
		System.out.println(db.getUsername());
		db.genConn();
		
		
	}
}
