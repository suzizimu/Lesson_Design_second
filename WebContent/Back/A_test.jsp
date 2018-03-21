<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 
	<base/>标签解决路径问题
	参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=path%>/Back/">
		<meta charset="UTF-8">
		<title>H5模版:</title>
	</head>
	<body>
	
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
		setInterval("shuaxin()",3000);
		
		function shuaxin(){
			//document.write(num);
			$.post("/Lesson_Design_second/A_test.do",
			   function(data) {
					if(data.info==15){
						console.log(data.info);
		            }else{
		            	console.log("失败");
		            }
			    }
			,"json")
		 };
	   </script>
	</body>
</html>