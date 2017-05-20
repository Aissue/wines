package com.wines.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	private static String url=null;
	private static String username=null;
	private static String password=null;
	private static String dirver=null;
	private static Connection conn=null;
	static{
//		Properties pro=new Properties();
//		try {
//			InputStream is=DBUtil.class.getResourceAsStream("/dbconfig.properties");
//			pro.load(is);
//			url=pro.getProperty("url");
//			username=pro.getProperty("username");
//			password=pro.getProperty("password");
//			dirver=pro.getProperty("dirver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		genConn();
	}
	
	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		DBUtil.url = url;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DBUtil.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBUtil.password = password;
	}

	public static String getDirver() {
		return dirver;
	}

	public static void setDirver(String dirver) {
		DBUtil.dirver = dirver;
	}

	public static Connection genConn(){
		if(conn==null){
			try {
				Class.forName(dirver);
				conn=DriverManager.getConnection(url,username,password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return conn;
	}
	
	public static void closeConn(){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
