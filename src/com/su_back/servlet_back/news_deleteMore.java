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
import com.su_back.service.news_service;

/**
 * Servlet implementation class news_deleteMore
 */
@WebServlet("/news_deleteMore.do")
public class news_deleteMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public news_deleteMore() {
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
	 	Date date1 =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name1=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date1));
		log.setDs("在"+sdf.format(date1)+"进行了批量删除资讯操作");
		log.setName(name1);
		log.setType("删除");
		
		news_service ns=new news_service();	
			try {
				String[] id = idAll.split(",");//用逗号切割
				for(int i=0;i<id.length;i++){
					ns.delete_news(Integer.parseInt(id[i]));//根据id删除
				}
				ns.log(log);
				
				response.sendRedirect("Back/N_news_delMore.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
		        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
			}
	}

}
