package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Member;
import com.su_back.util.DBUtil;
import com.su_front.model.Buyer_reply;

public class buyer_reply_dao {
	/**
	 * 在买入的商品列表
	 * 第一步评论操作
	 * @param id
	 * @return
	 */
	public Buyer_reply update1(int id){
		String sql="select * from orders where id=?";
		Map<String, Object> map=DBUtil.query(sql, id);
		if(map!=null&&map.size()!=0){
			Buyer_reply buyer_reply=new Buyer_reply();
			
			buyer_reply.setDate((String) map.get("Date"));
			buyer_reply.setGoodsID((int) map.get("GoodsID"));
			buyer_reply.setGoodsName((String) map.get("GoodsName"));
			buyer_reply.setID((int) map.get("ID"));
			buyer_reply.setIntroduce((String) map.get("Introduce"));
			buyer_reply.setMemberName((String) map.get("MemberName"));
			buyer_reply.setOrderNum((String) map.get("OrderNum"));
			buyer_reply.setSeller((String) map.get("Seller"));
			
			return buyer_reply;
		}else{
			return null;
		}
		
	}
	/**
	 * 第二步
	 * 评论商品
	 * @param buyer_reply
	 */
	public void buyer_reply(Buyer_reply buyer_reply,String name){		
		String sql2="select * from member where membername=?";
		Map<String, Object> map=DBUtil.query(sql2, name);
		if(map!=null&&map.size()!=0){
			Member member=new Member();
			
			member.setUrl((String) map.get("Url"));
			
			String sql="insert into buyer_reply (OrderNum,GoodsID,GoodsName,MemberName,Seller,Introduce,Date,Url)values(?,?,?,?,?,?,?,?)";
			DBUtil.executeUpdate(sql, new Object[]{buyer_reply.getOrderNum(),buyer_reply.getGoodsID(),buyer_reply.getGoodsName(),buyer_reply.getMemberName(),buyer_reply.getSeller(),buyer_reply.getIntroduce(),buyer_reply.getDate(),member.getUrl()});
		}
		
		
	}
	/**
	 * 遍历评论列表
	 * @return
	 */
	public List<Buyer_reply>  list(String name){
		String sql="select * from buyer_reply where membername=?";
		List<Map<String, Object>> list=DBUtil.list(sql,name);
		if(list!=null&&list.size()!=0){
			List<Buyer_reply> listbuyer_reply=new ArrayList<Buyer_reply>();
			for(Map<String,Object> map:list){
				Buyer_reply buyer_reply=new Buyer_reply();
				
				buyer_reply.setDate((String) map.get("Date"));
				buyer_reply.setGoodsID((int) map.get("GoodsID"));
				buyer_reply.setGoodsName((String) map.get("GoodsName"));
				buyer_reply.setID((int) map.get("ID"));
				buyer_reply.setIntroduce((String) map.get("Introduce"));
				buyer_reply.setMemberName((String) map.get("MemberName"));
				buyer_reply.setOrderNum((String) map.get("OrderNum"));
				buyer_reply.setSeller((String) map.get("Seller"));
				
		        listbuyer_reply.add(buyer_reply);
			}
			return listbuyer_reply;
		}else{
			return null;
		}
	}
	/**
	 * 删除评论
	 * @param id
	 */
	public void delete_buyer_reply(int id){
		String sql="delete from buyer_reply where id=?";
		DBUtil.executeUpdate(sql,id);
	}
	/**
	 * 模糊查询
	 * @param memberName
	 * @param date1
	 * @param date2
	 * @return
	 */
    public List<Buyer_reply> select_buyer_reply(String goodsName,String date1,String date2){
     	String sql="select * from buyer_reply where 1=1";
     	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
      	   sql=sql+" and Date between '"+date1+"' and '"+date2+"'";        
        }
     	if(goodsName!=null&&(!goodsName.trim().equals(""))){
     		sql=sql+" and GoodsName like '%"+goodsName+"%'";
     	}
     	
     	List<Map<String, Object>> list=DBUtil.list(sql);
     	
     	if(list!=null&&list.size()!=0){
 			List<Buyer_reply> listbuyer_reply=new ArrayList<Buyer_reply>();
 			for(Map<String, Object> map:list){
 				Buyer_reply buyer_reply=new Buyer_reply();
    			
				buyer_reply.setDate((String) map.get("Date"));
				buyer_reply.setGoodsID((int) map.get("GoodsID"));
				buyer_reply.setGoodsName((String) map.get("GoodsName"));
				buyer_reply.setID((int) map.get("ID"));
				buyer_reply.setIntroduce((String) map.get("Introduce"));
				buyer_reply.setMemberName((String) map.get("MemberName"));
				buyer_reply.setOrderNum((String) map.get("OrderNum"));
				buyer_reply.setSeller((String) map.get("Seller"));
    			
				listbuyer_reply.add(buyer_reply);
 			}
 			return listbuyer_reply;
 		}else{
 			return null;
 		}
     	
    }

}
