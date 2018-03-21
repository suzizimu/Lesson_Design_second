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
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />

<title>新增资讯</title>
</head>
<body>
<div class="pd-20">
	<form action="/Lesson_Design_second/news_add.do" method="post" class="form form-horizontal" id="form-news-add" enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value=""  name="title" datatype="*" nullmsg="标题不能为空！">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>资讯类别：</label>
			<div class="formControls col-2"> <span class="select-box">
				<select name="type" class="select" nullmsg="资讯类别不能为空！" datatype="*"  >
					<option value="">全部类别</option>
					<option value="娱乐">娱乐</option>
					<option value="科技">科技</option>
					<option value="体育">体育</option>						
				</select>
				</span>
		    </div>
		</div>
		
		<div class="row cl">	
			<label class="form-label col-2"><span class="c-red">*</span>作者：</label>
			<div class="formControls col-2">
				<input type="text" datatype="*"  class="input-text" value="" name="author" nullmsg="作者不能为空！">
			</div>
		</div>
		
		<div class="row cl">			  
          <%	
            Date date =new Date();
	    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	//sdf.format(date);
	    	%>
			<label class="form-label col-2"><span class="c-red">*</span>发布时间：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text"  value="<%=sdf.format(date)%>"  id="creattime"  name="date" readonly="readonly" style="width:200px" >
			</div>
		</div>
		
        <div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>URL：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="" name="url" datatype="*" nullmsg="url不能为空！">
			</div>
		</div>
		    
		<div class="row cl">
			<label class="form-label col-2">内容：</label>
			<div class="formControls col-10">
				<textarea name="content" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="内容不能为空！" onKeyUp="textarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		
	    <div class="row cl">
			<label class="form-label col-2">图片上传：</label>
			<div class="formControls col-10">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<input type="file" name="photo">
				</div>
			</div>
		</div>
		
	    <div class="row cl">${msg}</div>
	    
		<div class="row cl">
			<div class="col-10 col-offset-2">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				<button  class="btn btn-default radius" type="reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="/Lesson_Design_second/Back/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#form-news-add").Validform({
		tiptype:'3'	
	});
});
</script>
</body>
</html>