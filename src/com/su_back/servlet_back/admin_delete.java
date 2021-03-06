package com.su_back.servlet_back;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.su_back.model.Log;
import com.su_back.service.admin_service;

/**
 * Servlet implementation class admin_delete
 */
@WebServlet("/admin_delete.do")
public class admin_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_delete() {
        super();
        // TODO Auto-generated constructor stub
    }
     
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
        String id=request.getParameter("admin_id");
    	System.out.println(id);    	
    	//-------------
    	Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();       
        //-------------
		 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了删除管理员操作");
		log.setName(name);
		log.setType("删除");
	    
	    admin_service as=new admin_service();
        Map<String,Object> mp=new HashMap<String,Object>();
        try {       	
			as.delete_admin(Integer.parseInt(id));
			as.log(log);
			
			mp.put("info","删除成功");
			mp.put("status", "y");
			String jsonmp=gson.toJson(mp);
			out.write(jsonmp);

		    out.flush();
			out.close();
			
			//response.sendRedirect("/Lesson_Design_second/admin_list.do");
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
    }	
}
