package com.su_front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_front.service.car_service;

/**
 * Servlet implementation class car_add
 */
@WebServlet("/car_add.so")
public class car_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public car_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String name=(String) request.getSession().getAttribute("member_name");
		
		if(name==null){
			 response.sendRedirect("Front/F_login.jsp");
		}else{
			car_service cs=new car_service();
			try {
				cs.add_car(Integer.parseInt(id), name);
				response.sendRedirect("Front/F_home.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Front/F_404.jsp").forward(request, response);
			}
		}
		
		
	}

}
