package com.su_front.service;

import java.util.List;

import com.su_front.dao.view_dao;
import com.su_front.model.View;

public class view_service {
      view_dao vd=new view_dao();
      /**
       * 增加浏览记录
       * @param goodsID
       * @param name
       * @throws Exception
       */
      public void add_view(int goodsID,String name) throws Exception{
    	  try {
			vd.add_view(goodsID, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("增加最近浏览记录失败，原因是："+e.getMessage());
		}
      }
      /**
       * 遍历
       * 最近浏览记录
       * @param name
       * @return
       * @throws Exception
       */
      public List<View> list_view(String name) throws Exception{
    	  try {
			return vd.list_view(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历最近浏览列表失败，原因是："+e.getMessage());
		}
      }
      /**
       * 删除浏览记录
       * @param id
       * @throws Exception
       */
      public void delete_view(int id) throws Exception{
    	  try {
			vd.delete_view(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除浏览记录失败，原因是："+e.getMessage());
		}
      }
}
