package com.annotation.hibernate.request;

public class StudentRequest {
   
	private String name;
	private int mathmarks;
	private int sciencemarks;
	private String street;
	private String doorNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMathmarks() {
		return mathmarks;
	}
	public void setMathmarks(int mathmarks) {
		this.mathmarks = mathmarks;
	}
	public int getSciencemarks() {
		return sciencemarks;
	}
	public void setSciencemarks(int sciencemarks) {
		this.sciencemarks = sciencemarks;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDoorNum() {
		return doorNum;
	}
	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}
	
	
}
