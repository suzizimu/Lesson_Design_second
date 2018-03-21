package com.su_back.model;

public class Reply {
     private int ID;
     private String AdminName;
     private String MemberName;
     private String introduce;
     private String Date;
     private int  GoodsID;
     
	public int getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(int goodsID) {
		GoodsID = goodsID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
     
     
}
