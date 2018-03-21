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
import com.su_back.service.reply_service;

/**
 * Servlet implementation class reply_deleteMore
 */
@WebServlet("/reply_deleteMore.do")
public class reply_deleteMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply_deleteMore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  idAll=(String) request.getParameter("idAll");		
		System.out.println("++++++++++++++++");
	
		 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了批量删除回复操作");
		log.setName(name);
		log.setType("删除");
		
		reply_service rs=new reply_service();	
			try {
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					rs.delete_reply(Integer.parseInt(id[i]));//根据id删除
				}
				rs.log(log);
				
				response.sendRedirect("Back/R_reply_delMore.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
		        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
			}
	}

}
