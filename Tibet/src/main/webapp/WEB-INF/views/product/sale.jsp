<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/fontawesome/css/all.css">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/style.css">
<style>
section .MainMenu {
	display: flex;
	justify-content: center;
	text-align: center;
	font-weight: bold;
	font-size: 40px;
	background: white;
	color: black;
	margin-bottom: 30px;
	padding-top: 2%;
}

section .SubMenu {
	display: flex;
	justify-content: space-around;
	margin-bottom: 60px;
	position: relative;
	color: black;
	flex-wrap: 5;
}

section .SubMenu li {
	display: block;
	padding: 10px 20px;
}

section .sort {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
}

.hr {
	margin-top: -10px;
}

section .SelectMenu {
	font-weight: bold;
	padding: 0 1%;
}

.SubMenu li:hover {
	text-decoration: underline #999;
}

.UnSelectMenu-chk {
	padding: 0 1%;
}

.UnSelectMenu {
	border-left: 2px solid #e6e6e6;
	padding: 0 1%;
}
</style>
</head>
<body>
	<section>
		<div class="MainMenu">SALE</div>

		<div>
			<ul class="sort">
				<li class="UnSelectMenu-chk"><a href="${contextPath}/sale.do?p=2">low price</a></li>
				<li class="UnSelectMenu"><a href="${contextPath}/sale.do?p=3">high price</a></li>
				<li class="UnSelectMenu"><a href="${contextPath}/sale.do?p=4">name</a></li>
				<li class="UnSelectMenu"><a href="${contextPath}/sale.do?p=1">new arrival</a></li>
			</ul>
		</div>

		<hr>
		<div class="wrap">
			<ul>
				<c:forEach var="list" items="${list}">
					<li>
						<ul class="items">
							<li><a
								href="${contextPath}/productDetail${list.product_num}.do"> <img
									src="resources/${list.product_thumbnail}"></a></li>
							<li class="a"><a href="${contextPath}/productDetail${list.product_num}.do">${list.product_name}</a></li>
							<c:if test="${list.product_sale eq 0}">
								<li class="b"><fmt:formatNumber value="${list.product_price}" pattern="###,###,###원" /></li>
							</c:if>
							<c:if test="${list.product_sale ne 0}">
								<li class="c"><fmt:formatNumber value="${list.product_price}" pattern="###,###,###원" /></li>
								<li class="d"><fmt:formatNumber value="${list.product_price - list.product_sale}" pattern="###,###,###원" /></li>
							</c:if>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="clear"></div>
	</section>
</body>
</html>