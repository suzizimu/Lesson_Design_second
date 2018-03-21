package com.su_back.servlet_back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.su_back.service.adress_service;


/**
 * Servlet implementation class loadcity
 */
@WebServlet("/ldcity.do")
public class loadcity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadcity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//String sql="select city_id,city_name from city where province_id="+pro_id;	
		//List<Map<String, Object>> lm=DBUtil.list(sql);
		String pro_id=request.getParameter("pro_id");
		adress_service as=new adress_service();
		try {
			List<Map<String, Object>> lm = as.list_city(pro_id);
	
			Gson gson=new Gson();
			String listc=gson.toJson(lm);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.write(listc);
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
