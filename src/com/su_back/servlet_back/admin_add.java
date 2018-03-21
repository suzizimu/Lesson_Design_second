package com.su_back.servlet_back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Admin;
import com.su_back.model.Log;
import com.su_back.service.admin_service;

/**
 * Servlet implementation class admin_add
 */
@WebServlet("/admin_add.do")
public class admin_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_add() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String username=request.getParameter("username");
    	String password=request.getParameter("newpassword");
    	String sex=request.getParameter("sex");
    	String creattime=request.getParameter("creattime");
    	  	
    	Admin admin=new Admin();
    	admin.setName(username);
    	admin.setPassWord(password);
    	admin.setSex(sex);
    	admin.setCreatTime(creattime);
    	
		 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
	 	String name=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了添加管理员操作");
		log.setName(name);
		log.setType("添加");
		
    	admin_service as=new admin_service();   	   	
    	try {   		
			as.add_admin(admin);
			as.log(log);
             
			response.sendRedirect("Back/Public_add_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/A_admin_add.jsp").forward(request, response);
		}
    	
    	
    }
	
}
