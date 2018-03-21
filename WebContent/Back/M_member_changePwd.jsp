<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>修改密码</title>
</head>
<body>
<div class="pd-20">
	<form action="/Lesson_Design_second/member_pwd.do" method="post" class="form form-horizontal" id="form-change-password">
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>账户：</label>
			<div class="formControls col-4"> 
			    <input type="text" class="input-text" autocomplete="off" name="member_name" id="admin_name"  readonly="readonly"  value="${member.memberName}" >
			 </div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>旧密码：</label>
			<div class="formControls col-5">
				<input type="password" class="input-text" autocomplete="off" placeholder="必须先验证旧密码" name="old-password" datatype="*6-20" id="new-password" nullmsg="密码不能为空" ajaxurl="../member_checkPwd.do?member_name=${member.memberName}">
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-5">
				<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="new-password" datatype="*6-20" id="new-password" nullmsg="密码不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-5">
				<input type="password" autocomplete="off" class="input-text Validform_error" datatype="*"   placeholder="不修改请留空" name="new-password2" id="new-password2" recheck="new-password"  nullmsg="请再输入一次新密码！" errormsg="您两次输入的密码不一致！"  >
			</div>
			<div class="col-4"> </div>
		</div>
		
		<li><input type="hidden" name="id" value="${member.ID}"></li>
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