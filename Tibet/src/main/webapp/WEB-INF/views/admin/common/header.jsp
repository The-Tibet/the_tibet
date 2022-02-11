<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>티벳샵</title>

<link rel="stylesheet" href="resources/fontawesome/css/all.css">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Roboto&display=swap" rel="stylesheet">
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>header</title>
</head>
<body>
	<header>
		<ul class="top-menu">
			<!--  로그인시 로그아웃표시 -->
			<c:choose>
				<c:when test="${isLogOn==true and not empty memberInfo and memberInfo.user_id !='admin'}">
					<li><a href="${contextPath}/notice.do">SERVICE</a></li>
					<li><a href="${contextPath}/logout.do">LOGOUT</a></li>
					<li><a href="${contextPath}/memModifyForm.do">MYPAGE</a></li>
					<li><a href="${contextPath}/cart.do">CART</a></li>
			<!-- 관리자로 로그인시 관리자표시 -->
				</c:when>
				<c:when test="${isLogOn==true and not empty memberInfo and memberInfo.user_id =='admin' }">
					<li><a href="${contextPath}/notice.do">SERVICE</a></li>
					<li><a href="${contextPath}/logout.do">LOGOUT</a></li>
					<li class="no_line"><a
						href="${contextPath}/admin-notice.do">Manager</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${contextPath}/notice.do">SERVICE</a></li>
					<li><a href="${contextPath}/login.do">LOGIN</a></li>
					<li><a href="${contextPath}/signupForm.do">SIGN UP</a></li>
				</c:otherwise>
			</c:choose>
</ul>
		<div id="logo">
			<a href="${contextPath}/main.do">THE TIBET</a>
		</div>
	</header>

	<div class="modal">
		<div class="modal_body">
			<h1>SEARCH</h1>
			<div class="close">
				<button id="close-button">
					<i class="fas fa-times"></i>
				</button>
			</div>
			<div class="wraps">
				<div class="search">
					<input type="text" class="searchTerm"
						placeholder="What are you looking for?">
					<button type="submit" class="searchButton">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
			</div>
		</div>
</body>
</html>