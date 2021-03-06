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
import com.su_back.service.reply_service;

/**
 * Servlet implementation class reply_delete
 */
@WebServlet("/reply_delete.do")
public class reply_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String id=request.getParameter("reply_id");
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
		log.setDs("在"+sdf.format(date)+"进行了删除回复操作");
		log.setName(name);
		log.setType("删除");
	    
	    reply_service rs=new reply_service();
        Map<String,Object> mp=new HashMap<String,Object>();
        try {       	
        	rs.delete_reply(Integer.parseInt(id));
        	rs.log(log);
			
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
