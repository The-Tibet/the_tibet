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
<link rel="stylesheet" href="resources/css/admin/admin-main.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Roboto&display=swap"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		var chkObj = document.getElementsByName("RowCheck");
		var rowCnt = chkObj.length;

		$("input[name='allCheck']").click(function() {
			var chk_listArr = $("input[name='RowCheck']");
			for (var i = 0; i < chk_listArr.length; i++) {
				chk_listArr[i].checked = this.checked;
			}
		});
		$("input[name='RowCheck']").click(function() {
			if ($("input[name='RowCheck']:checked").length == rowCnt) {
				$("input[name='allCheck']")[0].checked = true;
			} else {
				$("input[name='allCheck']")[0].checked = false;
			}
		});
	});
	function deleteValue() {
		var url = "memberDelete"; // Controller로 보내고자 하는 URL (.dh부분은 자신이 설정한 값으로 변경해야됨)
		var valueArr = new Array();
		var list = $("input[name='RowCheck']");
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) { //선택되어 있으면 배열에 값을 저장함
				valueArr.push(list[i].value);
			}
		}
		if (valueArr.length == 0) {
			alert("선택된 글이 없습니다.");
		} else {
			var chk = confirm("정말 삭제하시겠습니까?");
			$.ajax({
				url : url, // 전송 URL
				type : 'POST', // GET or POST 방식
				traditional : true,
				data : {
					valueArr : valueArr
				// 보내고자 하는 data 변수 설정
				},
				success : function(jdata) {
					if (jdata = 1) {
						alert("삭제 성공");
						location.replace("admin-memberlist.do")
					} else {
						alert("삭제 실패");
					}
				}
			});
		}
	}
</script>
</head>
<body>
	<section>
		<br>
		<div class="search">
			<p class="table-search03">
				<select>
					<option value="">---선택---</option>
					<option value="공개">회원</option>
					<option value="비공개">관리자</option>
				</select>
			</p>
			<p class="table-search01">
				<input type="date" name="list-start" value="" min="2000-01-01"
					max="2030-12-31"> - <input type="date" name="list-end"
					value="" min="2000-01-01" max="2030-12-31">
			</p>
			<p class="table-search02">
				<input class="search-box" type="text" name="keyword"> <input
					class="search-btn" type="submit" value="검색">
			</p>
		</div>
		<br>
		<div class="table-cont">
			<div class="table-cont-btn">
				<button type="button"
					onclick="location.href='${contextPath}/adminregist.do'"
					class="btn-text b01">등록</button>
				<button type="button"
					onclick="location.href='${contextPath}/adminmodify.do'"
					class="btn-text b02">수정</button>
				<input type="button" value="삭제" class="btn btn-outline-info"
					onclick="deleteValue();">
			</div>
		</div>
		<br>
		<div class="user">
			<table class="user-look">
				<thead class="user-look-head">
					<tr>
						<th scope="col"><input id="allCheck" type="checkbox" name="allCheck" /></th>
						<th class="head-num">No.</th>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Birth</th>
						<th scope="col">Gender</th>
						<th scope="col">Membership</th>
						<th scope="col">Phone</th>
						<th scope="col">Point</th>
						<th scope="col">JoinDate</th>

					</tr>
				</thead>
				<c:forEach items="${list}" var="mList">
					<tr>
						<td class="text_ct"><input name="RowCheck" type="checkbox"
							value="${nList.user_id}" /></td>
						<td class="text_ct">${mList.num}</td>
						<td class="text_ct">${mList.user_id}</td>
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
					</tr>
				</c:forEach>
			</table>
			<div class="paging">
				<c:if test="${pageMaker.prev }">
					<li><a
						href='<c:url value="/admin-memberlist.do?page=${pageMaker.startPage-1 }"/>'><i
							class="fas fa-chevron-left"></i></a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="pageNum">
					<li><a
						href='<c:url value="/admin-memberlist.do?page=${pageNum }"/>'>${pageNum }</a></li>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
					<li><a
						href='<c:url value="/admin-memberlist.do?page=${pageMaker.endPage+1 }"/>'><i
							class="fas fa-chevron-right"></i></a></li>
				</c:if>
			</div>
		</div>
	</section>
</body>
</html>