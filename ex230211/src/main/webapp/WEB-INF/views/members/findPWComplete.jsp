<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>비밀번호 찾기</h1>
	
	<br><br>
	
	<h3>회원님의 임시 비밀번호가 이메일로 전송되었습니다.</h3>
	<h3>발급된 임시 비밀번호로 로그인 후 반드시 비밀번호를 변경해주세요.</h3>
	
	<br><br><br>
	
	<a href="/members/login">로그인</a> / <a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
