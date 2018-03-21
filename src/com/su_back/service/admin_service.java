package com.su_back.service;

import java.util.List;

import com.su_back.dao.admin_dao;
import com.su_back.model.Admin;
import com.su_back.model.Log;

public class admin_service {
	admin_dao ad=new admin_dao();
	/**
	 * 添加管理员
	 * @param admin
	 * @throws Exception
	 */
	public void add_admin(Admin admin) throws Exception{
		try {
			ad.add_admin(admin);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加管理员失败，原因是："+e.getMessage());
		}
		
	}
    /**
     * 查询管理员列表
     * @return
     * @throws Exception
     */
	public List<Admin> list_admin() throws Exception{
		
		try {
			return ad.list_admin();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("查询管理员列表失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 统计admin_list数目
	 * @return
	 * @throws Exception
	 */
	public long admin_count() throws Exception{
		try {
			return ad.admin_count();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计admin_list失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 删除操作
	 * @param id
	 * @throws Exception
	 */
	public void delete_admin(int id) throws Exception{
		try {
			ad.delete_admin(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除失败，原因是:"+e.getMessage());
		}
	}
	/**
	 * 修改密码操作第一步
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Admin loadquery(int id) throws Exception{
		try {
			return ad.loadquery(id);
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
	public void updatePWD(Admin admin) throws Exception{
		try {
			ad.updatePWD(admin);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改密码失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 登录详情操作
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Admin login(int id) throws Exception{
		try {
			return ad.login(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("登录详情操作失败原因是："+e.getMessage());
		}
		
	}
	/**
	 * 模糊查询
	 */
	public List<Admin> select_admin(String name,String date1,String date2) throws Exception{
		try {
			return ad.select_admin(name, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
		
	}	
    /**
     * 操作日志之添加
     * @param log
     * @throws Exception 
     */
    public void log(Log log) throws Exception{
   	   try {
		ad.log(log);
	} catch (Exception e) {
		// TODO: handle exception
		throw new Exception("日志记录失败，原因是:"+e.getMessage());
	}
    }
}
