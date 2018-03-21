package com.su_back.servlet_back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Reply;
import com.su_back.service.reply_service;

/**
 * Servlet implementation class reply_select
 */
@WebServlet("/reply_select.do")
public class reply_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminName=request.getParameter("adminName");
		String memberName=request.getParameter("memberName");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		
		
		reply_service rs=new reply_service();
		try {
			List<Reply> list=rs.select_reply(adminName, memberName, date1, date2);
			long record=rs.reply_count();
			
			request.setAttribute("list",list);
			request.setAttribute("record", record);
			request.getRequestDispatcher("Back/R_reply_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);	e.printStackTrace();
		}
	}

}
