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
import com.su_back.service.login_service;

/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login.do")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String username=request.getParameter("username");
		    String password=request.getParameter("pwd");
		    String code=request.getParameter("code");
		    String rCode= (String) request.getSession().getAttribute("rCode");
		    System.out.println(rCode);
					
			if(("").equals(username.trim())||("").equals(password.trim())){
	    		request.setAttribute("msg", "账号或密码不能为空");
	    		request.getRequestDispatcher("Back/login.jsp").forward(request, response);
	    	}
			if(("").equals(code.trim())){
	    		request.setAttribute("msg", "验证不能为空");
	    		request.getRequestDispatcher("Back/login.jsp").forward(request, response);
	    	}
			
			 /**
		 	* 获取时间
		 	*/
		 	Date date =new Date();
		 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 	//sdf.format(date);
		 	
			Log log=new Log();
			log.setDate(sdf.format(date));
			log.setDs("在"+sdf.format(date)+"进行了登录操作");
			log.setName(username);
			log.setType("登录");
			
			
	    	if((code.toUpperCase()).equals(rCode)){//解决验证码大小写问题
	    		try {	    			
	    			login_service ls=new login_service();
	    			System.out.println(username+"===="+password);
	    			ls.query(username, password);
	    			ls.update(username);
	    			ls.log(log);
	    			
	    			request.getSession().setAttribute("admin_name",username);
	    			request.getSession().setAttribute("password",password);
	    			request.getRequestDispatcher("Back/index.jsp").forward(request, response);
	    			
					} catch(Exception e){ 
						request.setAttribute("msg",e.getMessage());
						request.getRequestDispatcher("Back/login.jsp").forward(request, response);
					}   		
		    }else{
		    	request.setAttribute("msg", "验证码错误");
		    	request.getRequestDispatcher("Back/login.jsp").forward(request, response);
		    }	    				
	}
}
