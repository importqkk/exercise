<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>${lecturesDto.lecturesLecture}</h1>
	
	<c:choose>
		<c:when test="${image != null}">
			<img width="200" height="300" src="/attachment/download?attachmentNo=${image.attachmentNo}">
		</c:when>
		<c:otherwise>
			<img width="200" height="300" src="/images/defaultLecture.png">
		</c:otherwise>
	</c:choose>
	
	<ul>
		<li>강사: ${lecturesDto.lecturesLecturer}</li>
		<li>
			시수: <fmt:formatNumber value="${lecturesDto.lecturesHours}" pattern="#,##0시간"></fmt:formatNumber>
		</li>
		<li>
			수강료: <fmt:formatNumber value="${lecturesDto.lecturesFee}" pattern="#,##0원"></fmt:formatNumber>
		</li>
	</ul>
	
	<br><br>
	
	<c:if test="${sessionScope.memberLevel == 'admin'}">
		<a href="delete?no=${lecturesDto.lecturesNo}">삭제</a>
		<a href="edit?no=${lecturesDto.lecturesNo}">수정</a>
	</c:if>
	<a href="list">전체목록</a>
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
