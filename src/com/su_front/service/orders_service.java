package com.su_front.service;

import java.util.List;

import com.su_back.model.Member;
import com.su_back.model.Orders;
import com.su_front.dao.orders_dao;

public class orders_service {
	orders_dao od=new orders_dao();
	/**
	 * 卖出列表
	 * @param name
	 * @return
	 * @throws Exception
	 */
    public List<Orders> list_orders2(String name) throws Exception{
   	 try {
			return od.list_orders2(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历订单列表失败，原因是："+e.getMessage());
		}
    }
    /**
     * 买出列表
     * @param name
     * @return
     * @throws Exception
     */
    public List<Orders> list_orders(String name) throws Exception{
      	 try {
   			return od.list_orders(name);
   		} catch (Exception e) {
   			// TODO: handle exception
   			throw new Exception("遍历订单列表失败，原因是："+e.getMessage());
   		}
       }
    /**
     * 根据前台订单
     * 直接获得用户信息
     * @param name
     * @return
     * @throws Exception
     */
    public Member info_member(String name) throws Exception{
    	try {
			return od.info_member(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取用户信息失败，原因是："+e.getMessage());
		}
    }
    /**
     * 由前台添加订单(涉及到了goods,car,orders表)
     * @param id
     * @param orders
     * @param orderNum
     * @throws Exception
     */
    public void add_orders(int id,Orders orders,String orderNum) throws Exception{
    	try {
			od.add_orders(id, orders, orderNum);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加订单失败，原因是："+e.getMessage());
		}
    }
    /**
     * 订单成功后
     * 删除购物车
     * @param id
     * @throws Exception
     */
    public void delete_car(int id) throws Exception{
    	try {
			od.delete_car(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除购物车失败，原因是："+e.getMessage());
		}
    }
}
