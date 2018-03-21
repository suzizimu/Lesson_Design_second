package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Reply;
import com.su_back.util.DBUtil;

public class reply_dao {
	
	/**
	 * 个人中心遍历举报回复表
	 * @param name
	 * @return
	 */
	public List<Reply> reply_list(String name){
		String sql="select * from reply where membername=?";
		List<Map<String, Object>> list=DBUtil.list(sql, name);
		if(list!=null&&list.size()!=0){
			List<Reply> listreply=new ArrayList<Reply>();
			for(Map<String,Object> map:list){
				Reply reply=new Reply();
				
				reply.setAdminName((String) map.get("AdminName"));
				reply.setDate((String) map.get("Date"));
				reply.setGoodsID((int) map.get("GoodsID"));
				reply.setID((int) map.get("ID"));
				reply.setIntroduce((String) map.get("Introduce"));
				reply.setMemberName((String) map.get("MemberName"));		
				
				listreply.add(reply);
			}
			return listreply;
		}else{
			return null;
		}
	}
		

}
