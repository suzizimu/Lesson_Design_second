package com.su_back.service;

import java.util.List;

import com.su_back.dao.member_dao;
import com.su_back.model.Log;
import com.su_back.model.Member;

public class member_service {
	 member_dao md=new member_dao();
	 /**
	  * 添加用户操作
	  * @param member
	  * @throws Exception
	  */
     public void add_member(Member member) throws Exception{
    	 try {
    		 md.add_member(member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加用户失败，原因是："+e.getMessage());
		}    	 
     }
     /**
      * 遍历用户列表
      * @return
      * @throws Exception
      */
     public List<Member> list_member() throws Exception{
        try {
        	 return md.list_member();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("用户列表遍历失败，原因是："+e.getMessage());
		}			
     }
     /**
 	 * 统计member_list数目
 	 * @return
 	 * @throws Exception
 	 */
 	 public long member_count() throws Exception{
 		try {
 			return md.member_count();
 		} catch (Exception e) {
 			// TODO: handle exception
 			throw new Exception("统计member_list失败，原因是："+e.getMessage());
 		}
 	}
 	/**
 	 * 删除操作
 	 * @param id
 	 * @throws Exception
 	 */
 	public void delete_member(int id) throws Exception{
 		try {
 			md.delete_member(id);
 		} catch (Exception e) {
 			// TODO: handle exception
 			throw new Exception("删除失败，原因是:"+e.getMessage());
 		}
 	}
 	/**
 	 * 删除之前进行
 	 * 插入数据给member_del表
 	 * @param id
 	 * @throws Exception
 	 */
 	public void dellist_insert(int id) throws Exception{
 		try {
			md.dellist_insert(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("插入member_del表失败，原因是："+e.getMessage());
		}
 	}
 	/**
 	 * 复原操作
 	 * 插入数据给member表
 	 * @param id
 	 * @throws Exception
 	 */
 	public void list_insert(int id) throws Exception{
 		try {
			md.list_insert(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("插入member表失败，原因是："+e.getMessage());
		}
 	}
 	/**
 	 * 删除
 	 * 被删除的用户列表操作
 	 * @param id
 	 * @throws Exception
 	 */
 	public void delete_member_del(int id) throws Exception{
 		try {
 			md.delete_member_del(id);
 		} catch (Exception e) {
 			// TODO: handle exception
 			throw new Exception("删除失败，原因是:"+e.getMessage());
 		}
 	}
 	/**
     * 遍历删除的用户列表
     * @return
     * @throws Exception
     */
    public List<Member> dellist_member() throws Exception{
       try {
       	 return md.dellist_member();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("用户列表遍历失败，原因是："+e.getMessage());
		}			
    }
    /**
 	 * 统计member_list_delete数目
 	 * @return
 	 * @throws Exception
 	 */
 	 public long dellist_count() throws Exception{
 		try {
 			return md.dellist_count();
 		} catch (Exception e) {
 			// TODO: handle exception
 			throw new Exception("统计member_list_delete失败，原因是："+e.getMessage());
 		}
 	}
 	/**
 	 * 修改密码第一步
 	 * @param id
 	 * @return
 	 * @throws Exception
 	 */
 	public Member loadquery(int id) throws Exception{
 		try {
 			return md.loadquery(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("根据主键ID，查询失败，原因是："+e.getMessage());
		}
 		
 	}
 	/**
	 * 修改密码操作第二步
	 * @param admin
	 * @throws Exception
	 */
	public void updatePWD(Member member) throws Exception{
		try {
			md.updatePWD(member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改密码失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 查看用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Member member_detail(int id) throws Exception{
		try {
			return md.member_detail(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("查看用户信息详情失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 用户修改信息操作
	 * @param member
	 * @throws Exception
	 */
	public void update_member(Member member) throws Exception{
		try {
			md.update_member(member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("用户修改信息失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 模糊查询
	 * @param name
	 * @param date1
	 * @param date2
	 * @return
	 * @throws Exception
	 */
	public List<Member> select_member(String name,String date1,String date2) throws Exception{
		try {
			return md.select_member(name, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
	}
    /**
     * 操作日志之登录
     * @param log
     * @throws Exception 
     */
    public void log(Log log) throws Exception{
   	    try {
			md.log(log);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("操作日志失败，原因是："+e.getMessage());
		}
    }
}
