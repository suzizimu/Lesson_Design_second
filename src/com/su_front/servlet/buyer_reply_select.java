package com.su_front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_front.model.Buyer_reply;
import com.su_front.service.buyer_reply_service;

/**
 * Servlet implementation class buyer_reply_select
 */
@WebServlet("/buyer_reply_select.so")
public class buyer_reply_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyer_reply_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName=request.getParameter("goodsName");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		
		buyer_reply_service bs=new buyer_reply_service();
		try {
			List<Buyer_reply> list=bs.select_buyer_reply(goodsName, date1, date2);
			
			request.setAttribute("list",list);
			request.getRequestDispatcher("Front/B_buyer_reply_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
