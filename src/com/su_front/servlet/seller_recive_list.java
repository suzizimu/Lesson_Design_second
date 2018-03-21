package com.su_front.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_front.model.Buyer_reply;
import com.su_front.service.seller_recive_service;

/**
 * Servlet implementation class seller_recive_list
 */
@WebServlet("/seller_recive_list.so")
public class seller_recive_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seller_recive_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=(String) request.getSession().getAttribute("member_name");
		
		if(name==null){
		    PrintWriter out = response.getWriter();  
	        out.println("<html>");      
	        out.println("<script>");      
	        out.println("window.open ('"+request.getContextPath()+"/Front/F_login.jsp','_top')");      
	        out.println("</script>");      
	        out.println("</html>");            	        
		}else{
			seller_recive_service ss=new seller_recive_service();
			try {
				List<Buyer_reply> list=ss.seller_list(name);
				
				request.setAttribute("list",list);
				request.getRequestDispatcher("Front/S_seller_recive_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}
  
  }
}
