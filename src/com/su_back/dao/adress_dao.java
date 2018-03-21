package com.su_back.dao;

import java.util.List;
import java.util.Map;

import com.su_back.util.DBUtil;

public class adress_dao {
	public  List<Map<String, Object>> list_province(){
		String sql="select province_id,province_name from province";
		List<Map<String, Object>> lm=DBUtil.list(sql);
		return lm;
	}
	
	public  List<Map<String, Object>> list_city(String province_id){
		String sql="select city_id,city_name from city where province_id=?";
		List<Map<String, Object>> lm=DBUtil.list(sql,province_id);
		return lm;
	}
    
	
	public  List<Map<String, Object>> list_area(String city_id){
		String sql="select area_id,area_name from area where city_id=?";
		List<Map<String, Object>> lm=DBUtil.list(sql,city_id);
		return lm;
	}
	
	
}
