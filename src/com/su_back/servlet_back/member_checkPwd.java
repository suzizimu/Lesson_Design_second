package com.su_back.servlet_back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.su_back.dao.member_dao;

/**
 * Servlet implementation class member_checkPwd
 */
@WebServlet("/member_checkPwd.do")
public class member_checkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_checkPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("member_name");
        String pwd=request.getParameter("param");
        
    	System.out.println(name+"******"+pwd);
    	
    	Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	   	        
    	member_dao md=new member_dao();
        int num=md.check_pwd(name, pwd);
        
        Map<String,String> map = new HashMap<String, String>();
        if (num>0) {
			map.put("info", "旧密码验证正确");
			map.put("status", "y");
		}else {
			map.put("info", "旧密码验证错误");
			map.put("status", "n");
		}
        
        String jsonmp=gson.toJson(map);
	    out.write(jsonmp);
		
	    out.flush();
		out.close();
	}

}
