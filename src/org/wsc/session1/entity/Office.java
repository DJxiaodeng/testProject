package org.wsc.session1.entity;

public class Office {

	private String officeID;
	private String officeName;
	
	public Office() {
		// TODO Auto-generated constructor stub
	}

	public Office(String officeID, String officeName) {
		super();
		this.officeID = officeID;
		this.officeName = officeName;
	}

	public String getOfficeID() {
		return officeID;
	}

	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@Override
	public String toString() {
		return "Office [officeID=" + officeID + ", officeName=" + officeName + "]";
	}
	
	 
}
