package com.wines.entity;

public class userinfo {
	public int    userId=0;      //�û�id
	public String userName=null; //�û����ƣ�����Ϊ�û���������
	public String userPwd=null;  //�û����룬MD5���ܺ��
	public int    logFlag=0;     //��¼��׼��0--��¼��1--δ��¼
	public int 	   status=1;      //��֤��־��0--��֤ͨ����1--δ��֤
	
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
