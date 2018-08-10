package com.example.model;

public class ToDoItem {

	private String tdiNo;
    private String tdiName;
 
    public ToDoItem() {
 
    }
 
    public ToDoItem(String tdiNo, String tdiName) {
        this.tdiNo = tdiNo;
        this.tdiName = tdiName;
    }
 
    public String gettdiNo() {
        return tdiNo;
    }
 
    public void settdiNo(String tdiNo) {
        this.tdiNo = tdiNo;
    }
 
    public String gettdiName() {
        return tdiName;
    }
 
    public void settdiName(String tdiName) {
        this.tdiName = tdiName;
    }
	
}
