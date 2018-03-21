package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Log;
import com.su_back.model.Report;
import com.su_back.util.DBUtil;

public class report_dao {
	/**
	 * 遍历反馈举报表
	 * @return
	 */
	public List<Report> report_list(){
		String sql="select * from report";
		List<Map<String, Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()!=0){
			List<Report> listreport=new ArrayList<Report>();
			for(Map<String,Object> map:list){
				Report report=new Report();
				
				report.setGoodsID((int) map.get("GoodsID"));
				report.setGoodsName((String) map.get("GoodsName"));
				report.setID((int) map.get("ID"));
				report.setIntroduce((String) map.get("Introduce"));
				report.setMemberName((String) map.get("MemberName"));
				report.setTel((String) map.get("Tel"));
				report.setDate((String) map.get("Date"));
				
				listreport.add(report);				
			}
			return listreport;
		}else{
			return null;
		}
		
	}
	/**
	 * 统计report_list数目
	 * @return
	 */
	public long report_count(){
		String sql="select count(*) as num from report";
		List<Map<String, Object>> list=DBUtil.list(sql);
		long record=(long) list.get(0).get("num");
		return record;		
	}
	/**
	 * 删除
	 * @param id
	 */
	public void delete_report(int id){
		String sql="delete from report where id=?";
		DBUtil.executeUpdate(sql,id);
	}
    /**
     * 操作日志
     * @param log
     */
    public void log(Log log){
   	 String sql="insert into log(Date,Type,Ds,Name)values(?,?,?,?)";
   	 DBUtil.executeUpdate(sql, new Object[]{log.getDate(),log.getType(),log.getDs(),log.getName()});
    }
    
    /**
     * 模糊查询
     * @param name
     * @param date1
     * @param date2
     * @return
     */
    public List<Report> select_report(String name,String date1,String date2){
    	String sql="select * from report where 1=1";
    	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
     	   sql=sql+" and Date between '"+date1+"' and '"+date2+"'";        
       }
    	if(name!=null&&(!name.trim().equals(""))){
    		sql=sql+" and MemberName like '%"+name+"%'";
    	}
    	
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	
    	if(list!=null&&list.size()!=0){
			List<Report> listreport=new ArrayList<Report>();
			for(Map<String, Object> map:list){
				Report report=new Report();
				
				report.setGoodsID((int) map.get("GoodsID"));
				report.setGoodsName((String) map.get("GoodsName"));
				report.setID((int) map.get("ID"));
				report.setIntroduce((String) map.get("Introduce"));
				report.setMemberName((String) map.get("MemberName"));
				report.setTel((String) map.get("Tel"));
				report.setDate((String) map.get("Date"));
				
				listreport.add(report);
			}
			return listreport;
		}else{
			return null;
		}
    	
    }
    /**
     * 反馈回复为了获取举报人名字
     * @param id
     * @return
     */
    public Report report_reply(int id){
    	String sql="select * from report where id=?";
    	Map<String, Object>  map=DBUtil.query(sql, id);
    	if(map!=null&&map.size()!=0){
    		Report report=new Report();           
    		report.setMemberName((String) map.get("MemberName"));
    		report.setGoodsID((int) map.get("GoodsID"));
    		
    		return report;
    	}else{
    		return null;
    	}
    	
    }
	

}
