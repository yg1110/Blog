<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="kr">
<head>
<title>yg1110 Blog</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Minimal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="/login/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Custom Theme files -->
<link href="/login/css/style.css" rel='stylesheet' type='text/css' />
<link href="/login/css/font-awesome.css" rel="stylesheet">
<script src="/login/js/jquery.min.js"> </script>
<script src="/login/js/bootstrap.min.js"> </script>

</head>
<body>
	<div class="login">
		<h1>
			<a href="index.html">Y-BLOG</a>
		</h1>
		<div class="login-bottom">
			<h2>Login</h2>
			<form action="/login" method="post">
				<sec:csrfInput />
				<div class="col-md-12">
					<div class="login-mail">
						<input type="text" placeholder="Email" required="" name="username">
						<i class="fa fa-envelope"></i>
					</div>
					<div class="login-mail">
						<input type="password" placeholder="Password" required=""
							name="password"> <i class="fa fa-lock"></i>
					</div>

					<a class="news-letter" href="#"> <label class="checkbox1">
							<input type="checkbox" name="checkbox"> <i></i>Forget
							Password
					</label>
					</a>
					<div class="col-md-12 login-do">
						<label class="hvr-shutter-in-horizontal login-sub"> <input
							type="submit" value="login">
						</label> <a href="/signup"><p>Do not have an account?</p></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</form>
		</div>
	</div>
	<div class="copy-right">
		<p>&copy; 2019 yg1110. All Rights Reserved.</p>
	</div>
	<script src="/login/js/jquery.nicescroll.js"></script>
	<script src="/login/js/scripts.js"></script>
</body>
</html>