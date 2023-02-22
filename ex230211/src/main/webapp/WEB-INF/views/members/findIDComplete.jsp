<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>아이디 찾기</h1>
	
	<br><br>
	
	<h3>회원님의 아이디는 ${findID} 입니다.</h3>
	
	<br><br><br>
	
	<a href="/members/login">로그인</a> / <a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
