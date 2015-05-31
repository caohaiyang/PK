package com.StorageOfGoods.Function;

public class Customer {
	private String name;
	private String phoneNum;
	private double deposit;
	private String remark;
	private double consumption;
	public Customer (String name,String phoneNum,double deposit,double consumption){
		setName(name);
		setPhoneNum(phoneNum);
		setDeposit(deposit);
		setConsumption(consumption);
	}
	public Customer (String name,String phoneNum,double deposit,double consumption,String remark){
		setName(name);
		setPhoneNum(phoneNum);
		setDeposit(deposit);
		setConsumption(consumption);
		setRemark(remark);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
}
