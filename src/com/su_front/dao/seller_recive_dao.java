package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.util.DBUtil;
import com.su_front.model.Buyer_reply;

public class seller_recive_dao {
	/**卖家收到的评论
	 * 遍历评论列表
	 * @return
	 */
	public List<Buyer_reply>  seller_list(String name){
		String sql="select * from buyer_reply where seller=?";
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
}
