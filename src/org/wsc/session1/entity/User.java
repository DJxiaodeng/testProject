package org.wsc.session1.entity;

import java.sql.Date;

/**
 * 
 * @author mrchai
 *
 */
public class User {

	private String role = "office user";
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String officeID;
	private Date birthdate;
	private int active;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String role, String email, String password, String firstName, String lastName, String officeID,
			Date birthdate, int active) {
		super();
		this.role = role;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.officeID = officeID;
		this.birthdate = birthdate;
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOfficeID() {
		return officeID;
	}

	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [role=" + role + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", officeID=" + officeID + ", birthdate=" + birthdate + ", active="
				+ active + "]";
	}
	
	
}
