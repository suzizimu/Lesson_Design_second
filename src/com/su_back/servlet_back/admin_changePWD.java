package com.su_back.servlet_back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su_back.model.Admin;
import com.su_back.model.Log;
import com.su_back.service.admin_service;

/**
 * Servlet implementation class admin_changePWD
 */
@WebServlet("/admin_pwd.do")
public class admin_changePWD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_changePWD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
        
		/**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了修改管理员密码操作");
		log.setName(name);
		log.setType("修改");
		
		admin_service as=new admin_service();
		try {
			Admin admin=as.loadquery(Integer.parseInt(id));
			as.log(log);
			
			request.setAttribute("admin",admin);
			request.getRequestDispatcher("Back/A_admin_changePwd.jsp").forward(request, response);
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
		
		Admin admin=new Admin();
		admin.setID(Integer.parseInt(id));
		admin.setPassWord(password);
		
		admin_service as=new admin_service();
		try {
			as.updatePWD(admin);
			response.sendRedirect("Back/Public_change_reload.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/A_admin_changePwd.jsp").forward(request, response);
		}
	}

}
