package com.wines.entity;

public class User {
	public long  userid=0L;
	public String username=null;
	public String userpwd=null;
	public String userphone=null;
	public String useremail=null;
	public String status="1";
	public String loginflag="1";
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoginflag() {
		return loginflag;
	}
	public void setLoginflag(String loginflag) {
		this.loginflag = loginflag;
	}
	
	
	

}
