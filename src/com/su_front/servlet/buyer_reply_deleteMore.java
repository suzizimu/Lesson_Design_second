package com.su_front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.su_front.service.buyer_reply_service;

/**
 * Servlet implementation class buyer_reply_deleteMore
 */
@WebServlet("/buyer_reply_deleteMore.so")
public class buyer_reply_deleteMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyer_reply_deleteMore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  idAll=(String) request.getParameter("idAll");		
		System.out.println("++++++++++++++++");
	
		buyer_reply_service bs=new buyer_reply_service();	
			try {
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					bs.delete_buyer_reply(Integer.parseInt(id[i]));//根据id删除
				}
	
				response.sendRedirect("Front/B_buyer_reply_delMore.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
		        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
			}
	}

}
