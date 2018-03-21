package com.su_front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Goods;
import com.su_back.util.DBUtil;
import com.su_front.model.Collect;

public class collect_dao {
	/**
	 * 会员收藏操作
	 * @param id
	 * @param name
	 */
	public void add_collect(int id,String name){
		String sql="select * from goods where id=?";
		Map<String, Object> map=DBUtil.query(sql,id);
		if(map!=null&&map.size()!=0){
			Goods goods=new Goods();
			
			goods.setID((int) map.get("ID"));
			goods.setGoodsType((String) map.get("GoodsType"));
			goods.setName((String) map.get("Name"));
			goods.setPriceNow((int) map.get("PriceNow"));
			goods.setUrl((String) map.get("Url"));
			
			String sql2="insert into collect (Collector,GoodsID,GoodsType,Name,PriceNow,Url)values(?,?,?,?,?,?)";
			DBUtil.executeUpdate(sql2, new Object[]{name,goods.getID(),goods.getGoodsType(),goods.getName(),goods.getPriceNow(),goods.getUrl()});
		}
		
		
	}
	/**
	 * 删除单个的收藏
	 * @param id
	 */
	public void delete_collect(int id){
		String sql="delete from collect where id=?";
		DBUtil.executeUpdate(sql,id);
	}
	/**
	 * 删除一个用户全部收藏
	 * @param name
	 */
	public void delete_all(String name){
		String sql="delete from collect where collector=?";
		DBUtil.executeUpdate(sql, name);
	}
	/**个人中心
	 * 遍历收藏表
	 * @param name
	 * @return
	 */
	public List<Collect> collect_list(String name){
		String sql="select * from collect where collector=?";
		List<Map<String, Object>> list=DBUtil.list(sql,name);
		if(list!=null&&list.size()!=0){
			List<Collect> listcollect=new ArrayList<Collect>();
			for(Map<String,Object> map:list){
				Collect collect=new Collect();
				
				collect.setGoodsID((int) map.get("GoodsID"));
				collect.setGoodsType((String) map.get("GoodsType"));
				collect.setID((int) map.get("ID"));
				collect.setName((String) map.get("Name"));
				collect.setPriceNow((String) map.get("PriceNow"));
				collect.setUrl((String) map.get("Url"));
				
				listcollect.add(collect);
			}
			return listcollect;
		}else{
			return null;
		}
	}

}
