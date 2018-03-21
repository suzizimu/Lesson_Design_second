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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>评论管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>评论管理 <span class="c-gray en">&gt;</span>评论列表<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

 <div class="pd-20">
 
   <form action="/Lesson_Design_second/buyer_reply_select.so" method="post">
	 <div class="text-c"> 日期范围：
		<input type="text" name="date1" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px">
		-
		<input type="text" name="date2" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px">
		<input type="text" name="goodsName" class="input-text" style="width:150px" placeholder="输入商品名" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
	 </div>
   </form>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	    <span class="l">
	       <a href="javascript:;" onclick="buyer_reply_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 	       
	    </span>	    
	</div>
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="50"><input type="checkbox" name="" value=""></th>
				<th width="100">ID</th>
				<th width="100">订单号</th>
				<th width="100">商品ID</th>				
				<th width="250">商品名</th>										
				<th width="250">买家 </th>				
				<th width="250">买家评论</th>
				<th width="250">评论日期</th>
				<th width="250">操作</th>
			</tr>		                               
		</thead>
		<tbody>
			<c:forEach items="${list}" var="seller_recive">
		     <tr class="text-c">
		       <td><input type="checkbox" value="${seller_recive.ID}" name="check"></td>
		       <td>${seller_recive.ID}</td>
		       <td>${seller_recive.orderNum}</td>
		       <td>${seller_recive.goodsID}</td>
		       <td>${seller_recive.goodsName}</td>	
		       <td>${seller_recive.memberName}</td>		     
		       <td>${seller_recive.introduce}</td>
		       <td>${seller_recive.date}</td>		 
			   <td class="td-manage">			      			   
				  <a title="删除" href="javascript:;" onclick="seller_recive_del(${seller_recive.ID})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
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
<script type="text/javascript" src="/Lesson_Design_second/Back/lib/My97DatePicker/WdatePicker.js"></script> 
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
		  {"orderable":false,"aTargets":[0]}// 制定列不参与排序
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

/*--------------------------------------------------------------------------------

/*举报-删除*/
function seller_recive_del(id){
	layer.confirm('确认要删除吗？',function(){
		$.post("/Lesson_Design_second/buyer_reply_delete.so",{buyer_reply_id:id},function(data){
			if(data.info=="删除成功"){
				layer.msg('已删除!',{icon:1,time:1000});
				window.location.href="/Lesson_Design_second/seller_recive_list.so";					
			}else{
				layer.msg('删除失败！');
			}			
		},"json")
		
	});
}
/*举报-批量删除*/
function buyer_reply_delMore(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../buyer_reply_deleteMore.so?idAll="+idAll;
}
</script> 
</body>
</html>