<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



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

section .sort li {
	margin: 0 1% 0 1%;
}

section .sort p {
	width: 1px;
	margin: 0 0 1% 0;
}

.hr {
	margin-top: -10px;
}

section .noProd {
	color: black;
}

section .page_wrap {
	display: flex;
	justify-content: space-around;
}

.page_nation {
	display: inline-block;
	margin-bottom: 150px;
}

.page_nation .none {
	display: none;
}

.page_nation a {
	display: block;
	margin: 0 3px;
	float: left;
	border: 1px solid #e6e6e6;
	width: 28px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	background-color: #fff;
	font-size: 13px;
	color: #999999;
	text-decoration: none;
}

.page_nation a.active {
	background-color: #42454c;
	color: #fff;
	border: 1px solid #42454c;
}

.paging {
	margin-top: 50px;
	font-size: 0px;
	text-align: center;
	color: rgb(150, 150, 150);
}

.paging a {
	display: inline-block;
	margin-left: 5px;
	padding: 5px 7px;
	font-size: 14px;
	font-weight: 400;
}

.paging .num-on {
	color: black;
	font-weight: 700;
}

.SubMenu li:hover {
	text-decoration: underline #999;
}

section .SelectMenu {
	font-weight: bold;
}

.items {
	width: 20%;
	/* border: solid 1px blue; */
	margin: 50px 2.5%;
	float: left;
	justify-content: center;
}
.items img {
	max-width: 100%;
  height: auto;
  display: block;
}

.items li {
	font-family: "돋움";
	color: #666666;
}

.items .a {
	font-weight: bold;
	color: black;
	margin-top: 20px;
}

.items .b {
	font-weight: bold;
	color: black;
	margin-top: 5px;
}

.items .b span {
	color: #a26f59;
}


.clear {
	clear: both;
}
</style>
</head>
<body>
	<section>
		<div class="MainMenu">티셔츠</div>
		<ul class="SubMenu">
			<li><a href="${contextPath}/top.do">ALL</a></li>
			<li class="SelectMenu"><a href="${contextPath}/top-1.do">티셔츠</a></li>
			<li><a href="${contextPath}/top-2.do">셔츠</a></li>
			<li><a href="${contextPath}/top-3.do">후드&맨투맨</a></li>
			<li><a href="${contextPath}/top-4.do">니트&가디건</a></li>
			<li><a href="${contextPath}/top-5.do">조끼</a></li>
		</ul>

		<!-- <div class="btn-group" role="group" aria-label="..."
			style="margin-bottom: 20px; margin-top: 30px;">

			<button type="button" class="btn btn-default"
				style="border: 0; outline: 0; border-radius: 1px;">인기순</button>

			<button type="button" class="btn btn-default"
				style="border: 0; outline: 0;">낮은가격순</button>

			<button type="button" class="btn btn-default"
				style="border: 0; outline: 0;">높은가격순</button>

			<button type="button" class="btn btn-default"
				style="border: 0; outline: 0; border-radius: 1px;">상품평순</button>
		</div>

		<hr style="margin-top: -10px;"> -->

		<div>
			<ul class="sort">
				<li class="SelectMenu"><a href="#">low price</a></li>
				<p>|</p>
				<li><a href="#">high price</a></li>
				<p>|</p>
				<li><a href="#">name</a></li>
				<p>|</p>
				<li><a href="#">new arrival</a></li>
			</ul>
		</div>

		<hr>

		<div class="wrap">

			<ul class="items">
				<li><a href="${contextPath}/top-1-1.do"><img src="resources/img/t1.jpg"></a></li>
				<li class="a"><a href="${contextPath}/top-1-1.do">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</a></li>
				<li class="b">9,880원</li>
			</ul>

			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>

			<ul class="items">
				<li><img src="resources/img/top1-1.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>

			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>
			
			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>
			
			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>
			
			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>
			
			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>
			
			<ul class="items">
				<li><img src="resources/img/top1-3.PNG"></li>
				<li class="a">네온 컬러 루즈핏 티셔츠 1+1(6 컬...</li>
				<li class="b">9,880원</li>
			</ul>
		</div>

		<div class="clear"></div>


		<!-- 페이징 글번호 -->

		<div class="paging">
			<a href="#" class="bt"><<</a> <a href="#" class="bt"><</a> <a
				href="#" class="num-on">1</a> <a href="#" class="num">2</a> <a
				href="#" class="bt">></a> <a href="#" class="bt">>></a>
		</div>
	</section>
</body>
</html>