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

<title>建材列表</title>
</head>

<div >
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="pd-20">
	
   <form action="/Lesson_Design_second/goods_select.do" method="post">
	 <div class="text-c"> 
	   <span class="select-box inline">
       <select name="type" class="select" style="width:100px">
					<option value="">全部种类</option>
					<option value="书籍">书籍</option>
					<option value="影音家电">影音家电</option>
					<option value="鞋服配饰">鞋服配饰</option>
					<option value="闲置数码">闲置数码</option>
					<option value="其它">其它</option>						
		</select>
		</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     发布日期：
		<input type="text" name="date1" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px">
		-
		<input type="text" name="date2" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px">		
			
		<input type="text" name="name" class="input-text" style="width:250px" placeholder="输入商品名称" id="" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜商品</button>
	 </div>
    </form>
		
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		     <span class="l">
		          <a href="javascript:;" onclick="goods_delMore()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
		          <a class="btn btn-primary radius" onclick="goods_add('添加产品','G_goods_add.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a>
		     </span>
             <span class="r">共有数据：<strong>${record}</strong> 条</span> 
        </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="40"><input name="" type="checkbox" value=""></th>
						<th width="40">ID</th>
						<th width="50">商品名称</th>
						<th width="">图样</th>
						<th width="30">原价</th>
						<th width="30">现价</th>
						<th width="100">类别</th>
						<th width="60">点击次数</th>
						<th width="50">发布人</th>
						<th width="50">发布时期</th>
						<th width="30">状态</th>				
						<th width="120">操作</th>
					</tr>
				</thead>
				<tbody>
			       <c:forEach items="${list}" var="goods">
		             <tr class="text-c">
		                <td><input type="checkbox" value="${goods.ID}" name="check"></td>
		                <td>${goods.ID}</td>
		                <td>${goods.name}</td>
		                <td><img src="${goods.url}"></td>
		                <td>${goods.priceAgo}</td>
		                <td>${goods.priceNow}</td>
		                <td>${goods.goodsType}</td>
		                <td>${goods.click}</td>
		                <td>${goods.memberName}</td>
		                <td>${goods.date}</td>
						<td class="td-status"><span class="label label-success radius">已发布</span></td>
						<td class="td-manage">
						   <a style="text-decoration:none" onClick="product_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
					       <a style="text-decoration:none" class="ml-5" onClick="goods_edit(${goods.ID})" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
					       <a style="text-decoration:none" class="ml-5" onClick="goods_del(${goods.ID})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
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
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
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

/*图片-下架*/
function product_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*图片-发布*/
function product_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
///************************************************************
/*商品-添加*/
function goods_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*商品-编辑*/
function goods_edit(id){
	var index = layer.open({
		type: 2,
		title: '编辑商品详情',
		content:'../goods_edit.do?id='+id
	});
	 layer.full(index);
}
/*商品-删除*/
function goods_del(id){
	layer.confirm('确认要删除吗？',function(){
		$.post("/Lesson_Design_second/goods_delete.do",{goods_id:id},function(data){
			if(data.info=="删除成功"){
				layer.msg('已删除!',{icon:1,time:1000});
				window.location.href="/Lesson_Design_second/goods_list.do";					
			}else{
				layer.msg('删除失败！');
			}			
		},"json")
		
	});
}
/*商品-批量删除*/
function goods_delMore(){
   var check = document.getElementsByName("check");
   var len=check.length;
   var idAll="";
   for(var i=0;i<len;i++){
       if(check[i].checked){
          idAll+=check[i].value+",";
    }
  }
 window.location.href="../goods_deleteMore.do?idAll="+idAll;
}
</script>
</body>