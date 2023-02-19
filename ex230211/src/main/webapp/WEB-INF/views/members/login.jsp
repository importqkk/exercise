<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>로그인</h1>
	
	<br><br>
	
	<form action="login" method="post">
		<table border="0">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="memberID" required>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="memberPW" required>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<button>로그인</button>
					<td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<br>
	
	<c:if test="${param.mode == 'error'}">
		<h4>로그인 정보가 일치하지 않습니다.</h4>
		<br>
	</c:if>
	
	<a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
