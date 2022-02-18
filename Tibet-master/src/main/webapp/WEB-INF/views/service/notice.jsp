<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>공지사항</title>
<link rel="stylesheet" href="resources/css/notice.css">
</head>
<body>
	<section>
	<form role="form" method="get">
		<div class="notice">
			<div class="notice-front-table mgb10">
				<div class="notice-front-fonter-qna">
					<a href="${contextPath}/qna.do" class="font-999">Q&A</a>
				</div>
				<div class="notice-front-fonter-notice">
					<a href="${contextPath}/notice.do">공지사항</a>
				</div>

				<div class="notice-front-fonter-member">
					<a href="${contextPath}/membership.do" class="font-999">멤버쉽 안내</a>
				</div>
			</div>

			<div class="service-notice" style="margin-top: 80px;">
				<table class="service-notice-front">
					<thead class="service-notice-title mgb15">
						<tr>
							<th class="not-no">번호</th>
							<th class="not-tit">제목</th>
							<th class="not-nm">작성자</th>
							<th class="not-date">작성일</th>
						</tr>
					</thead>
					<tbody class="service-notice-content mgb20">
						<c:choose>
							<c:when test="${fn:length(list) > 0 }">
								<c:forEach items="${list }" var="nList">
									<tr>
										<td scope="row">${nList.num}</td>
										<td class="notice-tit-td"><a href="${contextPath}/noticeDetail${nList.notice_num}.do">${nList.notice_title}</a></td>
										<td class="notice-tit-td">${nList.user_id }</td>
										<td class="notice-tit-td">${nList.notice_date}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="5">조회된 결과가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			 <!-- 페이징 -->
			<ul class="btn-group pagination">
			<c:if test="${pageMaker.prev}">
				<li><a href='<c:url value="/notice.do${pageMaker.makeSearch(pageMaker.startPage - 1)}"/>'><i class="fas fa-chevron-left"></i></a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<li><a href='<c:url value="/notice.do${pageMaker.makeSearch(idx)}"/>'>${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href='<c:url value="/notice.do${pageMaker.makeSearch(pageMaker.endPage + 1)}"/>'><i class="fas fa-chevron-right"></i></a></li>
			</c:if>
		</ul>
	</div>
			 <!-- 검색기능 -->
		  <div class="notice-search">
		    <select name="searchType">
		      <option value="all"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>전체</option>
		      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
		      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
		      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
		      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
		    </select>
		    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
		    <button id="searchBtn" type="button">검색</button>
		  </div>
	  </form>
	</section>
	</body>
<script>
	// 페이징 클릭
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "notice.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
</script>
</html>