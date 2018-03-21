package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Log;
import com.su_back.util.DBUtil;

public class log_dao {
	/**
	 * 日志列表
	 * @return
	 */
	public List<Log> list_log(){
		String sql="select * from log";
		List<Map<String, Object>> list=DBUtil.list(sql);
		
		if(list!=null&&list.size()!=0){
			List<Log> listlog=new ArrayList<Log>();
			for(Map<String, Object> map:list){
				Log log=new Log();
				
				log.setDate((String) map.get("Date"));
				log.setDs((String) map.get("Ds"));
				log.setID((int) map.get("ID"));
				log.setName((String) map.get("Name"));
				log.setType((String) map.get("Type"));
                listlog.add(log);
			}
			return listlog;
		}else{
			return null;
		}
	}
	/**
	 * 统计log_list数目
	 * @return
	 */
	public long log_count(){
		String sql="select count(*) as num from log";
		List<Map<String, Object>> list=DBUtil.list(sql);
		long record=(long) list.get(0).get("num");
		return record;		
	}
    /**
     * 模糊查询
     * @param type
     * @param date1
     * @param date2
     * @param name
     * @return
     */
    public List<Log> select_log(String type,String date1,String date2,String name){
      String sql="select * from log where 1=1";
      if(type!=null&&!type.trim().equals("")){
   		sql=sql+" and Type like '%"+type+"%'";
   		}
    	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
      	   sql=sql+" and Date between '"+date1+"' and '"+date2+"'";        
        }
    	if(name!=null&&(!name.trim().equals(""))){
    		sql=sql+" and Name like '%"+name+"%'";
    	}   	
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Log> listlog=new ArrayList<Log>();
  		 for(Map<String,Object> map:list){
  			Log log=new Log();
			
			log.setDate((String) map.get("Date"));
			log.setDs((String) map.get("Ds"));
			log.setID((int) map.get("ID"));
			log.setName((String) map.get("Name"));
			log.setType((String) map.get("Type"));
			
            listlog.add(log);     		
     	   }
  	   return listlog;     	
    		
    	}else{
    		return null;
    	}		
   	}   	
}

