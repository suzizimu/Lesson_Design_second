package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.model.Log;
import com.su_back.util.DBUtil;

public class goods_dao {
	/**
	 * 添加商品
	 * @param goods
	 */
     public void add_goods(Goods goods){
    	 String sql="insert into goods(Name,PriceAgo,PriceNow,Introduce,Url,Date,Tel,MemberName,GoodsType,Category)values(?,?,?,?,?,?,?,?,?,?)";
    	 DBUtil.executeUpdate(sql, new Object[]{goods.getName(),goods.getPriceAgo(),goods.getPriceNow(),goods.getIntroduce(),goods.getUrl(),goods.getDate(),goods.getTel(),goods.getMemberName(),goods.getGoodsType(),goods.getCategory()});
     }
     /**
      * 遍历商品列表
      * @return
      */
     public List<Goods> list_goods(){
   	  String sql="select * from goods";
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
     /**
      * 统计goods_list数目
      * @return
      */
  	 public long goods_count(){
  		String sql="select count(*) as num from goods";
  		List<Map<String, Object>> list=DBUtil.list(sql);
  		long record=(long) list.get(0).get("num");
  		return record;		
  	}
  	 /**
  	  * 编辑商品信息第一步
  	  * @param id
  	  * @return
  	  */
  	 public Goods goods_edit(int id){
  		 String sql="select * from goods where id=?";
  		 Map<String, Object> mp=DBUtil.query(sql, id);
  		 if(mp!=null&&mp.size()!=0){
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
             
             return goods;
  		 }else{
  			 return null;
  		 }
  		 
  	 }
  	 /**
  	  * 编辑商品信息第二步
  	  * @param goods
  	  */
  	 public void update_goods(Goods goods){
  		 String sql="update goods set name=?,priceAgo=?,priceNow=?,introduce=?,url=?,tel=?,membername=?,goodstype=?,category=? where id=?";
  		 DBUtil.executeUpdate(sql,new Object[]{goods.getName(),goods.getPriceAgo(),goods.getPriceNow(),goods.getIntroduce(),goods.getUrl(),goods.getTel(),goods.getMemberName(),goods.getGoodsType(),goods.getCategory(),goods.getID()});
  	 }
  	 /**
  	  * 删除商品
  	  * @param id
  	  */
   	public void delete_goods(int id){
 		String sql="delete from goods where id=?";
 		DBUtil.executeUpdate(sql, id);
 	}
   	/**
   	 * 模糊查询
   	 * @param type
   	 * @param date1
   	 * @param date2
   	 * @param name
   	 * @return
   	 */
   	public List<Goods> select_goods(String type,String date1,String date2,String name){
   		String sql="select * from goods where 1=1";
   		if(type!=null&&!type.trim().equals("")){
   			sql=sql+" and GoodsType like '%"+type+"%'";
   		}
    	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
      	   sql=sql+" and Date between '"+date1+"' and '"+date2+"'";        
        }
    	if(name!=null&&(!name.trim().equals(""))){
    		sql=sql+" and Name like '%"+name+"%'";
    	}   	
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Goods> listgoods=new ArrayList<Goods>();
    		for(Map<String,Object> map:list){
    			Goods goods=new Goods();
    			
 				goods.setID((int) map.get("ID"));
                goods.setName((String) map.get("Name"));
                goods.setPriceAgo((int) map.get("PriceAgo"));
                goods.setPriceNow((int) map.get("PriceNow"));
                goods.setIntroduce((String) map.get("Introduce"));
                goods.setUrl((String) map.get("Url"));
                goods.setDate((String) map.get("Date"));
                goods.setTel((String) map.get("Tel"));
                goods.setClick((int) map.get("Click"));
                goods.setMemberName((String) map.get("MemberName"));
                goods.setGoodsType((String) map.get("GoodsType"));
                
                listgoods.add(goods);
    		}
    		return listgoods;
    		
    	}else{
    		return null;
    	}		
   	}   	
    /**
     * 操作日志
     * @param log
     */
    public void log(Log log){
   	 String sql="insert into log(Date,Type,Ds,Name)values(?,?,?,?)";
   	 DBUtil.executeUpdate(sql, new Object[]{log.getDate(),log.getType(),log.getDs(),log.getName()});
    }
  	 
}

