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
 * Servlet implementation class loadaera
 */
@WebServlet("/ldarea.do")
public class loadaera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadaera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//String sql="select area_id,area_name from area where city_id="+city_id;		
		//List<Map<String, Object>> lm=DBUtil.list(sql);
		String city_id=request.getParameter("city_id");	
		
		adress_service as=new adress_service();
		try {
			List<Map<String, Object>>	lm = as.list_area(city_id);
			
			Gson gson=new Gson();
			String listd=gson.toJson(lm);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.write(listd);
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
