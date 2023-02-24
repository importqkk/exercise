<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>회원 탈퇴</h1>
	
	<br>
	
	<form action="leave" method="post">
		<h4>본인 확인을 위해 비밀번호를 입력하세요.</h4>
		<input type="password" name="memberPW" required>
		<button>회원 탈퇴</button>
	</form>
	
	<br>
	
	<c:if test="${param.mode == 'error'}">
		<h4>비밀번호가 일치하지 않습니다.</h4>
		<br>
	</c:if>
	
	<br><br>
	
	<a href="/members/mypage">마이페이지</a> / <a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
