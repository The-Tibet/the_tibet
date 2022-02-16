<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원-조회</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link rel="stylesheet" href="resources/css/admin/admin-layout.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">THE TIBET</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="#">관리자</a></li>
					<li class="breadcrumb-item active">회원</li>
				</ol>
				<div class="card mb-4">
					<div class="card-body">
						회원조회<a target="_blank" href="https://datatables.net/"></a>
					</div>
				</div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> 회원목록
					</div>
					<div class="card-body">
						<table id="datatablesSimple">
							<thead>
								<tr>
									<th>번호</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생일</th>
									<th>성별</th>
									<th>맴버쉽</th>
									<th>휴대폰</th>
									<th>포인트</th>
									<th>가입일</th>

								</tr>
							</thead>
							<c:forEach items="${list}" var="mList">
								<tr>
									<td class="text_ct">${mList.num}</td>
										<td><a href="${contextPath}/admin-noticeDetail${mList.user_id }">${mList.user_id }</a></td>
									<td class="text_ct">${mList.user_name}</td>
									<td class="text_ct">${mList.user_birth}</td>
									<c:choose>
										<c:when test='${mList.user_gender eq "0"}'>
											<td class="text_ct">남자</td>
										</c:when>
										<c:otherwise>
											<td class="text_ct">여자</td>
										</c:otherwise>
									</c:choose>
									<td class="text_ct">${mList.user_membership}</td>
									<td class="text_ct">${mList.user_phone}</td>
									<td class="text_ct">${mList.user_point}</td>
									<td class="text_ct">${mList.user_joinDate}</td>
								    <td><a href="memDelete.do?num=${mList.num}">삭제</a></td>
         				            <td><a href="memUpdateForm.do?num=${mList.num}">수정</a></td>


								</tr>
							</c:forEach>
						</table>

					</div>
				</div>
		<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
		<script src="js/datatables-simple-demo.js"></script>
</body>
</html>