package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.model.Member;
import com.su_back.model.Report;
import com.su_back.util.DBUtil;

public class report_dao {
	/**
	 * 前台获取
	 * 举报基本信息
	 * @param id
	 * @param memberName
	 * @return
	 */
	public Report add_report(int id,String memberName){
		String sql="select * from goods where id=?";
		Map<String, Object> map=DBUtil.query(sql, id);
		if(map!=null&&map.size()!=0){
			Goods goods=new Goods();			
			goods.setID((int) map.get("ID"));
			goods.setName((String) map.get("Name"));	
			
			
			String sql2="select * from member where membername=?";
			Map<String, Object> map2=DBUtil.query(sql2,memberName);
			
		    Member member=new Member();			    			
		    member.setTel((String) map2.get("Tel"));
			    
			Report report=new Report();
	        report.setMemberName(member.getMemberName());
	        report.setTel(member.getTel());
	        report.setGoodsID(goods.getID());
		    report.setGoodsName(goods.getName());
			 	
			return report;
		}else{
			return null;
		}
			
	}
	/**前台的
	 * 添加举报信息到数据库
	 * @param report
	 */
	public void insert_report(Report report){
		String sql="insert into report(MemberName,Tel,GoodsID,GoodsName,Introduce,Date)values(?,?,?,?,?,?)";
		DBUtil.executeUpdate(sql,new Object[]{report.getMemberName(),report.getTel(),report.getGoodsID(),report.getGoodsName(),report.getIntroduce(),report.getDate()});
	}
	/**
	 * 个人中心遍历举报表
	 * @param name
	 * @return
	 */
	public List<Report> report_list(String name){
		String sql="select * from report where membername=?";
		List<Map<String, Object>> list=DBUtil.list(sql, name);
		if(list!=null&&list.size()!=0){
			List<Report> listreport=new ArrayList<Report>();
			for(Map<String,Object> map:list){
				Report report=new Report();
				
				report.setDate((String) map.get("Date"));
				report.setGoodsID((int) map.get("GoodsID"));
				report.setGoodsName((String) map.get("GoodsName"));
				report.setID((int) map.get("ID"));
				report.setIntroduce((String) map.get("Introduce"));
				report.setMemberName((String) map.get("MemberName"));
				report.setTel((String) map.get("Tel"));
				
				listreport.add(report);
			}
			return listreport;
		}else{
			return null;
		}
	}
		

}
