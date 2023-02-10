<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jstl01</title>
	</head>
	<body>
		<h1>if 태그</h1>
		<c:if test="${num % 2 == 0}">
			<h2>${num}은(는) 짝수입니다.</h2>
		</c:if>
		<c:if test="${num % 2 != 0}">
			<h2>${num}은(는) 홀수입니다.</h2>
		</c:if>
		
		<br>
		
		<h1>choose 태그</h1>
		<c:choose>
			<c:when test="${num % 2 == 0}">
				<h2>${num}은(는) 짝수입니다.</h2>
			</c:when>
			<c:otherwise>
				<h2>${num}은(는) 홀수입니다.</h2>
			</c:otherwise>
		</c:choose>
	</body>
</html>