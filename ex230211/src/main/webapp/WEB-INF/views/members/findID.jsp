<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>아이디 찾기</h1>
	
	<br><br>
	
	<form action="findID" method="post">
		<table border="0">
			<tbody>
				<tr>
					<th>닉네임</th>
					<td>
						<input type="text" name="memberNick" required>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="email" name="memberEmail" required>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<button>아이디 찾기</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<br>
	
	<c:if test="${param.mode == 'error'}">
		<h4>입력하신 정보와 일치하는 아이디가 없습니다.</h4>
		<br>
	</c:if>
	
	<a href="/members/login">로그인</a> / <a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
