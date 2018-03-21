package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Admin;
import com.su_back.model.Log;
import com.su_back.util.DBUtil;

public class admin_dao {
	/**
	 * 添加管理员操作
	 * @param admin
	 */
	public void add_admin(Admin admin){
		String sql="insert into admin(Name,PassWord,Sex,CreatTime) values(?,?,?,?)";
		DBUtil.executeUpdate(sql, new Object[]{admin.getName(),admin.getPassWord(),admin.getSex(),admin.getCreatTime()});
	}
	
	/**
	 * 管理员列表
	 * @return
	 */
	public List<Admin> list_admin(){
		String sql="select * from admin";
		List<Map<String, Object>> list=DBUtil.list(sql);
		
		if(list!=null&&list.size()!=0){
			List<Admin> listadmin=new ArrayList<Admin>();
			for(Map<String, Object> map:list){
				 Admin admin=new Admin();
				 
	    		 admin.setID((int) map.get("ID"));
	    		 admin.setName((String) map.get("Name"));
	    		 admin.setSex((String) map.get("Sex"));
	    		 admin.setCreatTime((String) map.get("CreatTime"));	    	
	    		 listadmin.add(admin);
			}
			return listadmin;
		}else{
			return null;
		}
	}
	/**
	 * 统计admin_list数目
	 * @return
	 */
	public long admin_count(){
		String sql="select count(*) as num from admin";
		List<Map<String, Object>> list=DBUtil.list(sql);
		long record=(long) list.get(0).get("num");
		return record;		
	}
	
	/**
	 * 删除管理员
	 * @param id
	 */
	public void delete_admin(int id){
		String sql="delete from admin where id=?";
		DBUtil.executeUpdate(sql, id);
	}
	/**
	 * 修改密码第一步
	 * @param id
	 * @return
	 */
	public Admin loadquery(int id){
		String sql="select * from admin where id=?";
		Map<String,Object> map=DBUtil.query(sql, id);
		if(map!=null&&map.size()!=0){
			Admin admin=new Admin();
			admin.setID((int) map.get("ID"));
			admin.setName((String) map.get("Name"));			
			return admin;
		}else{
			return null;
		}
		
	}
	/**
	 * 修改密码操作第二步 
	 * @param admin
	 */
	public void updatePWD(Admin admin){
		String sql="update admin set PassWord=? where id=?";
		DBUtil.executeUpdate(sql,new Object[]{admin.getPassWord(),admin.getID()});
	}
	/**
	 * 关于登录详情的 初值操作
	 * @param id
	 * @return
	 */
	public Admin login(int id){
		String sql="select * from admin where id=?";
		Map<String,Object> map=DBUtil.query(sql, id);
		if(map!=null&&map.size()!=0){
			Admin admin=new Admin();
			admin.setID((int) map.get("ID"));
			admin.setLoginTimes((int) map.get("LoginTimes"));
			admin.setLastTime((String) map.get("LastTime"));
			return admin;
		}else{
			return null;
		}
		
	}
	/**
     * 判断添加是否账号重复
     * 冲突
     * @param member
     * @return
     */
    public int check_admin(String name){
  	  String sql="select count(*) as num from admin where Name=?";
  	  Map<String, Object> map=DBUtil.query(sql,name);
  	  int num=Integer.parseInt(map.get("num").toString()) ;
  	  return num;
    }
    /**
     * 模糊查询
     * @param name
     * @param date1
     * @param date2
     * @return
     */
    public List<Admin> select_admin(String name,String date1,String date2){
    	String sql="select * from admin where 1=1";
    	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
     	   sql=sql+" and CreatTime between '"+date1+"' and '"+date2+"'";        
       }
    	if(name!=null&&(!name.trim().equals(""))){
    		sql=sql+" and Name like '%"+name+"%'";
    	}
    	
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	
    	if(list!=null&&list.size()!=0){
			List<Admin> listadmin=new ArrayList<Admin>();
			for(Map<String, Object> map:list){
				 Admin admin=new Admin();
				 
	    		 admin.setID((int) map.get("ID"));
	    		 admin.setName((String) map.get("Name"));
	    		 admin.setSex((String) map.get("Sex"));
	    		 admin.setCreatTime((String) map.get("CreatTime"));	    	
	    		 listadmin.add(admin);
			}
			return listadmin;
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
