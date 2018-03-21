package com.su_front.service;

import java.util.List;

import com.su_back.model.Goods;
import com.su_front.dao.goods_dao;

public class goods_service {
    goods_dao gd=new goods_dao();
    /**
     * 前台遍历商品列表
     * @param name
     * @return
     * @throws Exception
     */
    public List<Goods> list_goods(String name) throws Exception{
   	 try {
			return gd.list_goods(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历商品列表失败，原因是："+e.getMessage());
    }
 }
    /**
     * 商品详情
     * @param id
     * @return
     * @throws Exception 
     */
    public Goods detail(String id) throws Exception{
    	try {
			return gd.detail(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取商品详情失败，原因是："+e.getMessage());
		}
    }
    
    /**
     * 记录前台商品点击次数
     * @param id
     * @throws Exception 
     */
    public void click_goods(String id) throws Exception{
         try {
			gd.click_goods(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("改变商品点击次数失败，原因是："+e.getMessage());
		}
    }
    
    /**
     * 前台个人中心
     * @param goodsName
     * @return
     * @throws Exception
     */
    public List<Goods> select_goods(String goodsName) throws Exception{
    	try {
			return gd.select_goods(goodsName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台模糊查询失败，原因是："+e.getMessage());
		}
    }
}
