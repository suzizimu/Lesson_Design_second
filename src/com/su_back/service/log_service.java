package com.su_back.service;

import java.util.List;

import com.su_back.dao.log_dao;
import com.su_back.model.Log;

public class log_service {
	log_dao ld=new log_dao();
	/**
	 * 遍历日志列表
	 * @return
	 * @throws Exception
	 */
	public List<Log> list_log() throws Exception{
		try {
			return ld.list_log();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历日志列表失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 统计log_list数目
	 * @return
	 * @throws Exception 
	 */
	public long log_count() throws Exception{
		try {
			return ld.log_count();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计数目失败，原因是："+e.getMessage());
		}
	
	}
	/**
	 * 模糊查询
	 * @param type
	 * @param date1
	 * @param date2
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Log> select_news(String type,String date1,String date2,String name) throws Exception{
		try {
			return ld.select_log(type, date1, date2, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
	}

}
