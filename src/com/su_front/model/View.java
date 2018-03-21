package com.su_front.model;

public class View {
	 private int ID;
	 private String MemberName;
	 private int GoodsID;
	 private String GoodsName;
	 private String GoodsType;
	 private String Url;
	 private String PriceAgo;
	 
	 public String getPriceAgo() {
		return PriceAgo;
	}
	public void setPriceAgo(String priceAgo) {
		PriceAgo = priceAgo;
	}
	private String PriceNow;
	 private String Date;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public int getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(int goodsID) {
		GoodsID = goodsID;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getGoodsType() {
		return GoodsType;
	}
	public void setGoodsType(String goodsType) {
		GoodsType = goodsType;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getPriceNow() {
		return PriceNow;
	}
	public void setPriceNow(String priceNow) {
		PriceNow = priceNow;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	 
	 

}
