package com.su_front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Goods;
import com.su_front.service.goods_service;

/**
 * Servlet implementation class select_goods
 */
@WebServlet("/select_goods.so")
public class select_goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public select_goods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName=request.getParameter("goodsName");
		
		goods_service gs=new goods_service();
		try {
			List<Goods> list=gs.select_goods(goodsName);
			
			request.setAttribute("list",list);
			request.getRequestDispatcher("Front/F_select_goods.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Front/404.jsp").forward(request, response);;
		}
	}

}
