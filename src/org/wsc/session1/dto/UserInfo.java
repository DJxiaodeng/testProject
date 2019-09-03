package org.wsc.session1.dto;

import org.wsc.session1.entity.Office;
import org.wsc.session1.entity.User;

public class UserInfo {

	private User user;
	private Office office;
	private int age;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(User user, Office office, int age) {
		super();
		this.user = user;
		this.office = office;
		this.age = age;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + user.getFirstName() + ", office=" + office.getOfficeName() + ", age=" + age + "]";
	}
	
	
	
}
