package com.su_front.dao;

import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.util.DBUtil;

public class car_dao {
	/**
	 * 添加到购物车
	 * @param id
	 * @param name
	 */
	public void add_car(int id,String name){
		String sql="select * from goods where id=?";
		Map<String, Object> map=DBUtil.query(sql,id);
		if(map!=null&&map.size()!=0){
			Goods goods=new Goods();
			
			goods.setGoodsType((String) map.get("GoodsType"));
			goods.setID((int) map.get("ID"));
			goods.setName((String) map.get("Name"));
			goods.setPriceNow((int) map.get("PriceNow"));
			goods.setUrl((String) map.get("Url"));
			goods.setPriceAgo((int) map.get("PriceAgo"));
			
			String sql2="insert into car (GoodsID,GoodsName,GoodsType,PriceAgo,PriceNow,Url,Buyer)values(?,?,?,?,?,?,?)";
			DBUtil.executeUpdate(sql2,new Object[]{goods.getID(),goods.getName(),goods.getGoodsType(),goods.getPriceAgo(),goods.getPriceNow(),goods.getUrl(),name});
			
		}
	}
	/**
	 * 删除购物车
	 * @param id
	 */
	public void delete_car(int id){
		String sql="delete from car where id=?";
		DBUtil.executeUpdate(sql, id);		
	}
	
	

}
