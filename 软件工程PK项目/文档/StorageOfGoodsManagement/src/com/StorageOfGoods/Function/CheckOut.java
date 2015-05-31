package com.StorageOfGoods.Function;

import java.util.Vector;

public class CheckOut {
	private int boxNum;
	private String custName;
	private double deposit;
	
	public void checkOut(int num){
		setBoxNum(num);
		DataOperating dop = new DataOperating();
		Customer cust = null;
		cust = dop.getCustomerByBoxNum(num);
		setCustName(cust.getName());
		setDeposit(cust.getDeposit());
		dop.CleanBox(num);
		dop.deleteCustomer(cust);
	}

	public int getBoxNum() {
		return boxNum;
	}

	public void setBoxNum(int boxNum) {
		this.boxNum = boxNum;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
}
