<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>공지사항 수정</title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/qnaWrite.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="resources/fontawesome/css/all.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="resources/summernote/summernote-lite.js"></script>
<script src="resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/summernote/summernote-lite.css">

</head>
<body>
	<form action="${contextPath}/noticeModify.do" id="noticeMod" method="post">

		<section>
			<div class="qna-ask">
				<div class="form">
					<div class="qna-ask-form">
						<label>제목</label> <input type="text" class="input" id="notice_title"
							name="notice_title" value="">
					</div>
					<%
					session.getAttribute("memberInfo");
					%>
					<input type="hidden" id="user_id" name="user_id"
						value="${memberInfo.user_id}">
					</div>
					</div>
					<div class="qna-ask-form">
						<label>내용</label>
						<textarea id="summernote" name="notice_content"></textarea>
					</div>
					<div class="qna-ask-form-img">
						<label>이미지 첨부</label> <input class="qna-ask-form-img-btn"
							type="file" name="notice_img">
					</div>
			<div class="box-btn">
					<div class="box-btn-text">
						<button type="button" class="btn-text" id="button-reg"
							onclick="javascript:submit_check('${contextPath}/admin-notice.do')">수정</button>
						<button type="button" class="btn-text" id="button-can"
							onclick="javascript:delete_check()">취소</button>
					</div>
			</div>
		</section>

	</form>
	<script>
	   $('#summernote').summernote({
			height: 450,
			lang: "ko-KR",
            toolbar: [
                ['fontname', ['fontname']],
                ['fontsize', ['fontsize']],
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['color', ['color']],
                ['para', ['paragraph']],
                ['insert', ['link', 'picture']],
                ['view', []]
            ]
		});
		function submit_check() {
			var answer;
			answer = confirm("수정하시겠습니까?");
			if (answer == true) {

				document.getElementById('noticeMod').submit();
				location = url;
			}
		}
		function delete_check() {
			var answer;
			//페이지를 이동하기 전에 confirm()을 사용해 다시 한번 확인한다.
			//확인을 선택하면 answer에  true, 취소를 선택하면 false 값이 들어간다.
			answer = confirm("글 수정을 취소하시겠습니까?");
			//확인을 선택한 경우 자바스크립트를 호출할 때 같이 넘어온 url이라는 변수에 들어있는 주소로 페이지 이동
			if (answer == true) {
				history.go(-1);
			}
		}
	</script>
</body>
</html>