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
 * Servlet implementation class member_check
 */
@WebServlet("/member_check.do")
public class member_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_check() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name=request.getParameter("param");
    	
    	Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	   	        
    	member_dao md=new member_dao();
        int num=md.check_member(name);
        
        Map<String,String> map = new HashMap<String, String>();
        if (num>0) {
			map.put("info", "系统中已经存在该名称");
			map.put("status", "n");
		}else {
			map.put("info", "该名称可用");
			map.put("status", "y");
		}
        
        String jsonmp=gson.toJson(map);
	    out.write(jsonmp);
		
	    out.flush();
		out.close();
	}

}
