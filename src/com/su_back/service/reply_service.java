package com.su_back.service;

import java.util.List;

import com.su_back.dao.reply_dao;
import com.su_back.model.Log;
import com.su_back.model.Reply;


public class reply_service {
     reply_dao rd=new reply_dao();
     /**
      * 添加回复
      * @param reply
      * @throws Exception
      */
     public void insert_reply(Reply reply) throws Exception{
    	 try {
			rd.insert_reply(reply);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加回复失败，原因是："+e.getMessage());
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
			throw new Exception("操作日志失败，原因是："+e.getMessage());
		}
     }
     /**
      * 遍历列表
      * @return
      * @throws Exception
      */
     public List<Reply> list_reply() throws Exception{
        try {
			return rd.list_reply();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历回复列表失败，原因是："+e.getMessage());
		}
     }
     /**
      * 统计reply_list数目
      * @return
     * @throws Exception 
      */
  	 public long reply_count() throws Exception{
         try {
			return rd.reply_count();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计数目失败，原因是："+e.getMessage());
		}	
  	}
  	 /**
  	  * 删除操作
  	  * @param id
  	  * @throws Exception
  	  */
  	 public void delete_reply(int id) throws Exception{
  		 try {
			rd.delete_reply(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除留言失败，原因是："+e.getMessage());
		}
  	 }
  	 /**
  	  * 模糊查询
  	  * @param adminName
  	  * @param memberName
  	  * @param date1
  	  * @param date2
  	  * @return
  	  * @throws Exception
  	  */
  	 public List<Reply> select_reply(String adminName,String memberName,String date1,String date2) throws Exception{
  		 try {
			return rd.select_reply(adminName, memberName, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
  	 }
}
