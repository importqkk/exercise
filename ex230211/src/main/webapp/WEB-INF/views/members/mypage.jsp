<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>${membersDto.memberNick}님, 안녕하세요.</h1>
	
	<br><br>
	
	<c:choose>
		<c:when test="${profile != null}">
			<img width="100" height="100" src="/attachment/download?attachmentNo=${profile.attachmentNo}">
		</c:when>
		<c:otherwise>
			<img width=100 height=100 src="/images/defaultProfile.png">
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<table border="1" width="530">
		<tbody align="left">
			<tr>
				<th width="17%">아이디</th>
				<td>${membersDto.memberID}</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${membersDto.memberNick}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${membersDto.memberEmail}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${membersDto.memberLastName}${membersDto.memberFirstName}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${membersDto.memberTel}</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>${membersDto.memberPoint} point</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${membersDto.memberLevel}</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>
					<fmt:formatDate value="${membersDto.memberJoin}" pattern="yyyy-MM-dd EEEE"/>
				</td>
			</tr>
			<tr>
				<th>최종로그인</th>
				<td>
					<fmt:formatDate value="${membersDto.memberLogin}" pattern="yyyy-MM-dd EEEE hh:mm:ss"/>
				</td>
			</tr>
		</tbody>
	</table>
	
	<br>
	
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
