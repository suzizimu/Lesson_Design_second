<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>删除的用户</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 删除的用户<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	   <a href="javascript:;" onclick="member_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
	   <span class="r">共有数据：<strong>${record}</strong> 条</span> 
    </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="50"><input type="checkbox" name="" value=""></th>
				<th width="100">ID</th>
				<th width="">用户名</th>
				<th width="100">性别</th>
				<th width="230">邮箱</th>
				<th width="150">电话</th>							
				<th width="200">创建时间</th>				
				<th width="100">是否已启用</th>
				<th width="150">操作</th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach items="${list}" var="member">
		     <tr class="text-c">
		       <td><input type="checkbox" value="${member.ID}" name="check"></td>
		       <td>${member.ID}</td>
		       <td>${member.memberName}</td>
		       <td>${member.sex}</td>
		       <td>${member.email}</td>
		       <td>${member.tel}</td>	
		       <td>${member.creatTime}</td>
			   <td class="td-status"><span class="label label-danger radius">已删除</span></td>
				<td class="td-manage">
				   <a style="text-decoration:none" href="javascript:;" onClick="member_huanyuan(${member.ID})" title="还原"><i class="Hui-iconfont">&#xe66b;</i></a> 
				   <a title="删除" href="javascript:;" onclick="member_del(${member.ID})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
		  </c:forEach>	
		</tbody>
	</table>
	</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[]}// 制定列不参与排序
		]
	});
	$('.table-sort tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
});

/*被删除的用户-还原*/
function member_huanyuan(id){
	layer.confirm('确认要复原吗？',function(){
		$.post("/Lesson_Design_second/member_del_list_restore.do",{member_id:id},function(data){
			if(data.info=="复原成功"){
				layer.msg('已还原 !',{icon:1,time:2000});
				window.location.href="/Lesson_Design_second/member_del_list.do";					
			}else{
				layer.msg('还原失败！');
			}			
		},"json")
		
	});
}

/*被删除的用户-删除*/
function member_del(id){
	layer.confirm('确认要删除吗？',function(){
		$.post("/Lesson_Design_second/member_del_list_delete.do",{member_id:id},function(data){
			if(data.info=="删除成功"){
				layer.msg('已删除 !',{icon:1,time:2000});
				window.location.href="/Lesson_Design_second/member_del_list.do";					
			}else{
				layer.msg('删除失败！');
			}			
		},"json")
		
	});
}
/*被删除的用户-批量删除*/
function member_delMore(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../member_del_deleteMore.do?idAll="+idAll;
}
</script> 
</body>
</html>