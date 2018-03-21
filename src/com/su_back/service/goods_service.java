package com.su_back.service;

import java.util.List;

import com.su_back.dao.goods_dao;
import com.su_back.model.Goods;
import com.su_back.model.Log;


public class goods_service {
     goods_dao gd=new goods_dao();
     /**
      * 添加商品
      * @param goods
      * @throws Exception
      */
     public void add_goods(Goods goods) throws Exception{
    	 try {
			gd.add_goods(goods);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("添加商品失败，原因是："+e.getMessage());
		}
     }
     /**
      * 遍历商品列表
      * @return
      * @throws Exception
      */
     public List<Goods> list_goods() throws Exception{
    	 try {
			return gd.list_goods();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历商品列表失败，原因是："+e.getMessage());
     }
  } 
     /**
      * 统计goods_list数目
      * @return
      * @throws Exception
      */
     public long goods_count() throws Exception{
  		try {
  			return gd.goods_count();
  		} catch (Exception e) {
  			// TODO: handle exception
  			throw new Exception("统计goods_list失败，原因是："+e.getMessage());
  		}
  	}
     /**
      * 编辑商品信息第一步
      * @param id
      * @return
      * @throws Exception
      */
     public Goods goods_edit(int id) throws Exception{
    	 try {
			return gd.goods_edit(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("编辑商品初值失败，原因是："+e.getMessage());
		}
     }
     /**
      * 编辑商品信息第二步
      * @param goods
      * @throws Exception
      */
     public void update_goods(Goods goods) throws Exception{   	 
    	 try {
    		 gd.update_goods(goods);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("提交商品信息失败，原因是："+e.getMessage());
		}
     }
     /**
      * 删除商品
      * @param id
      * @throws Exception
      */
     public void delete_goods(int id) throws Exception{  	 
    	 try {
    		 gd.delete_goods(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("删除失败，原因是:"+e.getMessage());
		}
     }
     /**
      * 模糊查询
      * @param type
      * @param date1
      * @param date2
      * @param name
      * @return
      * @throws Exception
      */
     public List<Goods> select_goods(String type,String date1,String date2,String name) throws Exception{
    	 try {
			return gd.select_goods(type, date1, date2, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("模糊查询失败，原因是："+e.getMessage());
		}
     }
     /**
      * 操作日志
      * @param log
     * @throws Exception 
      */
     public void log(Log log) throws Exception{
    	try {
			gd.log(log);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("操作日志失败，原因是："+e.getMessage());
		}
     }
     
}
