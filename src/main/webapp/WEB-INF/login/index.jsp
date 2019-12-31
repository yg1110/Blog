<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr" xmlns:th="http://www.typeleaf.org">
<head>
<title>yg1110 Blog</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Minimal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="/main/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Custom Theme files -->
<link href="/main/css/style.css" rel='stylesheet' type='text/css' />
<link href="/main/css/font-awesome.css" rel="stylesheet">
<script src="/main/js/jquery.min.js"> </script>
<script src="/main/js/bootstrap.min.js"> </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
	<div class="login">
		<h1>
			<a href="index.html">Y-BLOG</a>
		</h1>
		<div class="login-bottom">
			<h2>Login</h2>
			<form th:action="@{/login}" method="post">
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
			<div th:if="${param.error}" class="alert alert-danger" role="alert">
		            Invalid username and password.
		        </div>
		        <div th:if="${param.logout}" class="alert alert-success" role="alert">
		            You have been logged out.
		        </div>
		</div>
	</div>
	<div class="copy-right">
		<p>&copy; 2019 yg1110. All Rights Reserved.</p>
	</div>
	<script src="/main/js/jquery.nicescroll.js"></script>
	<script src="/main/js/scripts.js"></script>
</body>
</html>

