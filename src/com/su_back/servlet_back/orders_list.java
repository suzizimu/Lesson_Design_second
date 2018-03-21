package com.su_back.servlet_back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Orders;
import com.su_back.service.orders_service;

/**
 * Servlet implementation class orders_list
 */
@WebServlet("/orders_list.do")
public class orders_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orders_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String name=(String) request.getSession().getAttribute("admin_name");
		
		if(name==null){
		    PrintWriter out = response.getWriter();  
	        out.println("<html>");      
	        out.println("<script>");      
	        out.println("window.open ('"+request.getContextPath()+"/Back/login.jsp','_top')");      
	        out.println("</script>");      
	        out.println("</html>");            	        
		}else{
			orders_service os=new orders_service();
			try {
				List<Orders> list=os.list_orders();
				long record=os.orders_count();
				
				request.setAttribute("record",record);
				request.setAttribute("list",list);
				request.getRequestDispatcher("Back/O_orders_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Back/404.jsp").forward(request, response);
			}
		}
		
		
		
	}

}
