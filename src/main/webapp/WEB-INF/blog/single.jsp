<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<title>yg1110's Blog</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/blog/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/blog/css/animate.css">

<link rel="stylesheet" href="/blog/css/owl.carousel.min.css">
<link rel="stylesheet" href="/blog/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/blog/css/magnific-popup.css">

<link rel="stylesheet" href="/blog/css/aos.css">

<link rel="stylesheet" href="/blog/css/ionicons.min.css">

<link rel="stylesheet" href="/blog/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/blog/css/jquery.timepicker.css">


<link rel="stylesheet" href="/blog/css/flaticon.css">
<link rel="stylesheet" href="/blog/css/icomoon.css">
<link rel="stylesheet" href="/blog/css/style.css">
</head>
<body>
	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="/list">Home</a></li>
					<li class="colorlib-active"><a href="/findAllBoard">Blog</a></li>
					<li><a href="/chat">Chat</a></li>					
				</ul>

			</nav>

			<div class="colorlib-footer">
				<h1 id="colorlib-logo" class="mb-4">
					<a href="index.html"
						style="background-image: url(/blog/images/bg_1.jpg);">YG1110</a>
				</h1>
				<p class="pfooter">
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved<br> This template is made with <i
						class="icon-heart" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">YG1110</a>
				</p>
			</div>
		</aside>
		<!-- END COLORLIB-ASIDE -->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-lg-8 px-md-5 py-5">
							<div class="row pt-md-4">
								<h1 class="mb-3">${board.title}</h1>
								<p>${board.content}</p>
								<p>
									<img src="${board.image}" alt="" class="img-fluid">
								</p>
								<p style="color: rgb(255, 255, 255, 0);">${board.content}</p>

								<div class="tag-widget post-tag-container mb-5 mt-5">
									<div class="tagcloud">
										<a href="#" class="tag-cloud-link">Life</a> <a href="#"
											class="tag-cloud-link">Sport</a> <a href="#"
											class="tag-cloud-link">Tech</a> <a href="#"
											class="tag-cloud-link">Travel</a>
									</div>
								</div>

								<div class="pt-5 mt-5">
									<h3 class="mb-5 font-weight-bold">${board.comment}
										Comments</h3>
										<c:forEach var="c" items="${comment}">
									<ul class="comment-list">
											<li class="comment">
												<div class="vcard bio">
													<img src="${c.image}" alt="Image placeholder">
												</div>
												<div class="comment-body">
													<h3>${c.name}</h3>
													<div class="meta">${c.date}</div>
													<p>${c.content}</p>
													<p>
														<a href="#" class="reply">Reply</a>
													</p>
												</div>
											</li>
									</ul>
										</c:forEach>
									<!-- 									<ul class="comment-list">
										<li class="comment">
											<div class="vcard bio">
												<img src="/blog/images/person_1.jpg" alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>John Doe</h3>
												<div class="meta">October 03, 2018 at 2:21pm</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Pariatur quidem laborum necessitatibus, ipsam impedit
													vitae autem, eum officia, fugiat saepe enim sapiente iste
													iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
												<p>
													<a href="#" class="reply">Reply</a>
												</p>
											</div>

											<ul class="children">
												<li class="comment">
													<div class="vcard bio">
														<img src="/blog/images/person_1.jpg"
															alt="Image placeholder">
													</div>
													<div class="comment-body">
														<h3>John Doe</h3>
														<div class="meta">October 03, 2018 at 2:21pm</div>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing
															elit. Pariatur quidem laborum necessitatibus, ipsam
															impedit vitae autem, eum officia, fugiat saepe enim
															sapiente iste iure! Quam voluptas earum impedit
															necessitatibus, nihil?</p>
														<p>
															<a href="#" class="reply">Reply</a>
														</p>
													</div>


													<ul class="children">
														<li class="comment">
															<div class="vcard bio">
																<img src="/blog/images/person_1.jpg"
																	alt="Image placeholder">
															</div>
															<div class="comment-body">
																<h3>John Doe</h3>
																<div class="meta">October 03, 2018 at 2:21pm</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipisicing elit. Pariatur quidem laborum
																	necessitatibus, ipsam impedit vitae autem, eum officia,
																	fugiat saepe enim sapiente iste iure! Quam voluptas
																	earum impedit necessitatibus, nihil?</p>
																<p>
																	<a href="#" class="reply">Reply</a>
																</p>
															</div>

															<ul class="children">
																<li class="comment">
																	<div class="vcard bio">
																		<img src="/blog/images/person_1.jpg"
																			alt="Image placeholder">
																	</div>
																	<div class="comment-body">
																		<h3>John Doe</h3>
																		<div class="meta">October 03, 2018 at 2:21pm</div>
																		<p>Lorem ipsum dolor sit amet, consectetur
																			adipisicing elit. Pariatur quidem laborum
																			necessitatibus, ipsam impedit vitae autem, eum
																			officia, fugiat saepe enim sapiente iste iure! Quam
																			voluptas earum impedit necessitatibus, nihil?</p>
																		<p>
																			<a href="#" class="reply">Reply</a>
																		</p>
																	</div>
																</li>
															</ul>
														</li>
													</ul>
												</li>
											</ul>
										</li>
									</ul> -->
									<!-- END comment-list -->
								</div>
							</div>
							<!-- END-->
						</div>
						<div class="col-lg-4 sidebar ftco-animate bg-light pt-5">
							<div class="sidebar-box pt-md-4">
								<form action="#" class="search-form">
									<div class="form-group">
										<span class="icon icon-search"></span> <input type="text"
											class="form-control"
											placeholder="Type a keyword and hit enter">
									</div>
								</form>
							</div>
							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Categories</h3>
								<ul class="categories">
									<li><a href="#">Fashion <span>(6)</span></a></li>
									<li><a href="#">Technology <span>(8)</span></a></li>
									<li><a href="#">Travel <span>(2)</span></a></li>
									<li><a href="#">Food <span>(2)</span></a></li>
									<li><a href="#">Photography <span>(7)</span></a></li>
								</ul>
							</div>

							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Popular Articles</h3>
								<div class="block-21 mb-4 d-flex">
									<a class="blog-img mr-4"
										style="background-image: url(/blog/images/image_1.jpg);"></a>
									<div class="text">
										<h3 class="heading">
											<a href="#">Even the all-powerful Pointing has no control</a>
										</h3>
										<div class="meta">
											<div>
												<a href="#"><span class="icon-calendar"></span> June 28,
													2019</a>
											</div>
											<div>
												<a href="#"><span class="icon-person"></span> Dave Lewis</a>
											</div>
											<div>
												<a href="#"><span class="icon-chat"></span> 19</a>
											</div>
										</div>
									</div>
								</div>
								<div class="block-21 mb-4 d-flex">
									<a class="blog-img mr-4"
										style="background-image: url(/blog/images/image_2.jpg);"></a>
									<div class="text">
										<h3 class="heading">
											<a href="#">Even the all-powerful Pointing has no control</a>
										</h3>
										<div class="meta">
											<div>
												<a href="#"><span class="icon-calendar"></span> June 28,
													2019</a>
											</div>
											<div>
												<a href="#"><span class="icon-person"></span> Dave Lewis</a>
											</div>
											<div>
												<a href="#"><span class="icon-chat"></span> 19</a>
											</div>
										</div>
									</div>
								</div>
								<div class="block-21 mb-4 d-flex">
									<a class="blog-img mr-4"
										style="background-image: url(/blog/images/image_3.jpg);"></a>
									<div class="text">
										<h3 class="heading">
											<a href="#">Even the all-powerful Pointing has no control</a>
										</h3>
										<div class="meta">
											<div>
												<a href="#"><span class="icon-calendar"></span> June 28,
													2019</a>
											</div>
											<div>
												<a href="#"><span class="icon-person"></span> Dave Lewis</a>
											</div>
											<div>
												<a href="#"><span class="icon-chat"></span> 19</a>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Tag Cloud</h3>
								<ul class="tagcloud">
									<a href="#" class="tag-cloud-link">animals</a>
									<a href="#" class="tag-cloud-link">human</a>
									<a href="#" class="tag-cloud-link">people</a>
									<a href="#" class="tag-cloud-link">cat</a>
									<a href="#" class="tag-cloud-link">dog</a>
									<a href="#" class="tag-cloud-link">nature</a>
									<a href="#" class="tag-cloud-link">leaves</a>
									<a href="#" class="tag-cloud-link">food</a>
								</ul>
							</div>

							<div class="sidebar-box subs-wrap img"
								style="background-image: url(/blog/images/bg_1.jpg);">
								<div class="overlay"></div>
								<h3 class="mb-4 sidebar-heading">Newsletter</h3>
								<p class="mb-4">Far far away, behind the word mountains, far
									from the countries Vokalia</p>
								<form action="#" class="subscribe-form">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="Email Address"> <input type="submit"
											value="Subscribe" class="mt-2 btn btn-white submit">
									</div>
								</form>
							</div>

							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Archives</h3>
								<ul class="categories">
									<li><a href="#">December 2018 <span>(10)</span></a></li>
									<li><a href="#">September 2018 <span>(6)</span></a></li>
									<li><a href="#">August 2018 <span>(8)</span></a></li>
									<li><a href="#">July 2018 <span>(2)</span></a></li>
									<li><a href="#">June 2018 <span>(7)</span></a></li>
									<li><a href="#">May 2018 <span>(5)</span></a></li>
								</ul>
							</div>


							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Paragraph</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Ducimus itaque, autem necessitatibus voluptate quod mollitia
									delectus aut.</p>
							</div>
						</div>
						<!-- END COL -->
					</div>
				</div>
			</section>
		</div>
		<!-- END COLORLIB-MAIN -->
	</div>
	<!-- END COLORLIB-PAGE -->

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="/blog/js/jquery.min.js"></script>
	<script src="/blog/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/blog/js/popper.min.js"></script>
	<script src="/blog/js/bootstrap.min.js"></script>
	<script src="/blog/js/jquery.easing.1.3.js"></script>
	<script src="/blog/js/jquery.waypoints.min.js"></script>
	<script src="/blog/js/jquery.stellar.min.js"></script>
	<script src="/blog/js/owl.carousel.min.js"></script>
	<script src="/blog/js/jquery.magnific-popup.min.js"></script>
	<script src="/blog/js/aos.js"></script>
	<script src="/blog/js/jquery.animateNumber.min.js"></script>
	<script src="/blog/js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="/blog/js/google-map.js"></script>
	<script src="/blog/js/main.js"></script>

</body>
</html>