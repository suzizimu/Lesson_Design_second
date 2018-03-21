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
  <form action="/Lesson_Design_second/member_add.do" method="post" class="form form-horizontal" id="form-member-add" enctype="multipart/form-data">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="" id="member_name" name="member_name" datatype="*2-16" nullmsg="用户名不能为空" ajaxurl="../member_check.do">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls col-5">
				<input type="password" id="password" name="newpassword" placeholder="密码" autocomplete="off" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
			</div>
			<div class="col-4"> </div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-5">
				<input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="newpassword" id="newpassword2" name="newpassword2">
			</div>
			<div class="col-4"> </div>
	</div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>性别：</label>
      <div class="formControls col-5 skin-minimal">
        <div class="radio-box">
          <input type="radio" id="sex-1" name="sex" datatype="*" nullmsg="请选择性别！" value="男">
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
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>手机：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="" id="member-tel" name="member-tel"  datatype="m" nullmsg="手机不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="@" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
      </div>
      <div class="col-4"> </div>
    </div>
       
    <div class="row cl">
      <label class="form-label col-3">所在城市：</label>
      <div class="formControls col-5">
       
         <select id="province" size="1"  name="province" datatype="*" nullmsg="请选择所在省份！" >
          <option value="">请选择省份</option>
         </select>
      
        <select id="city" name="city" datatype="*" nullmsg="请选择所在城市！">
         <option value="">请选择城市</option>
        </select>
      
        <select id="area" name="area" datatype="*" nullmsg="请选择所在区域！" >
         <option>请选择地区</option>
        </select>
     
      </div>
      <div class="col-4"> </div>
    </div>
  
  
    <div class="row cl">
      <label class="form-label col-3">详细地址：</label>
      <div class="formControls col-5">
        <textarea name="detail" cols="" rows="" class="textarea"  placeholder="最少输入6个字符" datatype="*6-100" dragonfly="true" nullmsg="详细地址不能为空！" onKeyUp="textarealength(this,100)"></textarea>
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
       <%	
        Date date =new Date();
	 	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	//sdf.format(date);
		%>
			<label class="form-label col-3"><span class="c-red">*</span>创建时间：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="<%=sdf.format(date)%>"  id="creattime"  name="creattime" readonly="readonly" >
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">${msg}
		<input type="hidden" id="adress" name="adress" value=""> <%--隐藏域获取地址基本信息 --%>
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
	
	$("#form-member-add").Validform({
		tiptype:'2'	
	});
	
  
		 loadprovince(); 
		 $("#province").change(loadcity);
		 $("#city").change(loadarea);
		 $("#area").change(getaddress);

		 function loadprovince(){
			    $.get("../ldprovince.do",
			 		 function(data){
				            //alert(data);        	      
				        	/* for (var i= 0;i<data.length;i++){
								//console.log(data[i].province_id+"======"+data[i].province_name);
								 $("#province").append("<option value="+data[i].province_id+">"+data[i].province_name+"</option>");
				        	   }*/
				        	      
				        	  $(data).each(function(i){
				        	  $("#province").append("<option value='"+this.province_id+"' >"+this.province_name+"</option>"); 
				        	    })//要想让each 停止用 return
				           },
				        "json"
				        )      
			}
			function loadcity(){
				var province_id=$("#province").val();
				
				$("#city").html("<option value=''>请选择城市</option>");//每次改变省份 清空以前所属城市
				if(province_id==""){
					return;
				}
				
				$.post("../ldcity.do",{pro_id:province_id},function(data){
					//alert(data);
					
					
					$(data).each(function(i){
			 	        	  $("#city").append("<option value='"+this.city_id+"' >"+this.city_name+"</option>"); 
			 	        	    })//要想让each 停止用 return
				},"json")
			}

			function loadarea(){
				var city_id=$("#city").val();
				$("#area").html("<option value=''>请选择地区</option>"); //每次改变城市 清空以前所属地区
				
				if(city_id==""){
					return;
				}
				
				$.get("../ldarea.do",{city_id:city_id},function(data){
					//alert(data);
					$(data).each(function(i){
			       	    $("#area").append("<option value='"+this.area_id+"'>"+this.area_name+"</option>"); 
			       	    })//要想让each 停止用 return
				},"json")
				
			}
			function getaddress(){
				var province=$("#province").find("option:selected").text();
				var city=$("#city").find("option:selected").text();
				var area=$("#area").find("option:selected").text();
				var s=province+city+area;
				$("#adress").val(s);
			}	
});

</script>
</body>
</html>