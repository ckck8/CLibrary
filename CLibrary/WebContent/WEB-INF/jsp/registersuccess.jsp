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
<link rel="stylesheet" href="css/addsuccess.css">
<title>アカウント新規登録成功</title>
</head>
<body>
	<div class="login_header">
		<div class="header_item">
			<h1>CLibrary</h1>
		</div>
		<div class="header_item">
			<h1>マスターページ</h1>
		</div>
		<div class="header_item mt-3">
			<a class="right_list_crrent_user "
				href="/CLibrary/LoginServlet?target=login">ログアウト</a>
		</div>
	</div>
	<div class="container">
		<div class="message">
			<h2>新規登録が完了しました！</h2>
			<p>
				ようこそ
				<c:out value="${sd.name }" />
				さん
			</p>

			<form action="/CLibrary/LoginServlet?target=toMypage" method="post">
				<input type="hidden" name="mail" value="${sd.mail }"> <input
					type="hidden" name="pass" value="${sd.pass }"> <input
					type="submit" value="Ｍｙページへ">
			</form>
			<div class="top_button">
				<button onclick="location.href='/CLibrary/WelcomeServlet'">トップ画面へ</button>
			</div>
		</div>
	</div>
</body>
</html>
