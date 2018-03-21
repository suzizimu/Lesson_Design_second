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
import com.su_back.model.Member;
import com.su_back.service.member_service;

/**
 * Servlet implementation class member_changePWD
 */
@WebServlet("/member_pwd.do")
public class member_changePWD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_changePWD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println("===========");
		System.out.println(id);
		
		member_service ms=new member_service();
		try {
			Member member=ms.loadquery(Integer.parseInt(id));
			request.setAttribute("member",member);
			request.getRequestDispatcher("Back/M_member_changePwd.jsp").forward(request, response);
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
		String id=request.getParameter("id");
		System.out.println("---------");
		System.out.println(id);
		String password=request.getParameter("new-password");
		
		Member member=new Member();
		member.setID(Integer.parseInt(id));
		member.setPassWord(password);
		
		 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name1=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了修改用户密码操作");
		log.setName(name1);
		log.setType("修改");
		
		member_service ms=new member_service();
		try {
			ms.updatePWD(member);
			ms.log(log);
			
			response.sendRedirect("Back/Public_change_reload.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/M_member_changePwd.jsp").forward(request, response);
		}
	}

}
