<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>비밀번호 찾기</h1>
	
	<br><br>
	
	<form action="findPW" method="post">
		<table border="0">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="inID" required>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="email" name="inEmail" required>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<button>비밀번호 찾기</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<br>
	
	<c:if test="${param.mode == 'error'}">
		<h4>입력하신 정보와 일치하는 회원 정보가 없습니다.</h4>
		<br>
	</c:if>
	
	<a href="/members/login">로그인</a> / <a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
