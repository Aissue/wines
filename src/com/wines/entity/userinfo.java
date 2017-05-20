package com.wines.entity;

public class userinfo {
	public int    userId=0;      //用户id
	public String userName=null; //用户名称，可以为用户名和邮箱
	public String userPwd=null;  //用户密码，MD5加密后的
	public int    logFlag=0;     //登录标准，0--登录；1--未登录
	public int 	   status=1;      //验证标志，0--验证通过；1--未验证
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getLogFlag() {
		return logFlag;
	}
	public void setLogFlag(int logFlag) {
		this.logFlag = logFlag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
