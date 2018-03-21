package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.util.DBUtil;
import com.su_front.model.View;

public class view_dao {
	/**
	 * 增加的最近浏览记录
	 * @param goodsID
	 * @param name
	 */
	public void add_view(int goodsID,String name){
		String sql="select * from goods where id=?";
		Map<String, Object> map=DBUtil.query(sql,goodsID);
		if(map!=null&&map.size()!=0){
			Goods goods=new Goods();
			
			goods.setDate((String) map.get("Date"));
			goods.setGoodsType((String) map.get("GoodsType"));
			goods.setID((int) map.get("ID"));
			goods.setName((String) map.get("Name"));
			goods.setPriceAgo((int) map.get("PriceAgo"));
			goods.setPriceNow((int) map.get("PriceNow"));
			goods.setUrl((String) map.get("Url"));
			
			String sql2="insert into view (MemberName,GoodsID,GoodsName,GoodsType,Url,PriceAgo,PriceNow,Date)values(?,?,?,?,?,?,?,?)";
			DBUtil.executeUpdate(sql2,new Object[]{name,goods.getID(),goods.getName(),goods.getGoodsType(),goods.getUrl(),goods.getPriceAgo(),goods.getPriceNow(),goods.getDate()});
			
		}
	}
	/**
	 * 遍历
	 * 最近浏览
	 * @param name
	 * @return
	 */
    public List<View> list_view(String name){
    	 String sql="select * from view where membername=? ";
    	 List<Map<String, Object>> list= DBUtil.list(sql, name);
    	 if(list!=null&&list.size()!=0){
    		 List<View> listview=new ArrayList<View>();
    		 for(Map<String,Object> map:list){
    			 View view=new View();
    			 
    			 view.setID((int) map.get("ID"));
    			 view.setDate((String) map.get("Date"));
    			 view.setGoodsID((int) map.get("GoodsID"));
    			 view.setGoodsName((String) map.get("GoodsName"));
    			 view.setGoodsType((String) map.get("GoodsType"));
    			 view.setMemberName((String) map.get("MemberName"));
    			 view.setPriceAgo((String) map.get("PriceAgo"));
    			 view.setPriceNow((String) map.get("PriceNow"));
    			 view.setUrl((String) map.get("Url"));
    			 
    			 listview.add(view);    			 
    		 }
    		 return listview;
    	 }else{
    		 return null;
    	 }
    	       
    }
    /**
     * 删除浏览记录
     * @param id
     */
    public void delete_view(int id){
    	String sql="delete from view where id=?";
    	DBUtil.executeUpdate(sql,id);
    }

}
