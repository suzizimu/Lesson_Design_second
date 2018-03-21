package com.su_front.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Orders;
import com.su_front.service.orders_service;

/**
 * Servlet implementation class orders_list_front
 */
@WebServlet("/orders_list_front.so")
public class orders_list_front extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orders_list_front() {
        super();
        // TODO Auto-generated constructor stub
    }
    ///////买
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=(String) request.getSession().getAttribute("member_name");
		System.out.println(name+"************");
		
		if(name==null){
		    PrintWriter out = response.getWriter();  
	        out.println("<html>");      
	        out.println("<script>");      
	        out.println("window.open ('"+request.getContextPath()+"/Front/F_login.jsp','_top')");      
	        out.println("</script>");      
	        out.println("</html>");  
		}else{
			orders_service os=new orders_service();
			try {
				List<Orders> list=os.list_orders(name);		
							
				request.setAttribute("list",list);
				request.getRequestDispatcher("Front/O_orders_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Back/404.jsp").forward(request, response);
			}
		}
		
	}

}
