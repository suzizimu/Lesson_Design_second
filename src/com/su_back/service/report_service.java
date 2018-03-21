package com.su_back.service;

import java.util.List;

import com.su_back.dao.report_dao;
import com.su_back.model.Log;
import com.su_back.model.Report;



public class report_service {
     report_dao rd=new report_dao();
     /**
      * 遍历列表
      * @return
      * @throws Exception
      */
     public List<Report> report_list() throws Exception{
    	 try {
			return rd.report_list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历举报反馈列表失败，原因是："+e.getMessage());
		}
     }
 	/**
 	 * 统计report_list数目
 	 * @return
 	 * @throws Exception 
 	 */
 	public long report_count() throws Exception{
          try {
			return rd.report_count();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计数目失败，原因是："+e.getMessage());
		} 	
 	}
 	/**
 	 * 删除
 	 * @param id
 	 * @throws Exception
 	 */
 	public void delete_report(int id) throws Exception{
 		try {
			rd.delete_report(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除反馈失败，原因是："+e.getMessage());
		}
 	}
    /**
     * 操作日志
     * @param log
     * @throws Exception 
     */
    public void log(Log log) throws Exception{
   	    try {
			rd.log(log);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("日志操作失败，原因是："+e.getMessage());
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
    public List<Report> select_report(String name,String date1,String date2) throws Exception{
    	try {
			return rd.select_report(name, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
    }  
 	/**
 	 * 为了得到举报人名
 	 * @param id
 	 * @return
 	 * @throws Exception
 	 */
    public Report report_reply(int id) throws Exception{
    	try {
			return rd.report_reply(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("得到举报人名失败，原因是："+e.getMessage());
		}
    }
}
