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
						//购物车id总和
						String sql66="select * from car where buyer='"+session.getAttribute("member_name")+"'";
					    List<Map<String, Object>> list66=DBUtil.list(sql66);
						String idAll="";
						String idAll2="";
						for(int i=0;i<list66.size();i++){
							
							idAll+=list66.get(i).get("GoodsID")+","; //根据购物车获取 商品id的集合。
							idAll2+=list66.get(i).get("ID")+",";//根据购物车获取 购物车id的集合
						}		
						
						session.setAttribute("idAll",idAll);
						session.setAttribute("idAll2",idAll2);		
					    %>
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
															<a class="product-name" href="product-details.html"><%=list3.get(i).get("GoodsName") %></a>
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
												<a  href="../pay_add.so"><button type="button" class="btn btn-primary-color2 btn-sm">付款</button></a>
											</div>
										</div>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</header>
			  <section class="section-404">
				<div class="container">
					<div class="row">
						<div class="col-sm-12 text-center text-b-404 wow fadeInUp">
							<div class="b-404">
								<div class="image">
									<div class="empty-b">
										<div>
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 118 168"><style type="text/css">
													.st0{fill-rule:evenodd;clip-rule:evenodd;fill:#222222;}
												</style><g id="_x34_04"><path class="st0" d="M66.4 33.2V2.7L50.9 33.2H66.4zM34 134.1h32.5v-32.5H34V134.1zM34 66.7h32.5V34.2h-16L34 66.7zM65.8 67.9H34v32.5h15.4L65.8 67.9zM32.7 100.4V69.9l-15.4 30.5H32.7zM0.3 134.1h32.5v-32.5H16.4L0.3 134.1zM67.7 100.4h32.5V67.9H67.7V100.4zM101.1 101.6v32.5h16.5v-32.5H101.1zM67.7 167.7h32.5v-32.5H67.7V167.7zM67.7 33.2h32.5V0.7H67.7V33.2zM67.7 66.7h32.5V34.2H67.7V66.7zM67.7 134.1h32.5v-32.5H67.7V134.1z"/></g></svg>
										</div>
										<div class="zero-change">
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 101 168"><style type="text/css">
													.st0{fill-rule:evenodd;clip-rule:evenodd;}
												</style><path class="st0" d="M0.8 66.7h32.5V34.2H0.8V66.7zM0.8 100.4h32.5V67.9H0.8V100.4zM0.8 151.5c0 4.5 1.5 8.3 4.6 11.5 3.1 3.2 6.9 4.7 11.4 4.7h16.5v-32.5H0.8V151.5zM0.8 134.1h32.5v-32.5H0.8V134.1zM34.5 167.7H67v-32.5H34.5V167.7zM5.6 5.6c-3.2 3.2-4.7 7-4.7 11.4v16.2h32.5V0.7H16.8C12.5 0.7 8.7 2.4 5.6 5.6zM34.5 33.2H67V0.7H34.5V33.2zM95.9 5.6C92.8 2.4 89 0.7 84.7 0.7H68.2v32.5h32.5V17C100.7 12.7 99.1 8.9 95.9 5.6zM68.2 100.4h32.5V67.9H68.2V100.4zM68.2 66.7h32.5V34.2H68.2V66.7zM68.2 167.7h16.5c4.5 0 8.3-1.6 11.4-4.7 3.1-3.2 4.6-7 4.6-11.5v-16.2H68.2V167.7zM68.2 134.1h32.5v-32.5H68.2V134.1z"/></svg>
										</div>
										<div>
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 118 168"><style type="text/css">
													.st0{fill-rule:evenodd;clip-rule:evenodd;fill:#222222;}
												</style><path class="st0" d="M0.4 134.1h16.5v-32.5H0.4V134.1zM17.9 167.7h32.5v-32.5H17.9V167.7zM17.9 100.4h32.5V67.9H17.9V100.4zM17.9 134.1h32.5v-32.5H17.9V134.1zM85.3 69.9v30.5h15.4L85.3 69.9zM51.6 2.7v30.5h15.5L51.6 2.7zM51.6 34.2v32.5H84L67.6 34.2H51.6zM17.9 66.7h32.5V34.2H17.9V66.7zM68.7 100.4H84V67.9H52.2L68.7 100.4zM101.6 101.6H85.3v32.5h32.5L101.6 101.6zM17.9 33.2h32.5V0.7H17.9V33.2zM51.6 134.1H84v-32.5H51.6V134.1z"/></svg>
										</div>
									</div>
								</div>
								<p class="text-404">
									Oops!!! We cannot found the page you have requested.
								</p>
								<a href="home-1.html" class="btn btn-primary-color2 btn-sm">go to homepage</a>
							</div>
						</div>
						<div class="b-404-form-holder col-sm-10 text-center wow fadeInUp">
							<form id="404-form" class="b-form" method="get" action="404.html#">
								<div class="form-group">
									<div class="b-form-description">
										<p>
											OR try searching a page / product
										</p>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<input type="text" class="form-control" id="form-search">
										</div>
										<div class="col-sm-12">
											<button type="submit" class="btn btn-default">Search now</button>
										</div>
									</div>
								</div>
							</form>
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
		<script src="js/jquery.placeholder.min.js"></script>
		<script src="js/theme.js"></script>

	</body>
</html>