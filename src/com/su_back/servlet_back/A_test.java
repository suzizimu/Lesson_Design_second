package com.su_back.servlet_back;

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

/**
 * Servlet implementation class A_test
 */
@WebServlet("/A_test.do")
public class A_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public A_test() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void service( HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException {
		int number=25;
		System.out.println(number);
		//request.get
		//-------------
		Gson gson=new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//-------------
		Map<String,Object> mp=new HashMap<String,Object>();
		mp.put("info",number);
		mp.put("status", "y");
		String jsonmp=gson.toJson(mp);
		out.write(jsonmp);

		out.flush();
		out.close();
	}
}
