package com.wines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wines.entity.User;
import com.wines.entity.userinfo;
import com.wines.util.DBUtil;

public class UserDao {
	public Connection conn=DBUtil.genConn();
	PreparedStatement pre=null;
	public User findUser(String useremail,long id,String username){
		User user=new User();
		try {
			if(useremail!=null){
				pre=conn.prepareStatement("select * from user where useremail=?");
				pre.setString(1,useremail);
			}else if(id!=0){
				pre=conn.prepareStatement("select * from user where id=?");
				pre.setLong(1, id);
			}else if(username!=null){
				pre=conn.prepareStatement("select * from user where username=?");
				pre.setString(1, username);
			}
			ResultSet rs=pre.executeQuery();
			int i=0;
			while(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setUserpwd(rs.getString("userpwd"));
				user.setLoginflag(rs.getString("loginflag"));
				user.setStatus(rs.getString("status"));
				user.setUserid(rs.getLong("id"));
				user.setUserphone(rs.getString("userphone"));
				user.setUseremail(rs.getString("useremail"));
				i++;
			}
			//System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean deleteUser(long userid){
		try {
			pre=conn.prepareStatement("delete from user where id=?");
			pre.setLong(1, userid);
			pre.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addUser(User user){
		try {
			pre=conn.prepareStatement("insert into user(username,userpwd,userphone,useremail,status,loginflag) values(?,?,?,?,?,?)");
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getUserpwd());
			pre.setString(3, user.getUserphone());
			pre.setString(4, user.getUseremail());
			pre.setString(5, user.getStatus());
			pre.setString(6, user.getLoginflag());
			pre.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean modifyUser(User user){
		try {
			pre=conn.prepareStatement("update user set username=?,userpwd=?,userphone=?,useremail=?,status=?,loginflag=? where id=?");
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getUserpwd());
			pre.setString(3, user.getUserphone());
			pre.setString(4, user.getUseremail());
			pre.setString(5, user.getStatus());
			pre.setString(6, user.getLoginflag());
			pre.setLong(7, user.getUserid());
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
