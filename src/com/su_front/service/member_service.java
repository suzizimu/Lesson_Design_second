package com.su_front.service;

import com.su_back.model.Member;
import com.su_front.dao.member_dao;

public class member_service {
	member_dao md=new member_dao();
	/**
	 * 前台获取个人信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Member member_edit(String name) throws Exception{
		try {
			return md.member_edit(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("前台获取个人信息失败，原因是："+e.getMessage());
		}
		
	}
	/**
	 * 用户修改信息操作
	 * @param member
	 * @throws Exception
	 */
	public void update_member(Member member) throws Exception{
		try {
			md.update_member(member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("用户修改信息失败，原因是："+e.getMessage());
		}
	}

}
