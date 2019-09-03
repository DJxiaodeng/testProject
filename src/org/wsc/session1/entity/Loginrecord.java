package org.wsc.session1.entity;

import java.sql.Timestamp;

public class Loginrecord {

	private String email;
	private Timestamp loginTime;
	private Timestamp logoutTime;
	private String unsuccessfulLoginReason;
	
	public Loginrecord() {
		// TODO Auto-generated constructor stub
	}

	public Loginrecord(String email, Timestamp loginTime, Timestamp logoutTime, String unsuccessfulLoginReason) {
		super();
		this.email = email;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.unsuccessfulLoginReason = unsuccessfulLoginReason;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getUnsuccessfulLoginReason() {
		return unsuccessfulLoginReason;
	}

	public void setUnsuccessfulLoginReason(String unsuccessfulLoginReason) {
		this.unsuccessfulLoginReason = unsuccessfulLoginReason;
	}

	@Override
	public String toString() {
		return "Loginrecord [email=" + email + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime
				+ ", unsuccessfulLoginReason=" + unsuccessfulLoginReason + "]";
	}
	
	
}
