package com.su_back.service;

import java.util.List;
import java.util.Map;

import com.su_back.dao.adress_dao;


public class adress_service {
	adress_dao ad=new adress_dao();
    
	public List<Map<String, Object>> list_province() throws Exception{
		try {
			return ad.list_province(); 
		} catch (Exception e) {
			throw new Exception("省份列表的失败原因是："+e.getMessage());
		}
		
	}
	
	public List<Map<String, Object>> list_city(String province_id) throws Exception{
		try {
			return ad.list_city(province_id); 
		} catch (Exception e) {
			throw new Exception("城市列表的失败原因是："+e.getMessage());
		}
		
	}
	
	public List<Map<String, Object>> list_area(String city_id) throws Exception{
		try {
			return ad.list_area(city_id); 
		} catch (Exception e) {
			throw new Exception("地区列表的失败原因是："+e.getMessage());
		}
		
	}

}
