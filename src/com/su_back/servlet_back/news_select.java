package com.su_back.servlet_back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Log;
import com.su_back.model.News;
import com.su_back.service.news_service;

/**
 * Servlet implementation class news_select
 */
@WebServlet("/news_select.do")
public class news_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public news_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		String title=request.getParameter("title");
		
		System.out.println("**********");
		System.out.println(type+"=="+date1+"=="+date2+"=="+title);
		 /**
	 	* 获取时间
	 	*/
	 	Date date11 =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name1=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date11));
		log.setDs("在"+sdf.format(date11)+"进行了查询资讯操作");
		log.setName(name1);
		log.setType("查询");
		
		news_service ns=new news_service();
		try {
			List<News> list=ns.select_news(type, date1, date2, title);
			long record=ns.news_count();
			ns.log(log);
			
			request.setAttribute("list",list);
			request.setAttribute("record", record);
			request.getRequestDispatcher("Back/N_news_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
