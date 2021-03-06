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
<title>관리자-등록</title>
<link rel="stylesheet" href="resources/css/admin/admin-regist.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Roboto&display=swap"
	rel="stylesheet">


<script>
        function button_event01(){
          
        if (confirm("등록 하시겠습니까?") == false){    //확인
            var form = document.test;
            form.submit();
        
        }else{   //취소
            return;
          }
        }
    </script>
<script>
        function button_event02(){
          
        if (confirm("취소 하시겠습니까?") == false){    //나가기
            var form = document.test;
            form.submit();
        
        }else{   //취소
            return;
          }
        }
    </script>


</head>
<body>
	<section>
			</div>
			<div class="content">
				<div class="table-title">
					<table>회원 정보 _ 등록
					</table>
				</div>



				<div class="qna-ask">
					<div class="form">
						<div class="qna-ask-form">
							<label>이름</label> <input type="text" class="input" />
						</div>
						<div class="qna-ask-form">
							<label>아이디</label> <input type="text" class="input"
								placeholder=" admin으로 시작" />
						</div>
						<div class="qna-ask-form">
							<label>비밀번호</label> <input type="password" class="input"
								minlength="8" maxlength="16" placeholder=" 8~16자">
						</div>
						<div class="qna-ask-form">
							<label>전화번호</label> <input type="text" name="cellPhone"
								id="cellPhone" placeholder="핸드폰번호 입력(' - '입력하지마세요)"
								maxlength="13" />
							<script>
                            function autoHypenPhone(str){
                                str = str.replace(/[^0-9]/g, '');
                                var tmp = '';
                                if( str.length < 4){
                                    return str;
                                }else if(str.length < 7){
                                    tmp += str.substr(0, 3);
                                    tmp += '-';
                                    tmp += str.substr(3);
                                    return tmp;
                                }else if(str.length < 11){
                                    tmp += str.substr(0, 3);
                                    tmp += '-';
                                    tmp += str.substr(3, 3);
                                    tmp += '-';
                                    tmp += str.substr(6);
                                    return tmp;
                                }else{              
                                    tmp += str.substr(0, 3);
                                    tmp += '-';
                                    tmp += str.substr(3, 4);
                                    tmp += '-';
                                    tmp += str.substr(7);
                                    return tmp;
                                }
                                return str;
                            }
                            var cellPhone = document.getElementById('cellPhone');
                            cellPhone.onkeyup = function(event){
                            event = event || window.event;
                            var _val = this.value.trim();
                            this.value = autoHypenPhone(_val) ;
                            }
                        </script>
						</div>
						<div class="qna-ask-form">
							<label>Email</label> <input type="email" name="email" />
						</div>
						<div class="qna-ask-form01">
							<label for="">주소</label> <input type="text" id="sample4_postcode"
								placeholder="우편번호">
							<button type="button" onclick="location.href='#'"
								class="btn-text1">우편번호</button>
							<div>
								<label for="" class="text01"></label> <input type="text"
									id="sample4_roadAddress" placeholder="도로명주소"
									readonly="readonly">
							</div>
							<div>
								<label for="" class="text01"></label> <input type="text"
									id="sample4_jibunAddress" placeholder="지번주소"
									readonly="readonly">
							</div>
							<div>
								<label for="" class="text01"></label> <input type="text"
									id="sample4_detailAddress" placeholder="상세주소"><br>
							</div>
						</div>
					</div>
				</div>
				<div class="box-btn">
					<div class="box-btn-text">
						<button type="button"
							onclick="button_event01(); location.href='${contextPath}/adminmain.do';"
							class="btn-text">등록</button>
						<button type="button"
							onclick="button_event02(); location.href='${contextPath}/adminmain.do';"
							class="btn-text">취소</button>
					</div>
				</div>

			</div>
		</div>
	</section>
</body>
</html>