package com.su_back.servlet_back;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.su_back.model.News;
import com.su_back.service.news_service;

/**
 * Servlet implementation class news_add
 */
@WebServlet("/news_add.do")
@MultipartConfig
public class news_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public news_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String name1=(String) request.getSession().getAttribute("admin_name");
		
		if(name1==null){
		    PrintWriter out = response.getWriter();  
	        out.println("<html>");      
	        out.println("<script>");      
	        out.println("window.open ('"+request.getContextPath()+"/Back/login.jsp','_top')");      
	        out.println("</script>");      
	        out.println("</html>");            	        
		}else{
			Part part=request.getPart("photo");	//接受文件	
			System.out.println(part);
			
			String path=request.getServletContext().getRealPath("/up_news"); //上传文件路径 
			
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
		    
			String title=request.getParameter("title");
			String type=request.getParameter("type");
			String author=request.getParameter("author");
			String date=request.getParameter("date");
			String url=request.getParameter("url");
			String content=request.getParameter("content");
			String photo=realpath+"/up_news/"+name+"."+ext;
			
			News news=new News();
			news.setTitle(title);
			news.setType(type);
			news.setAuthor(author);
			news.setAddTime(date);
			news.setUrl(url);
			news.setContent(content);
			news.setPhoto(photo);
			
			 /**
		 	* 获取时间
		 	*/
		 	Date date1 =new Date();
		 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 	//sdf.format(date);
		 	
	        //String name1=(String) request.getSession().getAttribute("admin_name");
			Log log=new Log();
			log.setDate(sdf.format(date1));
			log.setDs("在"+sdf.format(date)+"进行了添加资讯操作");
			log.setName(name1);
			log.setType("添加");
			
			news_service ns=new news_service();
			try {
				ns.add_news(news);
				ns.log(log);
				
				response.sendRedirect("Back/Public_add_reload.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg",e.getMessage());
				request.getRequestDispatcher("Back/N_news_add.jsp").forward(request, response);
			}	
		}
		
        
	}

}
