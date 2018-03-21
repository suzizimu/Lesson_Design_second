package com.su_back.service;

import com.su_back.dao.login_dao;
import com.su_back.model.Admin;
import com.su_back.model.Log;

public class login_service {
	
	login_dao ld=new login_dao();
	 
	/**
	 * 判断 查询后得到的 admin是否为空
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
     public Admin query(String username,String password) throws Exception{
    	Admin admin=ld.query(username, password); 
    	if(admin!=null){    		
			return admin;		
		}else{
			throw new Exception("账号或密码错误");
		}
     }
     /**
      * 记录登录次数和最后一次登录时间
      * @param username
      * @throws Exception
      */
     public void update(String username) throws Exception{
    	try {
    		ld.update(username);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("登录次数和LastTime时间失败");
		}    	
    }
     /**
      * 登录日志
      * @param log
      * @throws Exception
      */
     public void log(Log log) throws Exception{
    	try {
			ld.log(log);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("记载登录日志失败，原因是："+e.getMessage());
		} 
     }
}
