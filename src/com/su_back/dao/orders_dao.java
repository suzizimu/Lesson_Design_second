package com.su_back.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.su_back.model.Log;

import com.su_back.model.Orders;
import com.su_back.util.DBUtil;

public class orders_dao {
    Date  date=new Date();
 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	//sdf.format(date);
	
	/**
	 * 订单列表
	 * @return
	 */
	public List<Orders> list_orders(){
		String sql="select * from orders";
		List<Map<String, Object>> list=DBUtil.list(sql);
		
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
				
	       	    listorders.add(orders);	    	
			}
			return listorders;
		}else{
			return null;
		}
	}
	/**
	 * 统计orders_list数目
	 * @return
	 */
	public long orders_count(){
		String sql="select count(*) as num from orders";
		List<Map<String, Object>> list=DBUtil.list(sql);
		long record=(long) list.get(0).get("num");
		return record;		
	}

    /**
     * 操作日志之登录
     * @param log
     */
    public void log(Log log){
   	 String sql="insert into log(Date,Type,Ds,Name)values(?,?,?,?)";
   	 DBUtil.executeUpdate(sql, new Object[]{log.getDate(),log.getType(),log.getDs(),log.getName()});
    }
    /**
     * 删除订单
     * @param id
     */
    public void delete_orders(int id){
    	String sql="delete from orders where id=?";
    	DBUtil.executeUpdate(sql,id);
    }
    /**
     * 模糊查询
     * @param type
     * @param date1
     * @param date2
     * @param memberName
     * @param num
     * @return
     */
    public List<Orders> select_orders(String type,String date1,String date2,String memberName,String num){
    	String sql="select * from orders where 1=1";
     	if(type!=null&&!type.trim().equals("")){
   		sql=sql+" and GoodsType like '%"+type+"%'";
   		}
    	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
      	   sql=sql+" and Date between '"+date1+"' and '"+date2+"'";        
        }
    	if(memberName!=null&&(!memberName.trim().equals(""))){
    		sql=sql+" and MemberName like '%"+memberName+"%'";
    	} 
    	if(num!=null&&(!num.trim().equals(""))){
    		sql=sql+" and OrderNum like '%"+num+"%'";
    	} 
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Orders> listorders=new ArrayList<Orders>();
  		 for(Map<String,Object> map:list){
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
			
	        listorders.add(orders);	    		
     	  }
  	   return listorders;     	    		
    }else{
    	return null;
    }		
  }   


}
