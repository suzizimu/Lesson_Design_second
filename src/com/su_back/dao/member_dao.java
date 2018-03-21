package com.su_back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.su_back.model.Log;
import com.su_back.model.Member;
import com.su_back.util.DBUtil;

public class member_dao {
	/**
	 * 添加用户
	 * @param member
	 */
      public void add_member(Member member){
    	  String sql="insert into member(MemberName,PassWord,Sex,Email,Tel,Adress,AdressDetail,Url,CreatTime)values(?,?,?,?,?,?,?,?,?)";
          DBUtil.executeUpdate(sql, new Object[]{member.getMemberName(),member.getPassWord(),member.getSex(),member.getEmail(),member.getTel(),member.getAdress(),member.getAdressDetail(),member.getUrl(),member.getCreatTime()});
      }
      /**
       * 遍历用户列表
       * @return
       */
      public List<Member> list_member(){
    	  String sql="select * from member";
    	  List<Map<String, Object>> list=DBUtil.list(sql);
    	  
    	  if(list!=null&&list.size()!=0){
  			List<Member> listmember=new ArrayList<Member>();
  			for(Map<String, Object> map:list){
  				Member member=new Member();
  				 
  				member.setID((int) map.get("ID"));
  				member.setMemberName((String) map.get("MemberName"));
  				member.setPassWord((String) map.get("PassWord"));
  				member.setSex((String) map.get("Sex"));
  			    member.setEmail((String) map.get("Email"));
  			    member.setTel((String) map.get("Tel"));
  			    member.setAdress((String) map.get("Adress"));
  			    member.setAdressDetail((String) map.get("AdressDetail"));
  			    member.setUrl((String) map.get("Url"));
  				member.setCreatTime((String) map.get("CreatTime"));	 
  				
  				listmember.add(member);
  			}
  			return listmember;
  		}else{
  			return null;
  		}
  	
      }
      /**
  	 * 统计member_list数目
  	 * @return
  	 */
  	 public long member_count(){
  		String sql="select count(*) as num from member";
  		List<Map<String, Object>> list=DBUtil.list(sql);
  		long record=(long) list.get(0).get("num");
  		return record;		
  	}
  	/**
      * 判断添加是否账号重复
      * 冲突
      * @param member
      * @return
      */
     public int check_member(String name){
   	  String sql="select count(*) as num from member where MemberName=?";
   	  Map<String, Object> map=DBUtil.query(sql,name);
   	  int num=Integer.parseInt(map.get("num").toString()) ;
   	  return num;
     }
     
     /**
 	 * 删除用户
 	 * @param id
 	 */
 	public void delete_member(int id){
 		String sql="delete from member where id=?";
 		DBUtil.executeUpdate(sql, id);
 	}
 	/**
 	 * 进行member_list表删除用户后
 	 * 插入数据到member_del表中
 	 * @param id
 	 */
 	public void dellist_insert(int id){
 		//先接受id，进行查询 
 		String sql="select * from member where id=?";
   	    Map<String, Object> map=DBUtil.query(sql,id);
   	    if(map!=null&&map.size()!=0){
   		    Member member=new Member();
   		    
   		    member.setID((int) map.get("ID"));
			member.setMemberName((String) map.get("MemberName"));
			member.setPassWord((String) map.get("PassWord"));
			member.setSex((String) map.get("Sex"));
		    member.setEmail((String) map.get("Email"));
		    member.setTel((String) map.get("Tel"));
		    member.setAdress((String) map.get("Adress"));
		    member.setAdressDetail((String) map.get("AdressDetail"));
		    member.setUrl((String) map.get("Url"));
			member.setCreatTime((String) map.get("CreatTime"));	 
			
			//得到的member进行数据插入到member_del表中
			String sql1="insert into member_del(ID,MemberName,PassWord,Sex,Email,Tel,Adress,AdressDetail,Url,CreatTime)values(?,?,?,?,?,?,?,?,?,?)";
		    DBUtil.executeUpdate(sql1, new Object[]{member.getID(),member.getMemberName(),member.getPassWord(),member.getSex(),member.getEmail(),member.getTel(),member.getAdress(),member.getAdressDetail(),member.getUrl(),member.getCreatTime()});
		    
    	 }	   
    }
 	/**
 	 * 复原操作
 	 * 将数据插入到member表中
 	 * @param id
 	 */
 	public void list_insert(int id){
 		//先接受id，进行查询 
 		String sql="select * from member_del where id=?";
   	    Map<String, Object> map=DBUtil.query(sql,id);
   	    if(map!=null&&map.size()!=0){
   		    Member member=new Member();
   		    
   		    member.setID((int) map.get("ID"));
			member.setMemberName((String) map.get("MemberName"));
			member.setPassWord((String) map.get("PassWord"));
			member.setSex((String) map.get("Sex"));
		    member.setEmail((String) map.get("Email"));
		    member.setTel((String) map.get("Tel"));
		    member.setAdress((String) map.get("Adress"));
		    member.setAdressDetail((String) map.get("AdressDetail"));
		    member.setUrl((String) map.get("Url"));
			member.setCreatTime((String) map.get("CreatTime"));	 
			
			//得到的member进行数据插入到member_del表中
			String sql1="insert into member(ID,MemberName,PassWord,Sex,Email,Tel,Adress,AdressDetail,Url,CreatTime)values(?,?,?,?,?,?,?,?,?,?)";
		    DBUtil.executeUpdate(sql1, new Object[]{member.getID(),member.getMemberName(),member.getPassWord(),member.getSex(),member.getEmail(),member.getTel(),member.getAdress(),member.getAdressDetail(),member.getUrl(),member.getCreatTime()});
		    
    	 }	   
    }
 	/**
 	 * 删除
 	 * 被删除的用户列表信息
 	 * @param id
 	 */
 	public void delete_member_del(int id){
 		String sql="delete from member_del where id=?";
 		DBUtil.executeUpdate(sql, id);
 	}
 	/**
     * 遍历删除的用户列表
     * @return
     */
    public List<Member> dellist_member(){
  	  String sql="select * from member_del";
  	  List<Map<String, Object>> list=DBUtil.list(sql);
  	  
  	  if(list!=null&&list.size()!=0){
			List<Member> listmember=new ArrayList<Member>();
			for(Map<String, Object> map:list){
				Member member=new Member();
				 
				member.setID((int) map.get("ID"));
				member.setMemberName((String) map.get("MemberName"));
				member.setPassWord((String) map.get("PassWord"));
				member.setSex((String) map.get("Sex"));
			    member.setEmail((String) map.get("Email"));
			    member.setTel((String) map.get("Tel"));
			    member.setAdress((String) map.get("Adress"));
			    member.setAdressDetail((String) map.get("AdressDetail"));
			    member.setUrl((String) map.get("Url"));
				member.setCreatTime((String) map.get("CreatTime"));	 
				
				listmember.add(member);
			}
			return listmember;
		}else{
			return null;
		}
	
    }
    /**
  	 * 统计member_list_delete数目
  	 * @return
  	 */
  	 public long dellist_count(){
  		String sql="select count(*) as num from member_del";
  		List<Map<String, Object>> list=DBUtil.list(sql);
  		long record=(long) list.get(0).get("num");
  		return record;		
  	}
 	/**
 	 * 用户修改密码第一步
 	 * @param id
 	 * @return
 	 */
 	public Member loadquery(int id){
 		String sql="select * from member where id=?";
		Map<String,Object> map=DBUtil.query(sql, id);
		
		if(map!=null&&map.size()!=0){
			Member member=new Member();
			member.setID((int) map.get("ID"));
			member.setMemberName((String) map.get("MemberName"));
			return member;		   
	   }else{
		   return null;
			
		}
 		
 	}
 	/**
     * 判断旧密码验证
     * 冲突
     * @param member
     * @return
     */
    public int check_pwd(String name,String pwd){
  	  String sql="select count(*) as num from member where MemberName=? and PassWord=?";
  	  Map<String, Object> map=DBUtil.query(sql,new Object[]{name,pwd});
  	  int num=Integer.parseInt(map.get("num").toString()) ;
  	  return num;
    }
    /**
	 * 修改密码操作第二步 
	 * @param admin
	 */
	public void updatePWD(Member member){
		String sql="update member set PassWord=? where id=?";
		DBUtil.executeUpdate(sql,new Object[]{member.getPassWord(),member.getID()});
	}
	/**
	 * 查看用户详情信息
	 * @param id
	 * @return
	 */
	public Member member_detail(int id){
		String sql="select * from member where id=?";
		Map<String, Object> map=DBUtil.query(sql, id);
   	    if(map!=null&&map.size()!=0){
   		    Member member=new Member();
   		    
   		    member.setID((int) map.get("ID"));
			member.setMemberName((String) map.get("MemberName"));
			member.setPassWord((String) map.get("PassWord"));
			member.setSex((String) map.get("Sex"));
		    member.setEmail((String) map.get("Email"));
		    member.setTel((String) map.get("Tel"));
		    member.setAdress((String) map.get("Adress"));
		    member.setAdressDetail((String) map.get("AdressDetail"));
		    member.setUrl((String) map.get("Url"));
			member.setCreatTime((String) map.get("CreatTime"));	 
			
			return member;
   	    }else{
   	    	return null;
   	    }
	}
	/**
	 * 修改用户信息
	 * @param member
	 */
	public void update_member(Member member){
		String sql="update member set sex=?,email=?,tel=?,adress=?,adressdetail=?,url=? where id=?";
		DBUtil.executeUpdate(sql,new Object[]{member.getSex(),member.getEmail(),member.getTel(),member.getAdress(),member.getAdressDetail(),member.getUrl(),member.getID()});
	}
 	/**
 	 * 模糊查询
 	 * @param name
 	 * @param date1
 	 * @param date2
 	 * @return
 	 */
    public List<Member> select_member(String name,String date1,String date2){
    	String sql="select * from member where 1=1";
    	if((date1!=null&&(!date1.trim().equals(""))&&(date2!=null&&(!date2.trim().equals(""))))){
     	   sql=sql+" and CreatTime between '"+date1+"' and '"+date2+"'";        
       }
    	if(name!=null&&(!name.trim().equals(""))){
    		sql=sql+" and MemberName like '%"+name+"%'";
    	}
    	
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	
    	if(list!=null&&list.size()!=0){
  			List<Member> listmember=new ArrayList<Member>();
  			for(Map<String, Object> map:list){
  				Member member=new Member();
  				 
  				member.setID((int) map.get("ID"));
  				member.setMemberName((String) map.get("MemberName"));
  				member.setPassWord((String) map.get("PassWord"));
  				member.setSex((String) map.get("Sex"));
  			    member.setEmail((String) map.get("Email"));
  			    member.setTel((String) map.get("Tel"));
  			    member.setAdress((String) map.get("Adress"));
  			    member.setAdressDetail((String) map.get("AdressDetail"));
  			    member.setUrl((String) map.get("Url"));
  				member.setCreatTime((String) map.get("CreatTime"));	 
  				
  				listmember.add(member);
  			}
  			return listmember;
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
