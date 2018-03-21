package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Log;
import com.su_back.model.Reply;
import com.su_back.util.DBUtil;

public class reply_dao {
	/**
	 * 添加回复
	 * @param reply
	 */
	public void insert_reply(Reply reply){
		 String sql="insert into reply(AdminName,MemberName,Introduce,Date,GoodsID)values(?,?,?,?,?)";
		 DBUtil.executeUpdate(sql,new Object[]{reply.getAdminName(),reply.getMemberName(),reply.getIntroduce(),reply.getDate(),reply.getGoodsID()});
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
     * 遍历列表
     * @return
     */
    public List<Reply> list_reply(){
    	String sql="select * from reply";
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Reply> listreply=new ArrayList<Reply>();
    		for(Map<String,Object> map:list){
    			Reply reply=new Reply();
    			
    			reply.setAdminName((String) map.get("AdminName"));
    			reply.setDate((String) map.get("Date"));
    			reply.setID((int) map.get("ID"));
    			reply.setIntroduce((String) map.get("Introduce"));
    			reply.setMemberName((String) map.get("MemberName"));
    			reply.setGoodsID((int) map.get("GoodsID"));
    			
    			listreply.add(reply);
    		}
    		return listreply;
    	}else{
    		return null;
    	}
    }
    /**
     * 统计reply_list数目
     * @return
     */
 	 public long reply_count(){
 		String sql="select count(*) as num from reply";
 		List<Map<String, Object>> list=DBUtil.list(sql);
 		long record=(long) list.get(0).get("num");
 		return record;		
 	}
 	 /**
 	  * 删除操作
 	  * @param id
 	  */
 	 public void delete_reply(int id){
 		 String sql="delete from reply where id=?";
 		 DBUtil.executeUpdate(sql,id);
 	 }
 	 /**
 	  * 模糊查询
 	  * @param adminName
 	  * @param memberName
 	  * @param date1
 	  * @param date2
 	  * @return
 	  */
     public List<Reply> select_reply(String adminName,String memberName,String date1,String date2){
     	String sql="select * from reply where 1=1";
     	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
      	   sql=sql+" and Date between '"+date1+"' and '"+date2+"'";        
        }
     	if(adminName!=null&&(!adminName.trim().equals(""))){
     		sql=sql+" and AdminName like '%"+adminName+"%'";
     	}
     	if(memberName!=null&&(!memberName.trim().equals(""))){
     		sql=sql+" and MemberName like '%"+memberName+"%'";
     	}
     	
     	List<Map<String, Object>> list=DBUtil.list(sql);
     	
     	if(list!=null&&list.size()!=0){
 			List<Reply> listreply=new ArrayList<Reply>();
 			for(Map<String, Object> map:list){
    			Reply reply=new Reply();
    			
    			reply.setAdminName((String) map.get("AdminName"));
    			reply.setDate((String) map.get("Date"));
    			reply.setID((int) map.get("ID"));
    			reply.setIntroduce((String) map.get("Introduce"));
    			reply.setMemberName((String) map.get("MemberName"));
    			
    			listreply.add(reply);
 			}
 			return listreply;
 		}else{
 			return null;
 		}
     	
     }

}
