package com.su_front.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Reply;
import com.su_front.service.reply_service;

/**
 * Servlet implementation class reply_list_front
 */
@WebServlet("/reply_list_front.so")
public class reply_list_front extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply_list_front() {
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
			reply_service rs=new reply_service();
			try {
				List<Reply> list=rs.reply_list(name);
				
				request.setAttribute("list",list);
				request.getRequestDispatcher("Front/R_reply_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
		        request.getRequestDispatcher("Front/404.jsp").forward(request, response);
			}
		}
		
	}

}
