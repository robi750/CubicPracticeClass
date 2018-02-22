package com.cubic.inv_services1;

public class CustomerData {

	private String fName;
	private String lName;
	private String phoneNumber;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerData [fName=" + fName + ", lName=" + lName + ", phoneNumber=" + phoneNumber + "]";
	}

}
