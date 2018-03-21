package com.su_front.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_front.service.collect_service;

/**
 * Servlet implementation class collect_add
 */
@WebServlet("/collect_add.so")
public class collect_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public collect_add() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String id=request.getParameter("id");
    	String name=(String) request.getSession().getAttribute("member_name");  
    	
    	System.out.println(id+"************"+name);
    	//-------------
//    	Gson gson=new Gson();
//		response.setContentType("text/html;charset=utf-8");
//	    PrintWriter out=response.getWriter();       
        //-------------
    	
//    	Map<String,Object> mp=new HashMap<String,Object>();
    	if(name==null){
			 response.sendRedirect("Front/F_login.jsp");
			 
		}else{
			collect_service cs=new collect_service();
			try {
				cs.add_collect(Integer.parseInt(id), name);
				
//				mp.put("info","收藏成功");
//				mp.put("status", "y");
//				String jsonmp=gson.toJson(mp);
//				out.write(jsonmp);
	//
//			    out.flush();
//				out.close();
			
			    //response.sendRedirect("Front/Public_collect_reload.jsp");
				
			    response.sendRedirect("Front/F_home.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Front/F_404.jsp").forward(request, response);
			}
		}
    	
        
    }

}
