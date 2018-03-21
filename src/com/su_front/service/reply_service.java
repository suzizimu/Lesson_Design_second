package com.su_front.service;

import java.util.List;

import com.su_back.model.Reply;
import com.su_front.dao.reply_dao;

public class reply_service {
	reply_dao rd=new reply_dao();
	/**
	 * 个人中心
	 * 举报回复表
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Reply> reply_list(String name) throws Exception{
		try {
			return rd.reply_list(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取举报回复表失败，原因是："+e.getMessage());
		}
		
	}
}
