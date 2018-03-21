package com.su_front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Goods;
import com.su_front.model.View;
import com.su_front.service.goods_service;
import com.su_front.service.view_service;

/**
 * Servlet implementation class product_detail
 */
@WebServlet("/goods_detail.so")
public class goods_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goods_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String name=(String) request.getSession().getAttribute("member_name");
		
		goods_service gs=new goods_service();
		view_service  vs=new view_service();
		try {
			Goods goods=gs.detail(id);
			gs.click_goods(id);
	        vs.add_view(Integer.parseInt(id), name);
	        List<View> list=vs.list_view(name);
	        
			request.getSession().setAttribute("goods_id",id);
			request.setAttribute("goods",goods);
			request.setAttribute("list",list);
			request.getRequestDispatcher("Front/F_product-details.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Front/404.jsp").forward(request, response);
		}
		
		
	}

}
