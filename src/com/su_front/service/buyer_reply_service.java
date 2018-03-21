package com.su_front.service;

import java.util.List;

import com.su_front.dao.buyer_reply_dao;
import com.su_front.model.Buyer_reply;

public class buyer_reply_service {
	buyer_reply_dao bd=new buyer_reply_dao();
	/**
	 * 第一步评论操作
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Buyer_reply update1(int id) throws Exception{
		try {
			return bd.update1(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("第一步评论出错，原因是:"+e.getMessage());
		}
		
	}
	/**
	 * 评论商品
	 * @param buyer_reply
	 * @throws Exception
	 */
	public void buyer_reply(Buyer_reply buyer_reply,String name) throws Exception{
		try {
			bd.buyer_reply(buyer_reply,name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("评论失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 遍历列表
	 * @return
	 * @throws Exception 
	 */
	public List<Buyer_reply>  list(String name) throws Exception{
		try {
			return bd.list(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历失败原因是："+e.getMessage());
		}
	}
	/**
	 * 删除评论
	 * @param id
	 * @throws Exception 
	 */
	public void delete_buyer_reply(int id) throws Exception{
		try {
			bd.delete_buyer_reply(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除失败原因是："+e.getMessage());
		}
	}
	/**
	 * 模糊查询
	 * @param memberName
	 * @param date1
	 * @param date2
	 * @return
	 * @throws Exception
	 */
	 public List<Buyer_reply> select_buyer_reply(String goodsName,String date1,String date2) throws Exception{
		  try {
			return bd.select_buyer_reply(goodsName, date1, date2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
    }
} 
