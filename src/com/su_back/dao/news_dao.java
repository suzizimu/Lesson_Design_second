package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Log;
import com.su_back.model.News;
import com.su_back.util.DBUtil;

public class news_dao {
	/**
	 * 添加资讯
	 * @param news
	 */
     public void add_news(News news){
    	 String sql="insert into news(Author,AddTime,Content,Title,Type,Url,Photo)values(?,?,?,?,?,?,?)";
    	 DBUtil.executeUpdate(sql, new Object[]{news.getAuthor(),news.getAddTime(),news.getContent(),news.getTitle(),news.getType(),news.getUrl(),news.getPhoto()});
     }
     /**
      * 遍历资讯列表
      * @return
      */
     public List<News> list_news(){
    	 String sql="select * from news";
    	 List<Map<String, Object>> list=DBUtil.list(sql);
    	 if(list!=null&&list.size()!=0){
    		 List<News> listnews=new ArrayList<News>();
    		 for(Map<String,Object> map:list){
        		News news=new News();
        		
        		news.setAddTime((String) map.get("AddTime"));
        		news.setAuthor((String) map.get("Author"));
        		news.setClickTimes((int) map.get("ClickTimes"));
        		news.setContent((String) map.get("Content"));
        		news.setID((int) map.get("ID"));
        		news.setTitle((String) map.get("Title"));
        		news.setType((String) map.get("Type"));
        		news.setUrl((String) map.get("Url"));
        		news.setPhoto((String) map.get("Photo"));
        		
        		listnews.add(news);
       	   }
    	   return listnews;     	 
       }else{
    	   return null;
       }
   } 
     /**
      * 统计news_list数目
      * @return
      */
     public long news_count(){
    	String sql="select count(*) as num from news";
   		List<Map<String, Object>> list=DBUtil.list(sql);
   		long record=(long) list.get(0).get("num");
   		return record;	
     }
     /**
      * 删除资讯
      * @param id
      */
     public void delete_news(int id){
 		String sql="delete from news where id=?";
 		DBUtil.executeUpdate(sql, id);
     }
     /**
      * 资讯编辑第一步
      * @param id
      * @return
      */
     public News news_edit(int id){
    	 String sql="select * from news where id=?";
    	 Map<String, Object> map=DBUtil.query(sql,id);
    	 if(map!=null&&map.size()!=0){
    	    News news=new News();
    		 
    		news.setAddTime((String) map.get("AddTime"));
     		news.setAuthor((String) map.get("Author"));     		
     		news.setContent((String) map.get("Content"));
     		news.setID((int) map.get("ID"));
     		news.setTitle((String) map.get("Title"));
     		news.setType((String) map.get("Type"));
     		news.setUrl((String) map.get("Url"));
     		
     		return news;
    	 }else{
    		 return null;
    	 }
     }
     /**
      * 编辑第二步
      * @param news
      */
     public void update_news(News news){
    	 String sql="update news set author=?,content=?,title=?,type=?,url=?,photo=? where id=?";
    	 DBUtil.executeUpdate(sql,new Object[]{news.getAuthor(),news.getContent(),news.getTitle(),news.getType(),news.getUrl(),news.getPhoto(),news.getID()});
     }
     /**
      * 模糊查询
      * @param type
      * @param date1
      * @param date2
      * @param title
      * @return
      */
     public List<News> select_news(String type,String date1,String date2,String title){
    	String sql="select * from news where 1=1";
    	if(type!=null&&!type.trim().equals("")){
    		sql=sql+" and Type like '%"+type+"%'";
    		}
     	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
       	   sql=sql+" and AddTime between '"+date1+"' and '"+date2+"'";        
         }
     	if(title!=null&&(!title.trim().equals(""))){
     		sql=sql+" and Title like '%"+title+"%'";
     	}   	
     	List<Map<String, Object>> list=DBUtil.list(sql);
     	if(list!=null&&list.size()!=0){
     		List<News> listnews=new ArrayList<News>();
   		 for(Map<String,Object> map:list){
       		News news=new News();
       		
       		news.setAddTime((String) map.get("AddTime"));
       		news.setAuthor((String) map.get("Author"));
       		news.setClickTimes((int) map.get("ClickTimes"));
       		news.setContent((String) map.get("Content"));
       		news.setID((int) map.get("ID"));
       		news.setTitle((String) map.get("Title"));
       		news.setType((String) map.get("Type"));
       		news.setUrl((String) map.get("Url"));
       		news.setPhoto((String) map.get("Photo"));
       		
       		listnews.add(news);
      	   }
   	   return listnews;     	
     		
     	}else{
     		return null;
     	}		
    }   
     /**
      * 操作日志之登录
      * @param log
      */
     public void log(Log log){
    	 String sql="insert into log(Date,Type,Ds,Name)values(?,?,?,?)";
    	 DBUtil.executeUpdate(sql, new Object[]{log.getDate(),log.getType(),log.getDs(),log.getName()});
     }
}
