<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<c:choose>
		<c:when test="${boardParent == null}">
			<h1>게시글 등록</h1>
		</c:when>
		<c:otherwise>
			<h1>답글 등록</h1>
		</c:otherwise>
	</c:choose>
	
	<br><br>

	<form action="post" method="post" enctype="multipart/form-data">
		<c:if test="${boardParent != null}">
			<input type="hidden" name="boardParent" value="${boardParent}">
		</c:if>
		<select name="boardCategory">
			<c:if test="${sessionScope.memberLevel == 'admin'}">
				<option>공지</option>
			</c:if>
			<option>질문</option>
			<option>답변</option>
		</select>
		
		<c:choose>
			<c:when test="${boardParent == null}">
				<input type="text" name="boardTitle" required placeholder="제목을 입력하세요."><br>
			</c:when>
			<c:otherwise>
				<input type="text" name="boardTitle" required value="RE: " placeholder="제목을 입력하세요."><br>
			</c:otherwise>
		</c:choose>
		
		<textarea rows="30" cols="100" name="boardContent" required placeholder="남을 비방하거나 유해한 게시물은 삭제될 수 있습니다."></textarea><br><br>
		
		사진등록<br>
		<input type="file" name="attach" accept="image/"><br><br>
		
		<button>등록</button>
	</form>
	
	<br>
	
	<a href="/board/list">게시판 목록</a> / 
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
