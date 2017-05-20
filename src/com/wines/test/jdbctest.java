package com.wines.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wines.util.DBUtil;



public class jdbctest {
	public static String address="jdbc:mysql://localhost:3306/wines";
	public static String username="root";
	public static String userpwd="233503";
	public static void main(String[] args) {
		Connection conn=DBUtil.genConn();
		try {
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery("select * from userinfo");
			while(rs.next()){
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("userPwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn();
		}
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection(address,username,userpwd);
//			Statement state=conn.createStatement();
//			ResultSet rs=state.executeQuery("select * from userinfo");
//			while(rs.next()){
//				System.out.println(rs.getString("username"));
//				System.out.println(rs.getString("userPwd"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
