<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.text.SimpleDateFormat" %>
     <%@ page import="java.util.*" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>添加用户</title>
</head>
<body>
<div class="pd-20">
  <form action="/Lesson_Design_second/member_edit.so" method="post" class="form form-horizontal" id="form-member-detail" enctype="multipart/form-data">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${member.memberName}" placeholder="" id="member_name" name="member_name" datatype="*2-16" nullmsg="用户名不能为空" readonly="readonly">
      </div>
      <div class="col-4"> </div>
    </div>
     	  
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>性别：</label>
      <div class="formControls col-5 skin-minimal">
      
        <c:if test="${member.sex eq '男'}">
          <div class="radio-box">
          <input type="radio" checked="checked" id="sex-1" name="sex" datatype="*" nullmsg="请选择性别！" value="男">
          <label for="sex-1">男</label>
          </div>
          <div class="radio-box">
          <input type="radio" id="sex-2" name="sex" value="女">
          <label for="sex-2">女</label>
          </div>
           <div class="radio-box">
          <input type="radio" id="sex-3" name="sex" value="保密">
          <label for="sex-3">保密</label>
          </div>
        </c:if>

        <c:if test="${member.sex eq '女'}">
          <div class="radio-box">
          <input type="radio"  id="sex-1" name="sex" datatype="*" nullmsg="请选择性别！" value="男">
          <label for="sex-1">男</label>
          </div>
          <div class="radio-box">
          <input type="radio" checked="checked" id="sex-2" name="sex" value="女">
          <label for="sex-2">女</label>
          </div>
           <div class="radio-box">
          <input type="radio" id="sex-3" name="sex" value="保密">
          <label for="sex-3">保密</label>
          </div>
        </c:if>
       
        <c:if test="${member.sex eq '保密'}">
         <div class="radio-box">
          <input type="radio" id="sex-1" name="sex" datatype="*" nullmsg="请选择性别！" value="男">
          <label for="sex-1">男</label>
          </div>
          <div class="radio-box">
          <input type="radio" id="sex-2" name="sex" value="女">
          <label for="sex-2">女</label>
          </div>
          <div class="radio-box">
          <input type="radio" checked="checked"  id="sex-3" name="sex" value="保密">
          <label for="sex-3">保密</label>
          </div>
        </c:if>
         
       </div>
      </div>
      <div class="col-4"> </div>
   
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>手机：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${member.tel}" placeholder="" id="member-tel" name="member-tel"  datatype="m" nullmsg="手机不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
      <div class="formControls col-5">
        <input type="text" value="${member.email}" class="input-text" placeholder="@" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
      </div>
      <div class="col-4"> </div>
    </div>
    
    
    <div class="row cl">
      <label class="form-label col-3">所在地区：</label>
      <div class="formControls col-5">     
        <input type="text" class="input-text" value="${member.adress}" placeholder="" id="" name="member_adress" datatype="*" nullmsg="地区信息不能为空" > 
      </div>
      <div class="col-4"> </div>
    </div>
   
    <div class="row cl">
      <label class="form-label col-3">详细地址：</label>
      <div class="formControls col-5">
        <textarea name="detail"  cols="" rows="" class="textarea"  placeholder="最少输入6个字符" datatype="*6-100" dragonfly="true" nullmsg="详细地址不能为空！" onKeyUp="textarealength(this,100)">${member.adressDetail}</textarea>
        <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
	  <label class="form-label col-3">图片上传：</label>
		<div class="formControls col-5">
		 <div class="uploader-thum-container">
			<div id="fileList" class="uploader-list"></div>
				<input type="file" name="url">
			</div>
		 </div>
	</div>
    
     <div class="row cl">    
			<label class="form-label col-3"><span class="c-red">*</span>创建时间：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="${member.creatTime}"  id="creattime"  name="creattime" readonly="readonly" >
			</div>
			<div class="col-4"> </div>
	</div>
		
	<div class="row cl">${msg}
		<input type="hidden" id="" name="member_id" value="${member.ID}"> <%--隐藏域获取用户ID --%>
	</div>
    
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
   
  </form>
 </div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-detail").Validform({
		tiptype:'2'	
	});
	
});

</script>
</body>
</html>