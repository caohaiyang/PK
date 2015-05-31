package com.StorageOfGoods.Function;

public class Login {
	private String userName;
	private String passWord;
	
	public Login(String name,String passWord){
		setUserName(name);
		setPassWord(passWord);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public boolean Check(){
		String userPassWord;
		DataOperating dop = new DataOperating();
		userPassWord = dop.getPassWordByUserName(userName);
		if(userPassWord == null){
			return false;
		}else if(getPassWord().equals(userPassWord)){
			return true;
		}else{
			return false;
		}
	}
}
