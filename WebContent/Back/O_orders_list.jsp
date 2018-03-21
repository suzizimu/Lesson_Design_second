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
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">

<title>订单</title>
</head>

<div >
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理<span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="pd-20">
	
   <form action="/Lesson_Design_second/orders_select.do" method="post">
	 <div class="text-c"> 
	   <span class="select-box inline">
        <select name="type" class="select" style="width:100px">
					<option value="">全部种类</option>
					<option value="书籍">书籍</option>
					<option value="影音家电">影音家电</option>
					<option value="鞋服配饰">鞋服配饰</option>
					<option value="闲置数码">闲置数码</option>						
		</select>
		</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     购买日期：
		<input type="text" name="date1" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px">
		-
		<input type="text" name="date2" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px">		
		
		<input type="text" name="memberName" class="input-text" style="width:150px" placeholder="输入买家姓名" >	
		<input type="text" name="num" class="input-text" style="width:250px" placeholder="输入订单号" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜订单</button>
	 </div>
    </form>
		
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		     <span class="l">
		          <a href="javascript:;" onclick="orders_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
		     </span>
             <span class="r">共有数据：<strong>${record}</strong> 条</span> 
        </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="40"><input name="" type="checkbox" value=""></th>
						<th width="40">ID</th>
						<th width="70">订单号</th>
						<th width="">购买日期</th>
						<th width="50">商品名称</th>
						<th width="60">商品类别</th>
						<th width="30">价钱</th>												
						<th width="80">买家</th>
						<th width="30">电话</th>	
						<th width="30">地址</th>	
						<th width="30">详细地址</th>
						<th width="30">卖家</th>			
						<th width="80">操作</th>
					</tr>
				</thead>
				<tbody>
			       <c:forEach items="${list}" var="orders">
		             <tr class="text-c">
		                <td><input type="checkbox" value="${orders.ID}" name="check"></td>
		                <td>${orders.ID}</td>
		                <td>${orders.orderNum}</td>
		                <td>${orders.date}</td>
		                <td>${orders.goodsName}</td>
		                <td>${orders.goodsType}</td>
		                <td>${orders.priceNow}</td>
		                <td>${orders.memberName}</td>
		                <td>${orders.tel}</td>
		                <td>${orders.adress}</td>
		                <td>${orders.adressDetail}</td>	
		                <td>${orders.seller}</td>			
						<td class="td-manage">						   
						   <a style="text-decoration:none" class="ml-5" onClick="orders_del(${orders.ID})" href="javascript:;" title="退货"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
				  </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="/Lesson_Design_second/Back/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 

<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">

$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[]}// 制定列不参与排序
	]
});

///************************************************************
/*订单-删除*/
function orders_del(id){
	layer.confirm('确认要退货吗？',function(){
		$.post("/Lesson_Design_second/orders_delete.do",{orders_id:id},function(data){
			if(data.info=="退货成功"){
				layer.msg('已退货!',{icon:1,time:1000});
				window.location.href="/Lesson_Design_second/orders_list.do";					
			}else{
				layer.msg('退货失败！');
			}			
		},"json")
		
	});
}
/*订单-批量删除*/
function orders_delMore(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../orders_deleteMore.do?idAll="+idAll;
}
</script>
</body>