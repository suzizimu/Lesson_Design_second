package com.su_back.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.su_back.model.Admin;
import com.su_back.model.Log;
import com.su_back.util.DBUtil;

public class login_dao {
	 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
		
	 /**
	  * 登录 查询管理员信息
	  * @param username
	  * @param password
	  * @return
	  */
     public Admin query(String username,String password){
    	 String sql="select * from admin where  Name=? and PassWord=?";
    	 Map<String, Object> map=DBUtil.query(sql, new Object[]{username,password});
    	 if(map!=null&&map.size()!=0){
    		 Admin admin=new Admin();
    		 admin.setID((int) map.get("ID"));
    		 admin.setName((String) map.get("Name"));
    		 admin.setPassWord((String) map.get("PassWord"));
    		 admin.setSex((String) map.get("Sex"));
    		 admin.setCreatTime((String) map.get("Creattime"));   		
    		 return admin;
    	 }else{
    		 return null; 
    	 }
      	 
     }  
     /**
      * 记录登录次数，最后一次登录时间
      * @param username
      */
     public  void update(String username){
    	 String sql="update admin set logintimes=logintimes+1,lasttime=? where name=?";
    	 DBUtil.executeUpdate(sql,new Object[]{sdf.format(date),username});
     }
     /**
      * 操作日志之登录
      * @param log
      */
     public void log(Log log){
    	 String sql="insert into log(Date,Type,Ds,Name)values(?,?,?,?)";
    	 DBUtil.executeUpdate(sql, new Object[]{log.getDate(),log.getType(),log.getDs(),log.getName()});
     }
}
