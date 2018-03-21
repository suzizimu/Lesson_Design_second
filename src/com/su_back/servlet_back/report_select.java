package com.su_back.servlet_back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Report;
import com.su_back.service.report_service;

/**
 * Servlet implementation class report_select
 */
@WebServlet("/report_select.do")
public class report_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public report_select() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		
		report_service rs=new report_service();
		try {
			List<Report> list=rs.select_report(name, date1, date2);
			long record=rs.report_count();
			
			request.setAttribute("list",list);
			request.setAttribute("record",record);
			request.getRequestDispatcher("Back/R_report_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
