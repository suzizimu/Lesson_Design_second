package com.su_front.service;

import java.util.List;

import com.su_front.dao.seller_recive_dao;
import com.su_front.model.Buyer_reply;

public class seller_recive_service {
     seller_recive_dao sd=new seller_recive_dao();
     
     /**
      *卖家收到的评论列表
      * @param name
      * @return
      * @throws Exception
      */
     public List<Buyer_reply>  seller_list(String name) throws Exception{
    	 try {
			return sd.seller_list(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("遍历卖家收到的评论列表失败，原因是："+e.getMessage());
		}
    	 
     }
}
