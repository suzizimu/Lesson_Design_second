package com.su_front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_front.service.login_service;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.so")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    
	    System.out.println(username+"***"+password);
	    login_service ls=new login_service();
	    try {
			ls.query(username, password);
			
			request.getSession().setAttribute("member_name",username);
			request.getSession().setAttribute("password", password);
			request.getRequestDispatcher("Front/F_home.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Front/F_login.jsp").forward(request, response);
		}
	}

}
