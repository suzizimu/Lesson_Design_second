package com.su_front.service;

import com.su_front.dao.car_dao;

public class car_service {
	car_dao cd=new car_dao();
	/**
	 * 添加到购物车
	 * @param id
	 * @param name
	 * @throws Exception
	 */
	public void add_car(int id,String name) throws Exception{
		try {
			cd.add_car(id, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加到购物车失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 删除购物车
	 * @param id
	 * @throws Exception
	 */
	public void delete_car(int id) throws Exception{
		try {
			cd.delete_car(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除购物车失败，原因是："+e.getMessage());
		}
	}

}
