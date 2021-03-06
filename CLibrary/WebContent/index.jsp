<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/index.css">
<title>トップページの例</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
		<h2>CLibrary</h2>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item px-5 active"><a class="nav-link"
					href="/CLibrary/WelcomeServlet"><h4>Home</h4></a></li>
				<li class="nav-item mt-1"><form name="show" method="post"
						action="/CLibrary/WelcomeServlet?target=select">
						<a class="nav-link" href="javascript:show.submit()"><h5>書籍を探す</h5></a>
					</form></li>
			</ul>
			<div class="form-inline my-2 my-lg-0">
				<a class="right_list_new_user"
					href="/CLibrary/LoginServlet?target=register">新規登録</a>
			</div>
			<br>
			<div class="form-inline my-2 my-lg-0">
				<a class="right_list_crrent_user "
					href="/CLibrary/LoginServlet?target=login">ログイン</a>
			</div>
			<%-- <%= form_with(url: search_posts_path, local: true, method: :get, class: "form-inline my-2 my-lg-0") do |form| %>
			<%= form.text_field :keyword, placeholder: "投稿を検索する", class: "form-control mr-sm-2" %>
			<%= form.submit "検索する", class: "btn btn-outline-success my-2 my-sm-0" %>
			<% end %> --%>
		</div>
	</nav>
	<div class="container" id="index-container">
		<div class="jumbotron">
			<h1 class="display-4">CLibrary</h1>
			<p class="lead">会社で購入した書籍を借りることができます</p>
			<hr class="my-4">
			<p>書籍を借りるにはログイン、新規登録を行ってください</p>
		</div>
	</div>

<!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js?20170919"></script>

<script type="text/javascript" id="_-s-js-_" src="//satori.segs.jp/s.js?c=4717cdb6"></script>
<div id="satori__creative_container">
    <script id="-_-satori_creative-_-" src="//delivery.satr.jp/js/creative_set.js" data-key="c19347fd10e6d919"></script>
</div>
</body>
</html>