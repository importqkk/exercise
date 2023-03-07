<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>개발하는 쿼카</title>
	</head>
	<body>
		<br>
		
		<a href="/">메인</a>
		<a href="/lectures/list">강의</a>
		<a href="/board/list">게시판</a>
		
		<c:if test="${sessionScope.memberLevel == 'admin'}">
			<a href="/admin">관리</a>
		</c:if>
		
		<c:choose>
			<c:when test="${sessionScope.memberID != null}">
				<a href="/members/mypage">마이페이지</a>
				<a href="/members/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="/members/login">로그인</a>
				<a href="/members/join">회원가입</a>
			</c:otherwise>
		</c:choose>
		
		<br><br><hr><br><br><br>