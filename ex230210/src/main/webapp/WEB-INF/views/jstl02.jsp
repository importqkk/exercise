<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jstl02</title>
	</head>
	<body>
		<c:forEach var="i" begin="1" end="5" step="1">
			<h2>i = ${i}</h2>
		</c:forEach>
	</body>
</html>