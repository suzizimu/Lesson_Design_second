<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ page import="java.text.SimpleDateFormat" %>
     <%@ page import="java.util.*" %>
<%
     //项目的发布路径，例如：/abcd
     String path=request.getContextPath();
     /*
            全路径，形式如下： http://127.0.0.1:8001/abcd/
     request.getScheme()       ——>http 获取协议
     request.getServerName()   ——>127.0.0.1 获取服务器名
     request.getServerPort()   ——>8001 获取端口号
     path                      ——> /abcd 获取访问的路径
     */
     String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>回复信息</title>
</head>
<body>
<div class="pd-20">
	<form action="/Lesson_Design_second/reply_add.do" method="post" class="form form-horizontal" id="form-change-password">
		
    	<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>举报人：</label>
			<div class="formControls col-4"> 
			    <input type="text" class="input-text" autocomplete="off" name="member_name"   readonly="readonly"  value="${report.memberName}">
			 </div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>管理员：</label>
			<div class="formControls col-4"> 
			    <input type="text" class="input-text" autocomplete="off" name="admin_name"  readonly="readonly"  value="<%=session.getAttribute("admin_name")%>">
			 </div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>商品ID：</label>
			<div class="formControls col-4"> 
			    <input  class="input-text" autocomplete="off" name="goodsID"  readonly="readonly"  value="${report.goodsID}">
			 </div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2">回复信息：</label>
			<div class="formControls col-10">
				<textarea name="introduce" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="内容不能为空！" onKeyUp="textarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		
	   <div class="row cl">			  
          <%	
            Date date =new Date();
	    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	//sdf.format(date);
	    	%>
			<label class="form-label col-2"><span class="c-red">*</span>时间：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text"  value="<%=sdf.format(date)%>"  id="creattime"  name="date" readonly="readonly" style="width:200px" >
			</div>
		</div>
		
		<div>${msg}</div>
		<div class="row cl">
			<div class="col-8 col-offset-4">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script>
$(function(){
	$("#form-change-password").Validform({
		tiptype:3,
		 
	});
	
});
</script>
</body>
</html>