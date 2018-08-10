package com.example.model;

public class ToDoList {

	private String tdlNo;
	private String tdlName;
	private String tdlStatus;

	public ToDoList() {

	}

	public ToDoList(String tdlNo, String tdlName, String tdlStatus) {
		this.tdlNo = tdlNo;
		this.tdlName = tdlName;
		this.tdlStatus = tdlStatus;
	}

	public String gettdlNo() {
		return tdlNo;
	}

	public void settdlNo(String tdlNo) {
		this.tdlNo = tdlNo;
	}

	public String gettdlName() {
		return tdlName;
	}

	public void settdlName(String tdlName) {
		this.tdlName = tdlName;
	}

	public String getTdlStatus() {
		return tdlStatus;
	}

	public void setTdlStatus(String tdlStatus) {
		this.tdlStatus = tdlStatus;
	}

}
