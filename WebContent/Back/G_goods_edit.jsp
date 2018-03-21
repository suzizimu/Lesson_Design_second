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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />

<title>编辑商品</title>
</head>
<body>
<div class="pd-20">
	<form action="/Lesson_Design_second/goods_edit.do" method="post" class="form form-horizontal" id="form-goods-edit" enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>商品名称：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${goods.name}" name="name" datatype="*" nullmsg="商品名称不能为空！">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>商品类别：</label>
			<div class="formControls col-2"> 
						
			 <c:if test="${goods.goodsType eq '书籍'}">
			    <span class="select-box">
				<select id="type" name="type" class="select" nullmsg="商品类别不能为空！" datatype="*"  >
					<option value="">全部种类</option>
					<option value="书籍" class="book" selected="selected">书籍</option>
					<option value="影音家电" class="app">影音家电</option>
					<option value="鞋服配饰" class="clothes">鞋服配饰</option>
					<option value="闲置数码" class="digital">闲置数码</option>
					<option value="其它">其它</option>						
				</select>
				</span>
			  </c:if>
			  
			 <c:if test="${goods.goodsType eq '影音家电'}">
			    <span class="select-box">
				<select id="type" name="type" class="select" nullmsg="商品类别不能为空！" datatype="*"  >
					<option value="">全部种类</option>
					<option value="书籍" class="book" >书籍</option>
					<option value="影音家电" class="app" selected="selected">影音家电</option>
					<option value="鞋服配饰" class="clothes">鞋服配饰</option>
					<option value="闲置数码" class="digital">闲置数码</option>
					<option value="其它">其它</option>						
				</select>
				</span>
			  </c:if>
			  
			  <c:if test="${goods.goodsType eq '鞋服配饰'}">
			    <span class="select-box">
				<select id="type" name="type" class="select" nullmsg="商品类别不能为空！" datatype="*"  >
					<option value="">全部种类</option>
					<option value="书籍" class="book" >书籍</option>
					<option value="影音家电" class="app">影音家电</option>
					<option value="鞋服配饰" class="clothes" selected="selected">鞋服配饰</option>
					<option value="闲置数码" class="digital">闲置数码</option>
					<option value="其它">其它</option>						
				</select>
				</span>
			  </c:if>
			  
			  <c:if test="${goods.goodsType eq '闲置数码'}">
			    <span class="select-box">
				<select id="type" name="type" class="select" nullmsg="商品类别不能为空！" datatype="*"  >
					<option value="">全部种类</option>
					<option value="书籍" class="book" >书籍</option>
					<option value="影音家电" class="app">影音家电</option>
					<option value="鞋服配饰" class="clothes" >鞋服配饰</option>
					<option value="闲置数码" class="digital" selected="selected">闲置数码</option>
					<option value="其它">其它</option>						
				</select>
				</span>
			  </c:if>
			  
			  <c:if test="${goods.goodsType eq '其它'}">
			    <span class="select-box">
				<select id="type" name="type" class="select" nullmsg="商品类别不能为空！" datatype="*"  >
					<option value="">全部种类</option>
					<option value="书籍" class="book" >书籍</option>
					<option value="影音家电" class="app">影音家电</option>
					<option value="鞋服配饰" class="clothes" >鞋服配饰</option>
					<option value="闲置数码" class="digital" >闲置数码</option>
					<option value="其它" selected="selected">其它</option>						
				</select>
				</span>
			  </c:if>
			  			  
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
				<input type="text" class="input-text"  value="${goods.date}"  id="creattime"  name="date" readonly="readonly" >
			</div>
		</div>
		
		<div class="row cl">	
			<label class="form-label col-2"><span class="c-red">*</span>原价：</label>
			<div class="formControls col-2">
				<input type="text" datatype="*"  name="price_ago" class="input-text" value="${goods.priceAgo}"  nullmsg="原价不能为空！">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>现价：</label>
			<div class="formControls col-2">
			   <input type="text" datatype="*" name="price_now" class="input-text" value="${goods.priceNow}"   nullmsg="现价不能为空！">
			</div>
	    </div>
		
		<div class="row cl">
			<label class="form-label col-2">卖家账号：</label>
			<div class="formControls col-2">
				<input type="text"  class="input-text" value="${goods.memberName}"  name="member_name" nullmsg="卖家账号不能为空！"  datatype="*">
			</div>
		</div>
        
        <div class="row cl">
			<label class="form-label col-2">电话：</label>
			<div class="formControls col-2">
				<input type="text"  class="input-text" value="${goods.tel}"  name="member_tel" nullmsg="卖家电话不能为空！"  datatype="*">
			</div>
		</div>
        
		<div class="row cl">
			<label class="form-label col-2">商品介绍：</label>
			<div class="formControls col-10">
				<textarea name="introduce" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="商品介绍不能为空！" onKeyUp="textarealength(this,200)">${goods.introduce}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		
	    <div class="row cl">
			<label class="form-label col-2">图片上传：</label>
			<div class="formControls col-10">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<input type="file" name="url" dir="${goods.url}">
				</div>
			</div>
		</div>
		
		<div class="row cl">
		   <input type="hidden" value="${goods.ID}" name="goods_id">
		   <input type="hidden" id="category" name="category" value=""> <%--隐藏域获取地址基本信息 --%>
		</div>
	    <div class="row cl">${msg}</div>
	    
		<div class="row cl">
			<div class="col-10 col-offset-2">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">			
			</div>
		</div>
	</form>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="/Lesson_Design_second/Back/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>  
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#form-goods-edit").Validform({
		tiptype:'2'	
	});
	
	$("#type").change(getcategory);
	function getcategory(){
		
		var category=$("#type").find("option:selected").attr("class");
		$("#category").val(category);
	}
});
</script>
</body>
</html>