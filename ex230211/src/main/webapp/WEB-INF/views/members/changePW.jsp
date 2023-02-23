<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>비밀번호 변경</h1>
	
	<br><br>
	
	<form action="changePW" method="post">
		<table border="0">
			<tbody>
				<tr>
					<th>현재 비밀번호</th>
					<td>
						<input type="password" name="currentPW" required>
					</td>
				</tr>
				<tr>
					<th>변경할 비밀번호</th>
					<td>
						<input type="password" name="newPW" required>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left">
						<h5>영문 대/소문자, 숫자, 특수문자를 1개 이상 포함 8~16자</h5>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button>변경</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<br>
	
	<c:if test="${param.mode == 'error'}">
		<h4>비밀번호가 일치하지 않습니다.</h4>
		<br>
	</c:if>
	
	<a href="/members/mypage">마이페이지</a> / <a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
