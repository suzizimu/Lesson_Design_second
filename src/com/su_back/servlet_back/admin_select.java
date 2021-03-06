package com.su_back.servlet_back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Admin;
import com.su_back.model.Log;
import com.su_back.service.admin_service;

/**
 * Servlet implementation class admin_select
 */
@WebServlet("/admin_select.do")
public class admin_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("admin_name");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		
		System.out.println(name+"****"+date1+"****"+date2);
		
		 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name1=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了查询管理员操作");
		log.setName(name1);
		log.setType("查询");
		
		admin_service as=new admin_service();
		try {
			List<Admin> list=as.select_admin(name, date1, date2);
			long record=as.admin_count();
			as.log(log);
			
			request.setAttribute("list",list);
			request.setAttribute("record", record);
			request.getRequestDispatcher("Back/A_admin_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
