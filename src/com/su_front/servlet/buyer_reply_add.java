package com.su_front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_front.model.Buyer_reply;
import com.su_front.service.buyer_reply_service;

/**
 * Servlet implementation class buyer_reply_add
 */
@WebServlet("/buyer_reply_add.so")
public class buyer_reply_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyer_reply_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		
		buyer_reply_service bs=new buyer_reply_service();
		try {
			Buyer_reply buyer_reply=bs.update1(Integer.parseInt(id));
			
			request.setAttribute("buyer_reply",buyer_reply);
			request.getRequestDispatcher("Front/B_buyer_reply.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=(String) request.getSession().getAttribute("member_name");
		
		String orderNum=request.getParameter("orderNum");
		String goodsID=request.getParameter("goodsID");
		String goodsName=request.getParameter("goodsName");
		String seller=request.getParameter("seller");
		String memberName=request.getParameter("memberName");
		String introduce=request.getParameter("introduce");
		String date=request.getParameter("date");
		
		Buyer_reply buyer_reply=new Buyer_reply();
		buyer_reply.setDate(date);
		buyer_reply.setGoodsID(Integer.parseInt(goodsID));
		buyer_reply.setGoodsName(goodsName);
		buyer_reply.setIntroduce(introduce);
		buyer_reply.setMemberName(memberName);
		buyer_reply.setOrderNum(orderNum);
		buyer_reply.setSeller(seller);
		
		buyer_reply_service bs=new buyer_reply_service();
		try {
			bs.buyer_reply(buyer_reply,name);
			
			response.sendRedirect("Back/Public_add_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
