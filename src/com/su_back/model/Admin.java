package com.su_back.model;

public class Admin {
	private int ID;
	private String Name;
	private String PassWord;
	private String Sex;
	private String CreatTime;
	private int LoginTimes;
	private String LastTime;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getCreatTime() {
		return CreatTime;
	}
	public void setCreatTime(String creatTime) {
		CreatTime = creatTime;
	}
	public int getLoginTimes() {
		return LoginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		LoginTimes = loginTimes;
	}
	public String getLastTime() {
		return LastTime;
	}
	public void setLastTime(String lastTime) {
		LastTime = lastTime;
	}
	@Override
	public String toString() {
		return "admin [ID=" + ID + ", Name=" + Name + ", PassWord=" + PassWord
				+ ", Sex=" + Sex + ", CreatTime=" + CreatTime
				+ ", LoginTimes=" + LoginTimes + ", LastTime=" + LastTime + "]";
	}
	
	

}
