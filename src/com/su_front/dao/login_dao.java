package com.su_front.dao;

import java.util.Map;

import com.su_back.model.Member;
import com.su_back.util.DBUtil;

public class login_dao {
	/**
	 * 会员登录
	 * @param username
	 * @param password
	 * @return
	 */
    public Member query(String username,String password){
   	 String sql="select * from member where  MemberName=? and PassWord=?";
   	 Map<String, Object> map=DBUtil.query(sql, new Object[]{username,password});
   	 if(map!=null&&map.size()!=0){
   		 Member member=new Member();
   	 
   		 member.setID((int) map.get("ID"));
   		 member.setMemberName((String) map.get("MemberName"));
   		 member.setPassWord((String) map.get("PassWord"));  			
  		 
   		 return member;
   	 }else{
   		 return null; 
   	 }
     	 
    }  

}
