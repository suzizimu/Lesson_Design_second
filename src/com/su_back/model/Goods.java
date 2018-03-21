package com.su_back.model;

public class Goods {
      private int ID;
      private String Name;
      private int PriceAgo;
      private int PriceNow;
      private String Introduce;
      private String Url;
      private String Date;
      private int Click;
      private String Tel;
      private String MemberName;
      private String GoodsType;
      private String Category;
      
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
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
	public int getPriceAgo() {
		return PriceAgo;
	}
	public void setPriceAgo(int priceAgo) {
		PriceAgo = priceAgo;
	}
	public int getPriceNow() {
		return PriceNow;
	}
	public void setPriceNow(int priceNow) {
		PriceNow = priceNow;
	}
	public String getIntroduce() {
		return Introduce;
	}
	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getClick() {
		return Click;
	}
	public void setClick(int click) {
		Click = click;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getGoodsType() {
		return GoodsType;
	}
	public void setGoodsType(String goodsType) {
		GoodsType = goodsType;
	}
      
      
}
