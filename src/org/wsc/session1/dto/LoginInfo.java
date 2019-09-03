package org.wsc.session1.dto;

public class LoginInfo {

	private String email;
	private String date;
	private String loginTime;
	private String logoutTime;
	private String spent;
	
	public LoginInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginInfo(String email, String date, String loginTime, String logoutTime, String spent) {
		super();
		this.email = email;
		this.date = date;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.spent = spent;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getSpent() {
		return spent;
	}
	public void setSpent(String spent) {
		this.spent = spent;
	}


	@Override
	public String toString() {
		return "LoginInfo [email=" + email + ", date=" + date + ", loginTime=" + loginTime + ", logoutTime="
				+ logoutTime + ", spent=" + spent + "]";
	}
	
	
	
}
