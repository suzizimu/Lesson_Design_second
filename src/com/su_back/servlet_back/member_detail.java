package com.su_back.servlet_back;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.su_back.model.Log;
import com.su_back.model.Member;
import com.su_back.service.member_service;

/**
 * Servlet implementation class member_detail
 */
@WebServlet("/member_detail.do")
@MultipartConfig
public class member_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println("=========");
		System.out.println(id);
		
	  member_service ms= new member_service();
	  try {
		Member member=ms.member_detail(Integer.parseInt(id));
		request.setAttribute("member",member);
		request.getRequestDispatcher("Back/M_member_detail.jsp").forward(request, response);
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
		Part part=request.getPart("url");	//接受文件	
		System.out.println(part);
		
		String path=request.getServletContext().getRealPath("/up"); //上传文件路径 
		
		File folder=new File(path);//在“ XX” 路径下建了一个 folder
		if(!folder.exists()){   //检测有无文件夹，没有的话可以自动创建所需文件夹。
			folder.mkdirs();
		}
	
		System.out.println(path);								
		/**
		 * Tomcat 8.0版本
		 * 
		 * 但要记得导包，因为FilenameUtils需要两个包，在lib里面。
		 */		
	  String submittedfilname=part.getSubmittedFileName();//接受到的 文件名
	  //因为怕文件上传重名覆盖原文件问题，所以要弄一个随机取名的方法。
	  //利用截取方法 来让“随机生成的文件名”与 “原文件的格式”结合
	  String name=UUID.randomUUID().toString().replaceAll("-", "");//随机生成的名字
	  String ext=FilenameUtils.getExtension(submittedfilname);//截取文件的 “后缀名” 例如：.jpg 或.txt
	  	  
	  part.write(path+"/"+name+"."+ext);//把要传入的  文件  写入(图片用这个地址)
	  
	  String realpath=request.getContextPath();
		
		String id=request.getParameter("member_id");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("member-tel");
		String email=request.getParameter("email");
		String url=realpath+"/up/"+name+"."+ext;
		String adress=request.getParameter("member_adress");
		String adressDetail=request.getParameter("detail");
		
		Member member=new Member();
		member.setID(Integer.parseInt(id));
		member.setSex(sex);
		member.setTel(tel);
		member.setEmail(email);
		member.setUrl(url);
		member.setAdress(adress);
		member.setAdressDetail(adressDetail);
		
		 /**
	 	* 获取时间
	 	*/
	 	Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
	 	
        String name1=(String) request.getSession().getAttribute("admin_name");
		Log log=new Log();
		log.setDate(sdf.format(date));
		log.setDs("在"+sdf.format(date)+"进行了修改用户信息操作");
		log.setName(name1);
		log.setType("修改");
		
		member_service ms=new member_service();
		try {
			ms.update_member(member);
			ms.log(log);
			
			response.sendRedirect("Back/Public_change_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-gene	rated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/M_member_detail.jsp").forward(request, response);
		}
		
	}

}
