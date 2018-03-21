package com.su_front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Report;
import com.su_front.service.report_service;

/**
 * Servlet implementation class report_add
 */
@WebServlet("/report_add.so")
public class report_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public report_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsID=request.getParameter("id");//获取商品ID
		String memberName=(String) request.getSession().getAttribute("member_name");
		
		if(memberName==null){
			response.sendRedirect("Front/F_login.jsp");
		}else{
			report_service rs=new report_service();
			try {
				Report report=rs.add_report(Integer.parseInt(goodsID), memberName);
				
				request.setAttribute("report",report);
				request.getRequestDispatcher("Front/F_report.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
		        request.getRequestDispatcher("Front/404.jsp").forward(request, response);
			}		
		}							
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberName=request.getParameter("memberName");
		String goodsID=request.getParameter("goodsID");
		String goodsName=request.getParameter("goodsName");
		String tel=request.getParameter("tel");
		String introduce=request.getParameter("introduce");
		String date=request.getParameter("date");
		
		Report report=new Report();
		report.setDate(date);
		report.setGoodsID(Integer.parseInt(goodsID));
		report.setGoodsName(goodsName);
		report.setIntroduce(introduce);
		report.setMemberName(memberName);
		report.setTel(tel);
		
		report_service rs=new report_service();
		try {
			rs.insert_report(report);
			
			response.sendRedirect("Front/F_home.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
	        request.getRequestDispatcher("Front/404.jsp").forward(request, response);
		}
		
		
	}

}
