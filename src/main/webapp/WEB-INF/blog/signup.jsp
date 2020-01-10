<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<title>Minimal an Admin Panel Category Flat Bootstrap Responsive
	Website Template | Signup :: w3layouts</title>
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
			<form action="/regi" method="post">
				<sec:csrfInput />

				<div class="col-md-12">
					<label>아이디</label>
					<div class="login-mail">
						<input type="text" required="" name="username"> <i
							class="fa fa-envelope"></i>
					</div>
					<label>비밀번호</label>
					<div class="login-mail">
						<input type="password" required="" name="password"> <i
							class="fa fa-lock"></i>
					</div>
					<label>비밀번호 확인</label>
					<div class="login-mail">
						<input type="password" required=""> <i class="fa fa-lock"></i>
					</div>
					<label>이름</label>
					<div class="login-mail">
						<input type="text" required="" name="name">
					</div>

					<label>휴대전화</label>
					<div class="login-mail2">
						<input type="number" placeholder="숫자만 입력해주세요." required=""
							name="phone"> <input type="button"
							class="btn btn-success" value="인증번호받기">
					</div>

					<div class="login-mail">
						<input type="text" placeholder="인증번호를 입력해주세요">
					</div>
					<input type="hidden" value="2" name="auth"> <a
						class="news-letter" href="#"> <label class="checkbox1">
							<input type="checkbox" name="checkbox"> <i></i> 이용약관 동의
					</label>
					</a>
					<div class="col-md-12 login-do">
						<label class="hvr-shutter-in-horizontal"> <input
							type="submit" value="Submit">
						</label> <a href="/"><p>Already register</p></a>
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

