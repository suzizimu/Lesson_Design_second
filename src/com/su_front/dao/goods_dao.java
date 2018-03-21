package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.util.DBUtil;

public class goods_dao {
	/**
	 * 前台遍历
	 * 发布的商品列表
	 * @param name
	 * @return
	 */
    public List<Goods> list_goods(String name){
     	  String sql="select * from goods where membername=?";
     	  List<Map<String, Object>> list=DBUtil.list(sql,name);
     	  
     	  if(list!=null&&list.size()!=0){
   			List<Goods> listgoods=new ArrayList<Goods>();
   			for(Map<String, Object> mp:list){
   				Goods goods=new Goods();
   				 
   				  goods.setID((int) mp.get("ID"));
                  goods.setName((String) mp.get("Name"));
                  goods.setPriceAgo((int) mp.get("PriceAgo"));
                  goods.setPriceNow((int) mp.get("PriceNow"));
                  goods.setIntroduce((String) mp.get("Introduce"));
                  goods.setUrl((String) mp.get("Url"));
                  goods.setDate((String) mp.get("Date"));
                  goods.setTel((String) mp.get("Tel"));
                  goods.setClick((int) mp.get("Click"));
                  goods.setMemberName((String) mp.get("MemberName"));
                  goods.setGoodsType((String) mp.get("GoodsType"));  
                                 
                  listgoods.add(goods);
   			}
   			return listgoods;
   		}else{
   			return null;
   		}
   	
     }
    /**
     * 由id获取商品详情
     * @param id
     * @return
     */
    public Goods detail(String id){
    	String sql="select * from goods where id=?";
    	Map<String, Object> map=DBUtil.query(sql, id);
    	if(map!=null&&map.size()!=0){
    		Goods goods=new Goods();
    		
    		goods.setGoodsType((String) map.get("GoodsType"));
    		goods.setID((int) map.get("ID"));
    		goods.setName((String) map.get("Name"));
    		goods.setIntroduce((String) map.get("Introduce"));
    		goods.setPriceAgo((int) map.get("PriceAgo"));
    		goods.setPriceNow((int) map.get("PriceNow"));
    		goods.setUrl((String) map.get("Url"));
    		
    		return goods;
    	}else{
    		return null;
    	}    	    	
    }
    
    /**
     * 记录前台商品点击次数
     * @param id
     */
    public void click_goods(String id){
   	 String sql="update goods set click=click+1 where id=?";
   	 DBUtil.executeUpdate(sql,id);
    }
    
	/**
	 * 前台遍历
	 * 模糊查询
	 * @param name
	 * @return
	 */
    public List<Goods> select_goods(String goodsName){
     	  String sql="select * from goods where name like '%"+goodsName+"%'";
     	  List<Map<String, Object>> list=DBUtil.list(sql);
     	  
     	  if(list!=null&&list.size()!=0){
   			List<Goods> listgoods=new ArrayList<Goods>();
   			for(Map<String, Object> mp:list){
   				Goods goods=new Goods();
   				 
   				  goods.setID((int) mp.get("ID"));
                  goods.setName((String) mp.get("Name"));
                  goods.setPriceAgo((int) mp.get("PriceAgo"));
                  goods.setPriceNow((int) mp.get("PriceNow"));
                  goods.setIntroduce((String) mp.get("Introduce"));
                  goods.setUrl((String) mp.get("Url"));
                  goods.setDate((String) mp.get("Date"));
                  goods.setTel((String) mp.get("Tel"));
                  goods.setClick((int) mp.get("Click"));
                  goods.setMemberName((String) mp.get("MemberName"));
                  goods.setGoodsType((String) mp.get("GoodsType"));  
                                 
                  listgoods.add(goods);
   			}
   			return listgoods;
   		}else{
   			return null;
   		}
   	
     }
    

}
