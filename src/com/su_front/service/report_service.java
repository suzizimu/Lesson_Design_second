package com.su_front.service;

import java.util.List;

import com.su_back.model.Report;
import com.su_front.dao.report_dao;

public class report_service {
	report_dao rd=new report_dao();
	/**
	 * 获取前台基本信息 
	 * @param id
	 * @param memberName
	 * @return
	 * @throws Exception
	 */
	public Report add_report(int id,String memberName) throws Exception{
		try {
			return rd.add_report(id, memberName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("举报基本信息失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 添加举报信息
	 * @param report
	 * @throws Exception
	 */
	public void insert_report(Report report) throws Exception{
		try {
			rd.insert_report(report);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加举报信息失败，原因是："+e.getMessage());
		}
	}
	/**
	 * 遍历举报列表
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Report> report_list(String name) throws Exception{
		try {
			return rd.report_list(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历列表失败，原因是："+e.getMessage());
		}
	}
}
