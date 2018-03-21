package com.su_front.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Member;
import com.su_back.model.Orders;
import com.su_front.service.orders_service;

/**
 * Servlet implementation class pay_add
 */
@WebServlet("/pay_add.so")
public class pay_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pay_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberName=(String) request.getSession().getAttribute("member_name");
		orders_service os=new orders_service();
		try {
			Member member=os.info_member(memberName);
			
			request.setAttribute("member",member);
			request.getRequestDispatcher("Front/F_pay_information.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Front/404.jsp").forward(request, response);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idAll=(String) request.getSession().getAttribute("idAll");//根据购物车传过来的    商品ID集合
		String idAll2=(String) request.getSession().getAttribute("idAll2");//根据购物车传过来的  购物车ID集合
				
		//公共信息  不变
		String memberName=request.getParameter("memberName");
		String tel=request.getParameter("tel");
		String adress=request.getParameter("adress");
		String adressDetail=request.getParameter("adressDetail");
		//-----------------------------
        Orders orders=new Orders();
        orders.setMemberName(memberName);
        orders.setTel(tel);
        orders.setAdress(adress);
        orders.setAdressDetail(adressDetail);
               
		orders_service os=new orders_service();
		try {
			String[] id = idAll.split(",");//用逗号切割
			String[] id2=idAll2.split(",");
			for(int i=0;i<id.length;i++){
				String orderNum =UUID.randomUUID().toString(); //自动生成订单表编号
				
				os.add_orders(Integer.parseInt(id[i]),orders,orderNum);//根据单个商品id生成订单
				os.delete_car(Integer.parseInt(id2[i]));//订单成后，删除购物车的商品
			}
			response.sendRedirect("Front/F_shopping-cart.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
		
	}

}
