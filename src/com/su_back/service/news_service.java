package com.su_back.service;

import java.util.List;

import com.su_back.dao.news_dao;
import com.su_back.model.Log;
import com.su_back.model.News;

public class news_service {
      news_dao nd=new news_dao();
      /**
       * 添加资讯
       * @param news
       * @throws Exception
       */
      public void add_news(News news) throws Exception{ 
    	  try {
    	  	  nd.add_news(news);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加资讯失败，原因是："+e.getMessage());
		}
      }
      /**
       * 遍历资讯列表
       * @return
       * @throws Exception
       */
      public List<News> list_news() throws Exception{
    	  try {
			return nd.list_news();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历资讯失败，原因是："+e.getMessage());
		}
      }
      /**
       * 统计news_list数目
       * @return
       * @throws Exception
       */
      public long news_count() throws Exception{
    	  try {
			return nd.news_count();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("统计news_list失败，原因是："+e.getMessage());
		}
      }
      /**
       * 资讯删除
       * @param id
       * @throws Exception
       */
      public void delete_news(int id) throws Exception{
    	  try {
			nd.delete_news(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除资讯失败，原因是："+e.getMessage());
		}
      }
      /**
       * 编辑资讯第一步
       * @param id
       * @return
       * @throws Exception 
       */
      public News news_edit(int id) throws Exception{
    	  try {
			return nd.news_edit(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("资讯第一步编辑失败原因是："+e.getMessage());
		}
    	  
      }
      /**
       * 编辑资讯第二步
       * @param news
       * @throws Exception
       */
      public void update_news(News news) throws Exception{
    	  try {
			nd.update_news(news);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("资讯第二步编辑失败，原因是："+e.getMessage());
		}
      }
      /**
       * 模糊查询
       * @param type
       * @param date1
       * @param date2
       * @param title
       * @return
       * @throws Exception
       */
      public List<News> select_news(String type,String date1,String date2,String title) throws Exception{
    	  try {
			return nd.select_news(type, date1, date2, title);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
      }
      /**
       * 操作日志之登录
       * @param log
     * @throws Exception 
       */
      public void log(Log log) throws Exception{
           try {
			  nd.log(log);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("操作日志失败，原因是："+e.getMessage());
		}
      }
}
