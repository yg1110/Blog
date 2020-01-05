<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>BLOG</title>

<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Blog Template">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">
<link rel="shortcut icon" href="favicon.ico">

<!-- FontAwesome JS-->
<script defer
	src="https://use.fontawesome.com/releases/v5.7.1/js/all.js"
	integrity="sha384-eVEQC9zshBn0rFj4+TU78eNA19HMNigMviK/PU/FFjLXqa/GKPgX58rvt5Z8PLs7"
	crossorigin="anonymous"></script>

<!-- Plugin CSS -->
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.14.2/styles/monokai-sublime.min.css">

<!-- Theme CSS -->
<link id="theme-style" rel="stylesheet" href="../assets/css/theme-1.css">


</head>

<body>
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
						src="../assets/images/정영길.jpg" alt="image">

					<div class="bio mb-3">
						<b>안녕하세요 저는 정영길입니다.<br> 이 블로그는 SpringBoot, MySQL,
							MongoDB, Redis로 제작되었습니다.<br>
							<div class="my-2 my-md-3">
								<a class="btn btn-link" href="#">내 프로필 수정하기</a>
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
					<a class="btn btn-primary" href="#">글쓰기</a>
				</div>
			</div>
		</nav>
	</header>

	<div class="main-wrapper">

		<article class="blog-post px-3 py-5 p-md-5">
			<div class="container">
				<header class="blog-post-header">
					<h2 class="title mb-2">${board.title}</h2>
					<div class="meta mb-3">
						<span class="date">${board.date}</span><span class="time">${board.category}</span>
					</div>
				</header>

				<div class="blog-post-body">
					<figure class="blog-banner">
						<a href="https://made4dev.com"><img class="img-fluid"
							src="${board.image}" alt="image"></a>
						<!-- <figcaption class="mt-2 text-center image-caption">
							Image Credit: <a href="https://made4dev.com?ref=devblog"
								target="_blank">made4dev.com (Premium Programming T-shirts)</a>
						</figcaption> -->
					</figure>
					<p>${board.content}</p>

					<h3 class="mt-5 mb-3">Code Block Example</h3>
					<p>
						You can get more info at <a href="https://highlightjs.org/"
							target="_blank">https://highlightjs.org/</a>.
					</p>
					<pre>
					    <code>
function $initHighlight(block, cls) {
  try {
    if (cls.search(/\bno\-highlight\b/) != -1)
      return process(block, true, 0x0F) +
             ` class="${cls}"`;
  } catch (e) {
    /* handle exception */
  }
  for (var i = 0 / 2; i < classes.length; i++) {
    if (checkCondition(classes[i]) === undefined)
      console.log('undefined');
  }
}

export  $initHighlight;
					    </code>
				    </pre>
					<h3 class="mt-5 mb-3">Typography</h3>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
						Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
						penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
					<h5 class="my-3">Bullet Points:</h5>
					<ul class="mb-5">
						<li class="mb-2">Lorem ipsum dolor sit amet consectetuer.</li>
						<li class="mb-2">Aenean commodo ligula eget dolor.</li>
						<li class="mb-2">Aenean massa cum sociis natoque penatibus.</li>
					</ul>
					<ol class="mb-5">
						<li class="mb-2">Lorem ipsum dolor sit amet consectetuer.</li>
						<li class="mb-2">Aenean commodo ligula eget dolor.</li>
						<li class="mb-2">Aenean massa cum sociis natoque penatibus.</li>
					</ol>
					<h5 class="my-3">Quote Example:</h5>
					<blockquote class="blockquote m-lg-5 py-3 pl-4 px-lg-5">
						<p class="mb-2">You might not think that programmers are
							artists, but programming is an extremely creative profession.
							It's logic-based creativity.</p>
						<footer class="blockquote-footer">John Romero</footer>
					</blockquote>

					<h5 class="my-3">Table Example:</h5>
					<table class="table table-striped my-5">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">Handle</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>

					<h3 class="mt-5 mb-3">Video Example</h3>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
						Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
						penatibus et magnis dis parturient montes, nascetur ridiculus mus.
						Donec quam felis, ultricies nec, pellentesque eu, pretium quis,
						sem. Nulla consequat massa quis enim.</p>

					<div class="embed-responsive embed-responsive-16by9">
						<iframe width="560" height="315"
							src="https://www.youtube.com/embed/hnCmSXCZEpU"></iframe>
					</div>

				</div>

				<nav class="blog-nav nav nav-justified my-5">
					<a class="nav-link-prev nav-item nav-link rounded-left"
						href="index.html">Previous<i
						class="arrow-prev fas fa-long-arrow-alt-left"></i></a> <a
						class="nav-link-next nav-item nav-link rounded-right"
						href="blog-list.html">Next<i
						class="arrow-next fas fa-long-arrow-alt-right"></i></a>
				</nav>

					<script id="cosmosfarm-comments-script" type="text/javascript"
						src="https://plugin.cosmosfarm.com/comments.js"></script>
					<div id="cosmosfarm-comments" data-plugin-id="1016820529475808"
						data-href="http://49.143.130.142/:8080/single/${board.id}"
						data-width="790" data-row="10">
						<a href="http://www.cosmosfarm.com/plugin/comments">코스모스팜 소셜댓글</a>
					</div>
			</div>
		</article>

		<footer class="footer text-center py-2 theme-bg-dark">
			<small class="copyright"> Designed with <i class="fas fa-heart" style="color: #fb866a;"></i>
				by <a href="http://themes.3rdwavemedia.com" target="_blank">YG1110</a> for developers
			</small>
		</footer>
	</div>

	<div id="config-panel" class="config-panel d-none d-lg-block">
		<div class="panel-inner">
			<a id="config-trigger"
				class="config-trigger config-panel-hide text-center" href="#"><i
				class="fas fa-cog fa-spin mx-auto" data-fa-transform="down-6"></i></a>
			<h5 class="panel-title">Choose Colour</h5>
			<ul id="color-options" class="list-inline mb-0">
				<li class="theme-1 active list-inline-item"><a
					data-style="../assets/css/theme-1.css" href="#"></a></li>
				<li class="theme-2  list-inline-item"><a
					data-style="../assets/css/theme-2.css" href="#"></a></li>
				<li class="theme-3  list-inline-item"><a
					data-style="../assets/css/theme-3.css" href="#"></a></li>
				<li class="theme-4  list-inline-item"><a
					data-style="../assets/css/theme-4.css" href="#"></a></li>
				<li class="theme-5  list-inline-item"><a
					data-style="../assets/css/theme-5.css" href="#"></a></li>
				<li class="theme-6  list-inline-item"><a
					data-style="../assets/css/theme-6.css" href="#"></a></li>
				<li class="theme-7  list-inline-item"><a
					data-style="../assets/css/theme-7.css" href="#"></a></li>
				<li class="theme-8  list-inline-item"><a
					data-style="../assets/css/theme-8.css" href="#"></a></li>
			</ul>
			<a id="config-close" class="close" href="#"><i
				class="fa fa-times-circle"></i></a>
		</div>
		<!--//panel-inner-->
	</div>
	<!--//configure-panel-->

	<!-- Javascript -->
	<script src="../assets/plugins/jquery-3.3.1.min.js"></script>
	<script src="../assets/plugins/popper.min.js"></script>
	<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>

	<!-- Page Specific JS -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.14.2/highlight.min.js"></script>

	<!-- Custom JS -->
	<script src="../assets/js/blog.js"></script>

	<!-- Style Switcher (REMOVE ON YOUR PRODUCTION SITE) -->
	<script src="../assets/js/demo/style-switcher.js"></script>


</body>
</html>

