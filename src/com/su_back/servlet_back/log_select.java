package com.su_back.servlet_back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Log;
import com.su_back.service.log_service;

/**
 * Servlet implementation class log_select
 */
@WebServlet("/log_select.do")
public class log_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		
		log_service ls=new log_service();
		try {
			List<Log> list=ls.select_news(type, date1, date2, name);
			long record=ls.log_count();
			
			request.setAttribute("list",list);
			request.setAttribute("record",record);
			request.getRequestDispatcher("Back/L_log_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
