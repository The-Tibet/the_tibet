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
		<div class="MainMenu">니트&가디건</div>
		<ul class="SubMenu">
			<li><a href="${contextPath}/top.do">ALL</a></li>
			<li><a href="${contextPath}/top-1.do">티셔츠</a></li>
			<li><a href="${contextPath}/top-2.do">셔츠</a></li>
			<li><a href="${contextPath}/top-3.do">후드&맨투맨</a></li>
			<li class="SelectMenu"><a href="${contextPath}/top-4.do">니트&가디건</a></li>
			<li><a href="${contextPath}/top-5.do">조끼</a></li>
		</ul>

		<div>
			<ul class="sort">
				<li class="UnSelectMenu-chk"><a href="#">low price</a></li>
				<li class="UnSelectMenu"><a href="#">high price</a></li>
				<li class="UnSelectMenu"><a href="#">name</a></li>
				<li class="UnSelectMenu"><a href="#">new arrival</a></li>
			</ul>
		</div>

		<hr>
		<div class="row">
			<c:choose>
				<c:when test="${empty productList}">
					<b><span class="noProd">등록된 상품이 없습니다.</span></b>
				</c:when>
				<c:when test="${!empty productList}">
					<c:forEach var="product" items="${productList}" varStatus="productNum">
						<div class="col-md-4 ftco-animate">
							<div class="blog-entry">
								<a
									href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}"
									class="block-20"
									style="background-image: url('${contextPath}/resources/images/image_1.jpg');">
								</a>

								<div class="text d-flex py-1">
									<div class="desc pl-2">
										<h3 class="heading">
											<a href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}">${product.productName}</a>
										</h3>

										<hr style="margin-top: 25px;">
										<h3 class="heading" style="padding-left: 67%; white-space: nowrap;">
											<a
												href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}"
												style="font-size: 22px;"><fmt:formatNumber
													pattern="###,###,###" value="${product.productPrice}" /></a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</section>
</body>
</html>