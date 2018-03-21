package com.su_front.dao;

import java.util.Map;

import com.su_back.model.Member;
import com.su_back.util.DBUtil;

public class member_dao {
	/**前台
	 * 查看用户详情信息
	 * @param id
	 * @return
	 */
	public Member member_edit(String name){
		String sql="select * from member where membername=?";
		Map<String, Object> map=DBUtil.query(sql, name);
   	    if(map!=null&&map.size()!=0){
   		    Member member=new Member();
   		    
   		    member.setID((int) map.get("ID"));
			member.setMemberName((String) map.get("MemberName"));
			member.setPassWord((String) map.get("PassWord"));
			member.setSex((String) map.get("Sex"));
		    member.setEmail((String) map.get("Email"));
		    member.setTel((String) map.get("Tel"));
		    member.setAdress((String) map.get("Adress"));
		    member.setAdressDetail((String) map.get("AdressDetail"));
		    member.setUrl((String) map.get("Url"));
			member.setCreatTime((String) map.get("CreatTime"));	 
			
			return member;
   	    }else{
   	    	return null;
   	    }
	}
	
	/**
	 * 修改用户信息
	 * @param member
	 */
	public void update_member(Member member){
		String sql="update member set sex=?,email=?,tel=?,adress=?,adressdetail=?,url=? where id=?";
		DBUtil.executeUpdate(sql,new Object[]{member.getSex(),member.getEmail(),member.getTel(),member.getAdress(),member.getAdressDetail(),member.getUrl(),member.getID()});
	}
	
}
