<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>BLOG</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Blog Template">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">

<script defer
	src="https://use.fontawesome.com/releases/v5.7.1/js/all.js"
	integrity="sha384-eVEQC9zshBn0rFj4+TU78eNA19HMNigMviK/PU/FFjLXqa/GKPgX58rvt5Z8PLs7"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.14.2/styles/monokai-sublime.min.css">
<link id="theme-style" rel="stylesheet" href="../assets/css/theme-1.css">
<script src="//cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>
</head>

<body>
	<input type="hidden" id="test">
	<header class="header text-center">
		<h1 class="blog-name pt-lg-4 mb-0">
			<a href="/">YG1110 Blog</a>
		</h1>

		<nav class="navbar navbar-expand-lg navbar-dark">

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navigation" aria-controls="navigation"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div id="navigation" class="collapse navbar-collapse flex-column">
				<div class="profile-section pt-3 pt-lg-0">
					<img class="profile-image mb-3 rounded-circle mx-auto"
						src="${user.image}" alt="image">

					<div class="bio mb-3">
						<b>${user.introduction}<br>
							<div class="my-2 my-md-3">
								<a class="btn btn-link" href="/profile">내 프로필 수정하기</a>
							</div>
					</div>
					<ul class="social-list list-inline py-3 mx-auto">
						<li class="list-inline-item"><a href="#"><i
								class="fab fa-twitter fa-fw"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fab fa-linkedin-in fa-fw"></i></a></li>
						<li class="list-inline-item"><a
							href="https://github.com/yg1110"><i
								class="fab fa-github-alt fa-fw"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fab fa-stack-overflow fa-fw"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fab fa-codepen fa-fw"></i></a></li>
					</ul>
					<hr>
				</div>

				<ul class="navbar-nav flex-column text-left">
					<li class="nav-item"><a class="nav-link" href="/"><i
							class="fas fa-home fa-fw mr-2"></i>Blog Home <span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item active"><a class="nav-link" href="#"><i
							class="fas fa-bookmark fa-fw mr-2"></i>Blog Post</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fas fa-user fa-fw mr-2"></i>About Me</a></li>
				</ul>

				<div class="my-2 my-md-3">
					<a class="btn btn-primary" href="/BoardWriting">글쓰기</a>
				</div>
			</div>
		</nav>
	</header>

	<div class="main-wrapper">
		<section class="cta-section theme-bg-light py-5">
			<div class="container text-center">
				<h2 class="heading">게시글 추가</h2>
			</div>
		</section>
		<br>
		<section class="blog-list px-3 py-5 p-md-5">
			<div class="container">
				<form name="form" id="form" role="form" method="post"
					action="/addBoard.do" enctype="multipart/form-data">
					<sec:csrfInput />

					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="title" id="title"
							placeholder="제목을 입력해 주세요">
					</div>

					<div class="mb-3">
						<label for="reg_id">카테고리</label> <input type="text"
							class="form-control" name="category" id="reg_id"
							placeholder="카테고리를 입력해 주세요">
					</div>

					<div class="mb-3">
						<label for="content">내용</label>
						<textarea name="content" id="content"></textarea>
						<script>
							CKEDITOR.replace('content');
						</script>
					</div>
					<input type="file" name="file">

					<div>
						<input type="submit" class="btn btn-sm btn-primary" id="btnSave"
							style="float: right" value="저장">
					</div>
				</form>
			</div>
		</section>
		<br>
		<br>
		<br>
		<footer class="footer text-center py-2 theme-bg-dark">
			<small class="copyright">Designed with <i
				class="fas fa-heart" style="color: #fb866a;"></i> by <a
				href="http://themes.3rdwavemedia.com" target="_blank">Xiaoying
					Riley</a> for developers
			</small>
		</footer>

	</div>
	<script src="../assets/plugins/jquery-3.3.1.min.js"></script>
	<script src="../assets/plugins/popper.min.js"></script>
	<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.14.2/highlight.min.js"></script>
	<script src="../assets/js/blog.js"></script>
	<script src="../assets/js/demo/style-switcher.js"></script>
</body>
</html>