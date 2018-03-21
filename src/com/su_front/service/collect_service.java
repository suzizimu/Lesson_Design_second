package com.su_front.service;

import java.util.List;

import com.su_front.dao.collect_dao;
import com.su_front.model.Collect;

public class collect_service {
      collect_dao cd=new collect_dao();
      /**
       * 收藏操作
       * @param id
       * @param name
       * @throws Exception
       */
      public void add_collect(int id,String name) throws Exception{
    	  try {
			cd.add_collect(id, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("收藏失败，原因是："+e.getMessage());
		}
      }
      /**
       *  删除收藏    
       * @param id
       * @throws Exception 
       */
      public void delete_collect(int id) throws Exception{
    	  try {
			cd.delete_collect(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除收藏失败，原因是："+e.getMessage());
		}
      }
      /**
       * 清空单个用户的全部列表
       * @param name
       * @throws Exception
       */
      public void delete_all(String name) throws Exception{
    	  try {
			cd.delete_all(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("情况收藏列表失败，原因是："+e.getMessage());
		}
      }
      /**个人中心
       * 遍历收藏列表
       * @param name
       * @return
       * @throws Exception
       */
      public List<Collect> collect_list(String name) throws Exception{
    	  try {
			return cd.collect_list(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历收藏列表失败，原因是："+e.getMessage());
		}
      }
}
