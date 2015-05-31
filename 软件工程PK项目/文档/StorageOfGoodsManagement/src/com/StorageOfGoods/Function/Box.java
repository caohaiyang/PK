package com.StorageOfGoods.Function;

public class Box {
	private int boxNum;
	private String type;
	private String phoneNum;
	
	public Box(int boxNum,String type){
		setBoxNum(boxNum);
		setType(type);
	}
	public Box(int boxNum,String type,String phoneNum){
		setBoxNum(boxNum);
		setType(type);
		setPhoneNum(phoneNum);
	}
	
	
	public int getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(int boxNum) {
		this.boxNum = boxNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
