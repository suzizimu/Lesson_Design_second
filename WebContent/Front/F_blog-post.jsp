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
												<form action="#" method="post">
													<div class="form-group">
														<input id="searchQuery" type="search" placeholder="请输入商品名称">
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
			<section class="section-blog-post">
				<div class="b-page-header">
					<div class="container">
						<div class="row">
							<div class="col-sm-12 clearfix">
								<h3 class="page-title pull-left">news blog</h3>
								<div class="b-breadcrumbs pull-right">
									<ul class="list-unstyled">
										<li>
											<a href="#">home</a>
										</li>
										<li>
											<a href="blog-post.html">blog</a>
										</li>
										<li>
											<span>post details</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-sm-12 col-xs-12 col-md-9 col-lg-9">
							<div class="post-image wow fadeInUp">
								<div class="post-img-holder">
									<img src="media/blog/post-img-big.jpg" class="img-responsive" alt="/">
								</div>
								<div class="post-data">
									<span>25 dec 2015</span>
								</div>
							</div>
							<div class="b-posts-holder wow fadeInUp">
								<div class="b-post-main clearfix">
									<div class="post-caption">
										<div class="post-author">
											<span><i class="fa fa-user"></i>Admin</span>
											<span><i class="fa fa-comment-o"></i>12 Comments</span>
										</div>
										<div class="caption">
											<h5 class="heading-line">iphone 6s gets $50 price cut</h5>
											<div class="post-description">
												<p>
													Lorem ipsum dolor sit amet consectetu adipisicing elit sed eiusmod tempor incididunt ut labore eu dolor magna aliqua enim ad minim
													veam Lorem ipsum dolor sit amet consectetur adipisicing elit sed coips eiusmod tempor incideut acdunt uet labore et dolore magna
													aliqua. Ut sed ipsum due veniam quis nostrud exercitation Lorem ipsum dolor sit amet consectetur adipisicing elit, sed do eiusmod
													tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip
													ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
													Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt.
												</p>
												<div class="post-images">
													<img src="media/blog/post-img1.jpg" class="img-responsive" alt="/">
													<img src="media/blog/post-img2.jpg" class="img-responsive" alt="/">
												</div>
												<p>
													Elit sed eiusmod tempor incididunt ut labore eu dolor magna aliqua enim ad minim veam Lorem ipsum dolor sit amet consectetur
													adipisicing elit sed coips eiusmod tempor incideu dunt uet labore et dolore magna aliqua. Ut sed ipsum due veniam quis nostrud exe
													rcitation Lorem ipsum dolor sit amet, consectetur adipisicing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
													Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
													reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident sunt in culp
													qui officia deserunt.
												</p>
												<p>
													Mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium totam
													rem aperiam eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
													voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi
													nesciunt. Neque porro quisquam est qui dolorem ipsum quia dolor sit amet.
												</p>
											</div>
											<div class="b-socials full-socials clearfix">
												<ul class="list-unstyled">
													<li><a href="https://twitter.com/"><i class="fa fa-twitter fa-fw"></i>Tweet</a></li>
													<li><a href="https://www.facebook.com/"><i class="fa fa-facebook fa-fw"></i>Share</a></li>
													<li><a href="https://plus.google.com/"><i class="fa fa-google-plus fa-fw"></i>Google+</a></li>
													<li><a href="http://pinterest.com/"><i class="fa fa-pinterest fa-fw"></i>Pinterest</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="b-posts-switcher clearfix wow fadeInUp">
								<div class="switch-previous pull-left">
									<div class="switch-title">
										previous post
									</div>
									<div class="switch-body">
										<a href="#" class="switch-link">
											<i class="fa fa-chevron-left"></i>
											<span>Top 10 Best Android phones
												Buyers Guide: Dec 2015 Edition</span>
										</a>
									</div>
								</div>
								<div class="switch-next pull-right">
									<div class="switch-title">
										next post
									</div>
									<div class="switch-body">
										<a href="#" class="switch-link">
											<span>Buy the apple iphone 6s $499
												With discount Code</span>
											<i class="fa fa-chevron-right"></i>
										</a>
									</div>
								</div>
							</div>
							<div class="b-post-comments wow fadeInUp">
								<h3 class="heading-line">Comments <span>[2]</span></h3>
								<div class="b-comments-holder">
								
									<div class="comment-item">
										<div class="col-sm-1">
											<div class="userpic">
												<span>
													<img src="media/blog/userpics/user1.jpg" class="img-responsive" alt="/">
												</span>
											</div>
										</div>										
										<div class="col-sm-11">
											<div class="comment-body">
												<div class="comment-author">
													<span class="name">William Ben</span>
													<button class="comment-reply pull-right">reply</button>
													<span class="comment-date">december 31, 2015  -  02:36 pm</span>
												</div>
												<div class="comment-text">
													<p>
														Lorem ipsum dolor sit amet consectur adipisicing elitsed do eiusmod tempor incidiant ealnt labore orem ips um dolor sit amet consectetur adipisicing elit eiusmod incididunt. Lorem ipsum dolor sit amet consecteurm adipisicing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
													</p>
												</div>
											</div>
										</div>									
									</div>
									
									<div class="comment-item">
										<div class="col-sm-1">
											<div class="userpic">
												<span>
													<img src="media/blog/userpics/user2.jpg" class="img-responsive" alt="/">
												</span>
											</div>
										</div>
										<div class="col-sm-11">
											<div class="comment-body">
												<div class="comment-author">
													<span class="name">Sara Alex</span>
													<button class="comment-reply pull-right">reply</button>
													<span class="comment-date">december 31, 2015  -  02:36 pm</span>
												</div>
												<div class="comment-text">
													<p>
														Lorem ipsum dolor sit amet consectur adipisicing elitsed do eiusmod tempor incidiant ealnt labore orem ips um dolor sit amet consectetur adipisicing elit eiusmod incididunt. Lorem ipsum dolor sit amet consecteurm adipisicing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="b-post-reply wow fadeInUp">
								<h3 class="heading-line">
									leave a reply
								</h3>
								<form id="comment-reply-form" class="b-form" method="get" action="#">
									<div class="form-group">
										<div class="b-form-description">
											<p>
												Required fields are marked with *
											</p>
										</div>
										<div class="row">
											<div class="col-sm-6">
												<div>
													<input type="text" class="form-control" id="form-first-name" placeholder="Name *">
												</div>
												<div>
													<input type="text" class="form-control" id="form-last-name" placeholder="Email *">
												</div>
												<div>
													<input type="text" class="form-control" id="form-subject" placeholder="Website">
												</div>
											</div>
											<div class="col-sm-6">
												<div>
													<textarea id="form-comment" class="form-control" rows="6" placeholder="Comments"></textarea>
												</div>
												<div>
													<button type="submit" class="btn btn-default">Send comment</button>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-sm-12 col-xs-12 col-md-3 col-lg-3">
							<div class="lb-content lb-content-accordion">
								<div id="accordion" class="accordion-l-box wow fadeInRight enable-accordion" data-active="0" data-collapsible="true" data-height-style="content">
									<h3 class="accordion-header-mod">
										<span class="heading-line title-accordion-menu-item">Category</span>
										<span class="accordion-icon"></span>
									</h3>
									<div>
										<ul>
											<li class="active">
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Apple iPhone
													<span class="category-counter">[25]</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Samsung
													<span class="category-counter">[08]</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													HTC
													<span class="category-counter">[39]</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Blackberry
													<span class="category-counter">[50]</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Huawei
													<span class="category-counter">[17]</span>
												</a>
											</li>
											<li class="more">
												<span class="load-more">load more</span>
												<ul class="more-list">
													<li>
														<a href="#">
															<i class="fa fa-caret-square-o-right"></i>
															Samsung
															<span class="category-counter">[08]</span>
														</a>
													</li>
													<li>
														<a href="#">
															<i class="fa fa-caret-square-o-right"></i>
															HTC
															<span class="category-counter">[39]</span>
														</a>
													</li>
												</ul>
											</li>
										</ul>
									</div>
								</div>
								<div id="accordion2" class="accordion-l-box wow fadeInRight enable-accordion" data-active="0" data-collapsible="true" data-height-style="content">
									<h3>
										<span class="heading-line title-accordion-menu-item">browse by</span>
										<span class="accordion-icon"></span>
									</h3>
									<div>
										<ul>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													All Brands
												</a>
											</li>
											<li class="active">
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													New Arrivals
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Hot Deals
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Special Promotions
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													On Sale Phones
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													Top Sellers
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-caret-square-o-right"></i>
													In Stock Only
												</a>
											</li>
										</ul>
									</div>
								</div>
								<div class="l-box-mod wow fadeInRight">
									<h3 class="heading-line">Latest reviews</h3>
									<div class="l-box-content">
										<div class="b-latest-rev">
											<div class="latest-rev-img pull-left">
												<img src="media/blog/latest-prev/prev1.jpg" class="img-responsive" alt="/">
											</div>
											<div class="latest-rev-caption">
												<a class="rev-caption-title" href="#">Apple iphone 6s</a>
												<p>Amet cons elit sedu mod
													tempor incididunt ut</p>
												<div class="rating">
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star star-empty"><i class="fa fa-star-o"></i></span>
												</div>
											</div>
										</div>
									</div>
									<div class="l-box-content">
										<div class="b-latest-rev">
											<div class="latest-rev-img pull-left">
												<img src="media/blog/latest-prev/prev2.jpg" class="img-responsive" alt="/">
											</div>
											<div class="latest-rev-caption">
												<a class="rev-caption-title" href="#">Huawei nexus 6p</a>
												<p>Labore eou dolor magna
													aliqua enim ad minim</p>
												<div class="rating">
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star star-empty"><i class="fa fa-star-o"></i></span>
												</div>
											</div>
										</div>
									</div>
									<div class="l-box-content">
										<div class="b-latest-rev">
											<div class="latest-rev-img pull-left">
												<img src="media/blog/latest-prev/prev3.jpg" class="img-responsive" alt="/">
											</div>
											<div class="latest-rev-caption">
												<a class="rev-caption-title" href="#">htc one m9</a>
												<p>Magna aliqua ed ipsum
													due veniam quis
												</p>
												<div class="rating">
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star"><i class="fa fa-star"></i></span>
													<span class="star star-empty"><i class="fa fa-star-o"></i></span>
													<span class="star star-empty"><i class="fa fa-star-o"></i></span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="l-box-mod wow fadeInRight">
									<h3 class="heading-line">popular posts</h3>
									<div class="b-popular-post">
										<a class="popular-caption-title" href="#">Lifetime PlayStation 4 sales cross 30
											million mark
										</a>
										<span class="popular-date">31 december 2015</span>
									</div>
									<div class="b-popular-post">
										<a class="popular-caption-title" href="#">Microsoft's new app shows which of
											your Android apps are on Windows
										</a>
										<span class="popular-date">10 january 2016</span>
									</div>
									<div class="b-popular-post">
										<a class="popular-caption-title" href="#">Xiaomi smartwatch rumored to be
											outed at December 31 event
										</a>
										<span class="popular-date">18 january 2016</span>
									</div>
								</div>
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