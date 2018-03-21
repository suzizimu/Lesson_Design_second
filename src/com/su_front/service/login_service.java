package com.su_front.service;

import com.su_back.model.Member;
import com.su_front.dao.login_dao;

public class login_service {
	login_dao ld=new login_dao();
	/**
	 * 会员登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
    public Member query(String username,String password) throws Exception{
    	Member member=ld.query(username, password); 
       	if(member!=null){    		
			return member;		
		}else{
			throw new Exception("账号或密码错误");
		}
    }
}
