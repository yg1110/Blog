<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<title>yg1110 Blog</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="/login/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<link href="/login/css/style.css" rel='stylesheet' type='text/css' />
<link href="/login/css/font-awesome.css" rel="stylesheet" />
<script src="/login/js/jquery.min.js"></script>
<script src="/login/js/bootstrap.min.js"></script>
<script src="/login/js/jquery.nicescroll.js"></script>
<script src="/login/js/scripts.js"></script>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="login">
		<h1>
			<a href="index.html">Y-BLOG</a>
		</h1>
		<div class="login-bottom">
			<form action="/login" method="post">
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

					<div class="col-md-12 login-do">
						<label class="hvr-shutter-in-horizontal login-sub"> <input
							type="submit" value="로그인">
						</label> <a href="/signup"><p>회원가입</p></a> <a href="#" data-toggle="modal"
							data-target="#myModal"><p>아이디 / 비밀번호 찾기</p></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</form>
		</div>
	</div>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title">아이디 / 비밀번호 찾기</h4>
				</div>
				<div id="findpassword">
					<sec:csrfInput />
					<div class="modal-body">
						<div class="col-md-">
							<label>아이디</label>
							<div class="login-mail">
								<input type="text" required="" name="username" id="username">
								<i class="fa fa-envelope"></i>
							</div>
							<label>비밀번호 찾기 질문</label>
							<div class="login-mail">
								<select name="passwordQ" id="passwordQ">
									<option value="기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
									<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
									<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
									<option value="타인이 모르는 신체 비밀이 있다면?">타인이 모르는 신체 비밀이
										있다면?</option>
									<option value="받았던 선물 중 기억에 남는 독특한 선물은?">받았던 선물 중 기억에
										남는 독특한 선물은?</option>
									<option value="유년시절 가장 생각나는 친구 이름은?">유년시절 가장 생각나는 친구
										이름은?</option>
									<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
									<option value="읽은 책 중에서 좋아하는 구절이 있다면?">읽은 책 중에서 좋아하는
										구절이 있다면?</option>
									<option value="자신이 두 번째로 존경하는 인물은?">자신이 두 번째로 존경하는
										인물은?</option>
									<option value="친구들에게 공개하지 않은 어릴 적 별명이 있다면?">친구들에게 공개하지
										않은 어릴 적 별명이 있다면?</option>
									<option value="초등학교 때 기억에 남는 짝꿍 이름은?">초등학교 때 기억에 남는 짝꿍
										이름은?</option>
									<option value="다시 태어나면 되고 싶은 것은?">다시 태어나면 되고 싶은 것은?</option>
									<option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
									<option value="추억하고 싶은 날짜가 있다면?">추억하고 싶은 날짜가 있다면?</option>
									<option value="졸업한 고등학교는?">졸업한 고등학교는?</option>
								</select>
							</div>
							<label>비밀번호 확인 답변</label>
							<div class="login-mail">
								<input type="text" required="" name="passwordA" id="passwordA">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-sm btn-primary"
							style="float: right" value="전송" onclick="findpassword()">
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="copy-right">
		<p>&copy; 2019 yg1110. All Rights Reserved.</p>
	</div>

	<script type="text/javascript">
		function findpassword(){

			console.log($('#username').val());
			console.log($('#passwordQ').val());
			console.log($('#passwordA').val());

			$.ajax({
				type : "GET",
				url : "/findpasswordPOST",
				dataType : "text",
				data:{
					'username' : $('#username').val(),
					'passwordQ' : $('#passwordQ').val(),
					'passwordA' : $('#passwordA').val()
				},
				error : function() {
					console.log('통신실패!!');
				},
				success : function(data) {
					if(data==""){
						alert('해당사용자가 존재하지 않거나, 비밀번호가 맞지않습니다.');
					}
					else{
						alert('비밀번호가 "' + data + '"로 변경되었습니다. 로그인후 비밀번호를 바꿔주세요');
					}
				}
			});
		}
	</script>

</body>
</html>