package com.StorageOfGoods.Function;

public class ManageBox {
	public void addBox(Box box){
		DataOperating dop = new DataOperating();
		dop.addBox(box);
	}
	public void deleteBox(Box box){
		DataOperating dop = new DataOperating();
		dop.deleteBox(box);
	}
	public void addType(Type type){
		DataOperating dop = new DataOperating();
		dop.addBoxType(type);
	}
	public void deleteType(Type Type){
		DataOperating dop = new DataOperating();
		//dop.deleteType();
	}
}
