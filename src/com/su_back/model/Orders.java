package com.su_back.model;

public class Orders {
    private int ID;
    private String OrderNum;
    private String Date;
    private String GoodsName;
    private String GoodsType;
    private String PriceNow;
    private String MemberName;
    private String Tel;
    private String Adress;
    private String AdressDetail;
    private String Seller;
    private int GoodsID;
    
	public int getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(int goodsID) {
		GoodsID = goodsID;
	}
	public String getSeller() {
		return Seller;
	}
	public void setSeller(String seller) {
		Seller = seller;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(String orderNum) {
		OrderNum = orderNum;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
	public String getPriceNow() {
		return PriceNow;
	}
	public void setPriceNow(String priceNow) {
		PriceNow = priceNow;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getAdressDetail() {
		return AdressDetail;
	}
	public void setAdressDetail(String adressDetail) {
		AdressDetail = adressDetail;
	}
    
    
}
