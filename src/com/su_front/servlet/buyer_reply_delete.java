package com.su_front.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.su_front.service.buyer_reply_service;

/**
 * Servlet implementation class buyer_reply_delete
 */
@WebServlet("/buyer_reply_delete.so")
public class buyer_reply_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyer_reply_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String id=request.getParameter("buyer_reply_id");
    	System.out.println(id);    	
    	//-------------
    	Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();       
        //-------------
	    
	    buyer_reply_service bs=new buyer_reply_service();
        Map<String,Object> mp=new HashMap<String,Object>();
        try {       	
        	bs.delete_buyer_reply(Integer.parseInt(id));
        			
			mp.put("info","删除成功");
			mp.put("status", "y");
			String jsonmp=gson.toJson(mp);
			out.write(jsonmp);

		    out.flush();
			out.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
