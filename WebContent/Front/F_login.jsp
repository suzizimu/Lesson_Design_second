<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<base href="<%=path%>/Front/">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会员登录</title>
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet" type="text/css" href="css/account.css" />

</head>
<body>

<div class="login">
	<i ripple>
		<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
		<path fill="#C7C7C7" d="m12,2c-5.52,0-10,4.48-10,10s4.48,10,10,10,10-4.48,10-10-4.48-10-10-10zm1,17h-2v-2h2zm2.07-7.75-0.9,0.92c-0.411277,0.329613-0.918558,0.542566-1.20218,1.03749-0.08045,0.14038-0.189078,0.293598-0.187645,0.470854,0.02236,2.76567,0.03004-0.166108,0.07573,1.85002l-1.80787,0.04803-0.04803-1.0764c-0.02822-0.632307-0.377947-1.42259,1.17-2.83l1.24-1.26c0.37-0.36,0.59-0.86,0.59-1.41,0-1.1-0.9-2-2-2s-2,0.9-2,2h-2c0-2.21,1.79-4,4-4s4,1.79,4,4c0,0.88-0.36,1.68-0.930005,2.25z"/>
		</svg>
	</i>
	<div class="photo">
	</div>
	<span>会员登录</span>
	<form action="/Lesson_Design_second/login.so" id="login-form">
		<div id="u" class="form-group">
		  <input id="username" spellcheck=false class="form-control" name="username" type="text" size="18" alt="login" required="">
		  <span class="form-highlight"></span>
		  <span class="form-bar"></span>
		  <label for="username" class="float-label">会员名</label>
		  <erroru>
			会员名不能为空
			<i>		
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
					<path d="M0 0h24v24h-24z" fill="none"/>
					<path d="M1 21h22l-11-19-11 19zm12-3h-2v-2h2v2zm0-4h-2v-4h2v4z"/>
				</svg>
			</i>
		  </erroru>
		</div>
		<div id="p" class="form-group">
		  <input id="password" class="form-control" spellcheck=false name="password" type="password" size="18" alt="login" required="">
		  <span class="form-highlight"></span>
		  <span class="form-bar"></span>
		  <label for="password" class="float-label">密码</label>
		  <errorp>
			密码不能为空
			<i>		
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
					<path d="M0 0h24v24h-24z" fill="none"/>
					<path d="M1 21h22l-11-19-11 19zm12-3h-2v-2h2v2zm0-4h-2v-4h2v4z"/>
				</svg>
			</i>
		  </errorp>
		</div>
		<div class="form-group">
		${msg}
		<button type="submit">登录</button>
		</div>
	</form>
</div>


<script type="text/javascript" src='js/jquery.min.js'></script>
<script type="text/javascript">
$(document).ready(function () {
	$(function () {
		var animationLibrary = 'animate';
		$.easing.easeOutQuart = function (x, t, b, c, d) {
			return -c * ((t = t / d - 1) * t * t * t - 1) + b;
		};
		$('[ripple]:not([disabled],.disabled)').on('mousedown', function (e) {
			var button = $(this);
			var touch = $('<touch><touch/>');
			var size = button.outerWidth() * 1.8;
			var complete = false;
			$(document).on('mouseup', function () {
				var a = { 'opacity': '0' };
				if (complete === true) {
					size = size * 1.33;
					$.extend(a, {
						'height': size + 'px',
						'width': size + 'px',
						'margin-top': -size / 2 + 'px',
						'margin-left': -size / 2 + 'px'
					});
				}
				touch[animationLibrary](a, {
					duration: 500,
					complete: function () {
						touch.remove();
					},
					easing: 'swing'
				});
			});
			touch.addClass('touch').css({
				'position': 'absolute',
				'top': e.pageY - button.offset().top + 'px',
				'left': e.pageX - button.offset().left + 'px',
				'width': '0',
				'height': '0'
			});
			button.get(0).appendChild(touch.get(0));
			touch[animationLibrary]({
				'height': size + 'px',
				'width': size + 'px',
				'margin-top': -size / 2 + 'px',
				'margin-left': -size / 2 + 'px'
			}, {
				queue: false,
				duration: 500,
				'easing': 'easeOutQuart',
				'complete': function () {
					complete = true;
				}
			});
		});
	});
	var username = $('#username'), password = $('#password'), erroru = $('erroru'), errorp = $('errorp'), submit = $('#submit'), udiv = $('#u'), pdiv = $('#p');
	username.blur(function () {
		if (username.val() == '') {
			udiv.attr('errr', '');
		} else {
			udiv.removeAttr('errr');
		}
	});
	password.blur(function () {
		if (password.val() == '') {
			pdiv.attr('errr', '');
		} else {
			pdiv.removeAttr('errr');
		}
	});
	submit.on('click', function (event) {
		event.preventDefault();
		if (username.val() == '') {
			udiv.attr('errr', '');
		} else {
			udiv.removeAttr('errr');
		}
		if (password.val() == '') {
			pdiv.attr('errr', '');
		} else {
			pdiv.removeAttr('errr');
		}
	});
});
</script>
</body>
</html>