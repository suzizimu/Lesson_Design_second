package com.su_front.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.model.Member;
import com.su_back.model.Orders;
import com.su_back.util.DBUtil;

public class orders_dao {
	 Date  date=new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
		
	/**
	 * 前台
	 * 卖出遍历
	 * @param name
	 * @return
	 */
	public List<Orders> list_orders2(String name){
		String sql="select * from orders where seller=?";
		List<Map<String, Object>> list=DBUtil.list(sql,name);
		
		if(list!=null&&list.size()!=0){
			List<Orders> listorders=new ArrayList<Orders>();
			for(Map<String, Object> map:list){
				Orders orders=new Orders();
				
				orders.setAdress((String) map.get("Adress"));
				orders.setAdressDetail((String) map.get("AdressDetail"));
				orders.setDate((String) map.get("Date"));
				orders.setGoodsID((int) map.get("GoodsID"));
				orders.setGoodsName((String) map.get("GoodsName"));
				orders.setGoodsType((String) map.get("GoodsType"));
				orders.setID((int) map.get("ID"));
				orders.setMemberName((String) map.get("MemberName"));
				orders.setOrderNum((String) map.get("OrderNum"));
				orders.setPriceNow((String) map.get("PriceNow"));
				orders.setTel((String) map.get("Tel"));
				orders.setSeller((String) map.get("Seller"));
				orders.setGoodsID((int) map.get("GoodsID"));
				
	       	    listorders.add(orders);	    	
			}
			return listorders;
		}else{
			return null;
		}
	}
	/**
	 * 遍历
	 * 买出列表
	 * @param name
	 * @return
	 */
	public List<Orders> list_orders(String name){
		String sql="select * from orders where membername=?";
		List<Map<String, Object>> list=DBUtil.list(sql,name);
		
		if(list!=null&&list.size()!=0){
			List<Orders> listorders=new ArrayList<Orders>();
			for(Map<String, Object> map:list){
				Orders orders=new Orders();
				
				orders.setAdress((String) map.get("Adress"));
				orders.setAdressDetail((String) map.get("AdressDetail"));
				orders.setDate((String) map.get("Date"));
				orders.setGoodsName((String) map.get("GoodsName"));
				orders.setGoodsType((String) map.get("GoodsType"));
				orders.setID((int) map.get("ID"));
				orders.setMemberName((String) map.get("MemberName"));
				orders.setOrderNum((String) map.get("OrderNum"));
				orders.setPriceNow((String) map.get("PriceNow"));
				orders.setTel((String) map.get("Tel"));
				orders.setSeller((String) map.get("Seller"));
				orders.setGoodsID((int) map.get("GoodsID"));
				
	       	    listorders.add(orders);	    	
			}
			return listorders;
		}else{
			return null;
		}
	}
	   /**
	    * 根据前台订单
	    * 直接获得用户信息
	    * @param name
	    * @return
	    */
	    public Member info_member(String name){
	    	String sql="select * from member where membername=?";
	    	Map<String, Object> map=DBUtil.query(sql, name);
	    	if(map!=null&&map.size()!=0){
	    		Member member=new Member();
	    		
	    		member.setAdress((String) map.get("Adress"));
	    		member.setAdressDetail((String) map.get("AdressDetail"));
	    		member.setMemberName((String) map.get("MemberName"));
	    		member.setTel((String) map.get("Tel"));
	    		
	    		return member;
	    	}else{
	    		return null;
	    	}
	    	
	    }
	    /**
	     * 由前台添加订单(涉及到了goods,car,orders表)
	     * @param id
	     * @param orders
	     * @param orderNum
	     */
	    public void add_orders(int id,Orders orders,String orderNum){
	        String sql="select * from goods where id=?"; //会进行多次查询 (循环)
	        Map<String, Object> map=DBUtil.query(sql, id);
	        if(map!=null&&map.size()!=0){
	        	Goods goods=new Goods();
	        	
	        	goods.setMemberName((String) map.get("MemberName"));//根据id获得该物品的卖家
	        	goods.setName((String) map.get("Name"));//获取商品名
	        	goods.setGoodsType((String) map.get("GoodsType"));
	        	goods.setPriceNow((int) map.get("PriceNow"));
	        	
	        	String sql2="insert into orders(OrderNum,Date,GoodsID,GoodsName,GoodsType,PriceNow,MemberName,Tel,Adress,AdressDetail,Seller)values(?,?,?,?,?,?,?,?,?,?,?)";
	        	DBUtil.executeUpdate(sql2,new Object[]{orderNum,sdf.format(date),id,goods.getName(),goods.getGoodsType(),goods.getPriceNow(),orders.getMemberName(),orders.getTel(),orders.getAdress(),orders.getAdressDetail(),goods.getMemberName()});
	        	
	        }
	    }
	    /**
	     * 订单成功后删除 购物车中的物品
	     * @param id
	     */
	    public void delete_car(int id){
	    	String sql="delete from car where id=?";
	    	DBUtil.executeUpdate(sql, id);
	    }
	 

}
