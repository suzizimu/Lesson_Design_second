package com.su_back.service;

import java.util.List;

import com.su_back.dao.orders_dao;
import com.su_back.model.Log;
import com.su_back.model.Member;
import com.su_back.model.Orders;

public class orders_service {
     orders_dao od=new orders_dao();
     /**
      * 遍历订单列表
      * @return
      * @throws Exception
      */
     public List<Orders> list_orders() throws Exception{
    	 try {
			return od.list_orders();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历订单列表失败，原因是："+e.getMessage());
		}
     }
 	  /**
 	  * 统计orders_list数目
 	  * @return
 	 * @throws Exception 
 	  */
    public long orders_count() throws Exception{
 		try {
			return od.orders_count();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计数目失败，原因是："+e.getMessage());
		}
 	}

    /**
     * 操作日志之登录
     * @param log
     * @throws Exception 
     */
    public void log(Log log) throws Exception{
   	   try {
		   od.log(log);
    	} catch (Exception e) {
		// TODO: handle exception
    	   throw new Exception("操作日志失败，原因是："+e.getMessage());
	 }
   }
    /**
     * 删除订单
     * @param id
     * @throws Exception
     */
    public void delete_orders(int id) throws Exception{
    	try {
			od.delete_orders(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除订单失败，原因是："+e.getMessage());
		}
    }
    /**
     * 模糊查询
     * @param type
     * @param date1
     * @param date2
     * @param memberName
     * @param num
     * @return
     * @throws Exception
     */
    public List<Orders> select_orders(String type,String date1,String date2,String memberName,String num) throws Exception{
    	try {
			return od.select_orders(type, date1, date2, memberName, num);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
    }

}
