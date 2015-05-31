package com.StorageOfGoods.Function;

public class RentBox {
	private Customer cust;
	private int boxNum;
	
	public RentBox(Customer cust,int boxNum){
		setCust(cust);
		setBox(boxNum);
	}
	public void rentBox(){
		DataOperating dop = new DataOperating();
		dop.AddCustToBox(boxNum, cust);
		if(check()){
		    dop.addCustomer(cust);
		}
	}
	public boolean check(){
		DataOperating dop = new DataOperating();
		if(dop.getCustomerByBoxNum(boxNum) == null){
			return true;
		}
		return false;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public int getBoxNum() {
		return boxNum;
	}
	public void setBox(int boxNum) {
		this.boxNum = boxNum;
	}
}
