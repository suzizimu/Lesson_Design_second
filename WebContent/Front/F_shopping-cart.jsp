<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ page import="java.util.*" %>
  <%@ page import="com.su_back.util.DBUtil" %>
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
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>iSmiler</title>
		<link href="css/master.css" rel="stylesheet">

		<!-- SWITCHER -->
		<link rel="stylesheet" id="switcher-css" type="text/css" href="assets/switcher/css/switcher.css" media="all" />
		<link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/color1.css" title="color1" media="all" />
		<link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/color2.css" title="color2" media="all" />
		<link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/color3.css" title="color3" media="all" />
		<link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/color4.css" title="color4" media="all" />

	</head>
	<body>
		<!-- Loader -->
		<div id="page-preloader"><span class="spinner"></span></div>
		<!-- Loader end -->

		<div class="b-page">
			<!-- Start Switcher -->
			<div class="switcher-wrapper">
				<div class="demo_changer">
					<div class="demo-icon customBgColor">
						<i class="fa fa-cog fa-spin fa-2x"></i>
					</div>
					<div class="form_holder">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="predefined_styles">
									<div class="skin-theme-switcher">
										<h4>Color</h4>
										<a href="#" data-switchcolor="color1" class="styleswitch" style="background-color:#e24545;"> </a>
										<a href="#" data-switchcolor="color2" class="styleswitch" style="background-color:#0072bc;"> </a>
										<a href="#" data-switchcolor="color3" class="styleswitch" style="background-color:#ff9600;"> </a>
										<a href="#" data-switchcolor="color4" class="styleswitch" style="background-color:#01a664;"> </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End Switcher -->
			<header>
				<div class="b-top-line">
					<div class="container">
						<div class="row">
							<div class="col-sm-12 clearfix">
								<div class="b-top-info pull-left">
									<div class="nav">
										<ul class="list-inline">
											<li> 
											   <c:if test="${sessionScope.member_name==null}">
											     <a href="F_login.jsp"><span><i class="nav-login"></i>您好，请登录！</span></a>											   
											   </c:if>
											   <c:if test="${sessionScope.member_name  !=null}">
											     <a href="F_login.jsp"><span><i class="nav-login"></i>欢迎 ${sessionScope.member_name} 登录成功！</span></a>											   
											   </c:if>
												
											</li>
											<li>
												<a href="F_register.jsp"><span><i class="nav-register"></i>还不是会员？点我注册</span></a>
											</li>
										</ul>
									</div>
								</div>
								<div class="b-top-info pull-right">
									<div class="nav">
										<ul class="list-inline">
											<li>
												<span><i class="fa fa-phone"></i>苏子子客服123456789</span>
											</li>
											<li>
												<span><i class="fa fa-envelope-o"></i>苏子子邮箱suzizi@sina.com</span>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="b-header-main">
					<div class="container">
						<div class="row">
							<div class="col-xs-6 col-sm-2 col-md-2 col-lg-2">
								<div class="b-logo">
									<a href="F_home.jsp">
										<span>苏子子</span>
										<br>
										<span>store</span>
									</a>
								</div>
							</div>
							<div id="toggle-nav" class="col-xs-12 col-sm-10 col-md-8 col-lg-8 menu-wrapper clearfix">
								<div class="toggle-nav-btn">
									<button class="btn btn-menu"><i class="fa fa-bars fa-lg"></i></button>
								</div>
								<div class="b-header-menu pull-right">
									<ul class="list-inline">
										<li>
											<a class="heading-line" href="F_home.jsp">首页</a>
										</li>
										<li>
											<a class="heading-line" href="F_category-grid-digital.jsp">闲置数码 </a>
										</li>
										<li>
											<a class="heading-line" href="F_category-grid-clothes.jsp">鞋服配饰</a>
										</li>
										<li>
											<a class="heading-line" href="F_category-grid-app.jsp">影音家电</a>
										</li>
										<li>
											<a class="heading-line" href="F_category-grid-book.jsp">二手书籍 </a>
										</li>
										<li>
											<a class="heading-line" href="F_blog-main.jsp">相关资讯</a>
										</li>
										<li>
											<a class="heading-line" href="index.jsp">个人中心</a>
										</li>
										<li>
											<a class="heading-line" href="F_my-wishlist.jsp">个人收藏</a>
										</li>
										
										<li class="search">
											<a id="search-open" class="iconSearch" href="#"><i class="fa fa-search"></i></a>
											<div id="search">
											
												<form action="/Lesson_Design_second/select_goods.so" method="post">
													<div class="form-group">
														<input id="searchQuery" name="goodsName" type="search" placeholder="请输入商品名称">
													</div>
												</form>
												
											</div>
										</li>
									</ul>
								</div>
							</div>
							<%
							 String sql4="select count(*) as num from car where buyer='"+session.getAttribute("member_name")+"'";
							 Map<String, Object> map=DBUtil.query(sql4);
							 long count=(long)map.get("num");
							 
							 String sql5="select sum(PriceNow) as s  from car where buyer='"+session.getAttribute("member_name")+"'"; 
							 Map<String, Object> map2=DBUtil.query(sql5);
							 double sum=map2.get("s")==null?0:(double)map2.get("s");
							%>
							
							<div id="cart-wrapper" class="col-xs-6 col-sm-12 col-md-2 col-lg-2">
								<div class="b-cart pull-right">
									<button id="cart" class="btn btn-default-color1 btn-sm">
										<span class="price"><i class="fa fa-shopping-bag"></i>￥<%=sum%></span>
										<span class="counter-wrapper"><span class="counter"><%=count%></span></span>
									</button>
									<div class="cart-products">
										<div class="c-holder">
											<h3 class="title">
												我的购物清单
											</h3>
											<ul class="products-list list-unstyled">
											 <%                        
										   String sql3="select * from car where buyer='"+session.getAttribute("member_name")+"'";
							                List<Map<String, Object>> list3=DBUtil.list(sql3);						                  
											for(int i=0;i<list3.size();i++){
											%>
												<li>
													<div class="b-cart-table ">												    
													    <a href="#" class="image">
															<img width="70" height="70" src="<%=list3.get(i).get("Url") %>" class="img-responsive center-block" alt="/">
												        </a>
												        														
														<div class="caption">
															<a class="product-name" href="../goods_detail.so?id=<%=list3.get(i).get("ID") %>"><%=list3.get(i).get("GoodsName") %></a>
															<span class="product-price">￥<%=list3.get(i).get("PriceNow") %></span>
															<div class="rating">
																<span class="star"><i class="fa fa-star"></i></span>
																<span class="star"><i class="fa fa-star"></i></span>
																<span class="star"><i class="fa fa-star"></i></span>
																<span class="star"><i class="fa fa-star"></i></span>
																<span class="star star-empty"><i class="fa fa-star-o"></i></span>
															</div>
														</div>
														
														<a  href="../car_delete.so?id=<%=list3.get(i).get("ID") %>"><button class="btn btn-remove"><i class="fa fa-trash fa-lg"></i></button></a>
													</div>
												</li>
												<%} %>
										
												<li>
													<div class="products-subtotal text-right">
														共计<span class="subtotal-price">￥<%=sum%></span>
													</div>
												</li>
											</ul>
											<div class="products-buttons text-center">
												<a  href="F_shopping-cart.jsp"><button type="button" class="btn btn-default-color1 btn-sm">查看购物车</button></a>
											</div>
										</div>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</header>
			<section class="section-shopping-cart">
				<div class="b-page-header">
					<div class="container">
						<div class="row">
							<div class="col-sm-12 clearfix">
								<h3 class="page-title pull-left">购物车</h3>
								<div class="b-breadcrumbs pull-right">
									<ul class="list-unstyled">
										<li>
											<a href="#">home</a>
										</li>
										<li>
											<span>shopping cart</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-sm-12 cart-table wow fadeInUp">
							<div class="b-table b-cart-table table-responsive">
								<table class="table">
							<%
							 String sql9="select count(*) as num from car where buyer='"+session.getAttribute("member_name")+"'";
							 Map<String, Object> map9=DBUtil.query(sql9);
							 long count9=(long)map9.get("num");
							 %>
									<thead>
										<tr>
											<td>
												<span>购物车的物品 <span class="counter">(<%=count9 %>)</span></span>
											</td>
											<td>
												<span>类别</span>
											</td>
											<td>
												<span>原价</span>
											</td>
											<td>
												<span>现价</span>
											</td>										
											<td>
												<span>删除</span>
											</td>
										</tr>
									</thead>
									<tbody>
									<%                        
											String sql8="select * from car where buyer='"+session.getAttribute("member_name")+"'";
							                List<Map<String, Object>> list8=DBUtil.list(sql8);
						                    //request.setAttribute("list",list);
											for(int i=0;i<list8.size();i++){
											%>
										<tr>
											<td>
												<div class="image">
													<img src="<%=list8.get(i).get("Url") %>" width="111" height="134" class="img-responsive img-thumbnail center-block" alt="/">
												</div>
												<div class="caption">
													<a class="product-name" href="../goods_detail.so?id=<%=list8.get(i).get("GoodsID") %>"><%=list8.get(i).get("GoodsName") %></a>												
													<a href="../collect_add.so?id=<%=list8.get(i).get("ID") %>"><button type="button" class="btn btn-add-wish"><i class="fa fa-heart-o"></i>添加到个人收藏</button></a>
												</div>
											</td>
											<td>
												<span class="product-price"><%=list8.get(i).get("GoodsType") %></span>
											</td>
											<td>
											    <span class="product-price">￥<%=list8.get(i).get("PriceAgo") %></span>
											</td>
											<td>
												<span class="product-price total-price">￥<%=list8.get(i).get("PriceNow") %></span>
											</td>
											<td class="text-left">
												<a href="../car_delete.so?id=<%=list8.get(i).get("ID") %>"><button class="btn btn-remove"><i class="fa fa-trash fa-lg"></i></button></a>
											</td>
										</tr>
										<%} %>
		
									</tbody>
								</table>
							</div>
							<a href="F_home.jsp"><button class="btn btn-default-color1 btn-continue btn-sm">继续购物</button></a>
						</div>
						
						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 wow fadeInLeft">
						
						</div>
						
						<%         
						//购物车id总和
						String sql88="select * from car where buyer='"+session.getAttribute("member_name")+"'";
					    List<Map<String, Object>> list88=DBUtil.list(sql88);
						String idAll="";
						String idAll2="";
						for(int i=0;i<list88.size();i++){
							
							idAll+=list88.get(i).get("GoodsID")+","; //根据购物车获取 商品id的集合。
							idAll2+=list88.get(i).get("ID")+",";//根据购物车获取 购物车id的集合
						}		
						
						session.setAttribute("idAll",idAll);
						session.setAttribute("idAll2",idAll2);
						//原价总和
						String sql11="select sum(PriceAgo) as s11  from car where buyer='"+session.getAttribute("member_name")+"'"; 
							 Map<String, Object> map11=DBUtil.query(sql11);
							 double sum11=map11.get("s11")==null?0:(double)map11.get("s11");
					    %>
						<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow fadeInRight">
							<div class="b-total-table clearfix">
								<table class="table table-condensed">
									<tbody>
										<tr>
											<td>原价总计</td>
											<td>￥<%=sum11 %></td>
										</tr>
										<tr>
											<td>优惠</td>
											<td>￥<%=sum11-sum%></td>
										</tr>									
										<tr class="total">
											<td>实际支付</td>
											<td>￥<%=sum%></td>
										</tr>
									</tbody>
								</table>
								<a href="../pay_add.so"><button class="btn btn-primary-color2 btn-sm">付款</button></a>
							</div>
						</div>
						
					</div>
				</div>
			</section>        
						<footer>
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-3">
							<div class="b-logo">
								<a href="#">
									<span>苏子子</span>
									<br>
									<span>store</span>
								</a>
							</div>
							<div class="b-footer-contacts wow pulse nimated">
								<div class="footer-contacts-info">
									<p>
										欢迎来到苏子子二手网，祝大家交易愉快。
									</p>
								</div>
								<div class="footer-contacts-list">
									<ul class="list-unstyled">
										<li>
											<i class="fa fa-map-pin fa-fw"></i>
											<span>山东省济南市长清区齐鲁工业大学</span>
										</li>
										<li>
											<i class="fa fa-phone fa-fw"></i>
											<span>+ 123 456 7890</span>
										</li>
										<li>
											<i class="fa fa-envelope-o fa-fw"></i>
											<span>suzizi@sina.com</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-9">
							<div class="row">
								<div class="b-footer-menu clearfix">
									<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">
										
									</div>
									<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">
										<div class="footer-menu-item wow pulse nimated">
											<div class="heading-line">你能在这里找到：</div>
											<ul class="list-unstyled">
												<li><a href="F_category-grid-digital.jsp">闲置数码</a></li>
												<li><a href="F_category-grid-clothes.jsp">鞋服配饰</a></li>
												<li><a href="F_category-grid-app.jsp">影音家电</a></li>
												<li><a href="F_category-grid-book.jsp">二手书籍</a></li>
											</ul>
										</div>
									</div>
									<div class="clearfix visible-xs-block"></div>
									<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">
										<div class="footer-menu-item wow pulse nimated">
											<div class="heading-line">快速入口：</div>
											<ul class="list-unstyled">
												<li><a href="index.jsp">个人中心</a></li>
												<li><a href="F_shopping-cart.jsp">购物车</a></li>
												<li><a href="F_my-wishlist.jsp">收藏列表</a></li>
												<li><a href="help-document.html">帮助文档</a></li>
											</ul>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">
										<div class="b-latest-tweets wow pulse nimated">
											<div class="heading-line">苏子子留言：</div>
											<div class="tweet-item">
												<p>
														大家交易时请注意安全，
														及时分辨交易物品是否合适，
														有问题可以向我举报。
												</p>
											</div>
											<div class="tweet-item">
												<p>
													最近出现一些假冒伪劣产品，
													经热心群众举报我已经锁定相关人员并采取合法措施，
													谢谢大家合作。
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="b-footer-subsc">
								<div class="row">
									<div class="col-sm-1">
										
									</div>
									<div class="col-sm-9 col-lg-5">
										<div class="subsc-mail wow pulse nimated">
											<form id="comment-reply-form" class="b-form" method="get" action="#">
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<input type="text" class="form-control" id="form-mail" placeholder="想对苏子子说...">
															<button type="button" class="btn btn-subsc"><i class="fa fa-envelope-o fa-fw"></i></button>
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
									<div class="col-sm-12 col-lg-4 clearfix">
										<div class="footer-socials wow pulse nimated">
											<div class="b-socials clearfix">
												<ul class="list-unstyled">
													<li><a href="https://twitter.com/"><i class="fa fa-twitter fa-fw"></i></a></li>
													<li><a href="https://www.facebook.com/"><i class="fa fa-facebook fa-fw"></i></a></li>
													<li><a href="https://www.linkedin.com/"><i class="fa fa-linkedin fa-fw"></i></a></li>
													<li><a href="https://plus.google.com/"><i class="fa fa-google-plus fa-fw"></i></a></li>
													<li><a href="http://pinterest.com/"><i class="fa fa-pinterest-p fa-fw"></i></a></li>
													<li><a href="https://www.youtube.com/"><i class="fa fa-youtube-play fa-fw"></i></a></li>
													<li><a href="#"><i class="fa fa-rss fa-fw"></i></a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="b-footer-add">
					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div class="clearfix">
									<div class="b-copy pull-left wow fadeInLeft">
										<p>
											Copyright © 2015 <a href="#">苏子子二手交易网</a> All Rights Reserved.
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</footer>
		</div>

		<script src="js/jquery-1.11.2.min.js"></script>
		<script src="js/bootstrap.min.js"></script>

		<script src="assets/switcher/js/dmss.js"></script>

		<script src="js/jquery-ui.min.js"></script>
		<script src="js/modernizr.custom.js"></script>
		<script src="js/wow.min.js"></script>

		<!--bootstrap-select -->
		<script src="assets/bootstrap-select/bootstrap-select.min.js"></script>

		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

		<!-- Countdown Timer -->
		<script src="assets/countdown/dscountdown.min.js"></script>

		<!--Owl Carousel-->
		<script src="assets/owl-carousel/owl.carousel.min.js"></script>

		<!--bx slider-->
		<script src="assets/bxslider/jquery.bxslider.min.js"></script>

		<!-- slider-pro-master -->
		<script src="assets/slider-pro-master/js/jquery.sliderPro.min.js"></script>

		<script src="assets/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<script src="js/waypoints.min.js"></script>
		<script src="js/jquery.easypiechart.min.js"></script>
		<script src="js/jquery.spinner.min.js"></script>
		<script src="js/isotope.pkgd.min.js"></script>
		<script src="js/jquery.placeholder.min.js"></script>
		<script src="js/theme.js"></script>

	</body>
</html>