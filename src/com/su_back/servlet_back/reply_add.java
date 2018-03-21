package com.su_back.servlet_back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Log;
import com.su_back.model.Reply;
import com.su_back.model.Report;
import com.su_back.service.reply_service;
import com.su_back.service.report_service;

/**
 * Servlet implementation class reply_add
 */
@WebServlet("/reply_add.do")
public class reply_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		report_service rs=new report_service();
		try {
			Report  report=rs.report_reply(Integer.parseInt(id));
			
			request.setAttribute("report",report);
			request.getRequestDispatcher("Back/R_report_reply.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberName=request.getParameter("member_name");
		String adminName=request.getParameter("admin_name");
		String date=request.getParameter("date");
		String introduce=request.getParameter("introduce");
		String goodsID=request.getParameter("goodsID");
		
		Reply reply=new Reply();
		reply.setAdminName(adminName);
		reply.setDate(date);
		reply.setIntroduce(introduce);
		reply.setMemberName(memberName);
		reply.setGoodsID(Integer.parseInt(goodsID));
		
		 /**
	 	* 获取时间
	 	*/
	 	Date date1 =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name1=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date1));
		log.setDs("在"+sdf.format(date1)+"进行了添加回复操作");
		log.setName(name1);
		log.setType("添加");
		
		reply_service rs=new reply_service();
		try {
			rs.insert_reply(reply);
			rs.log(log);
			
			response.sendRedirect("Back/Public_add_reload.jsp");		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
