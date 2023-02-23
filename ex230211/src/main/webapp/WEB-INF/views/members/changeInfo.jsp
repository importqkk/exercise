<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>개인정보 변경</h1>
	
	<br><br>
	
	<form action="changeInfo" method="post" enctype="multipart/form-data">
		<table border="0" width="530">
			<tbody align="left">
				<tr>
					<th width="22%">*아이디</th>
					<td colspan="2">
						${memberDto.memberID}
					</td>
				</tr>
				<tr>
					<th>*비밀번호 확인</th>
					<td>본인 확인을 위해 비밀번호를 입력해주세요.</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="password" name="memberPW" required>
					</td>
				</tr>
				<tr>
					<th>*닉네임</th>
					<td>한글, 숫자 2~10자</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberNick" required value="${memberDto.memberNick}">
					</td>
				</tr>
				<tr>
					<th colspan="2">*이메일</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="email" name="memberEmail" required value="${memberDto.memberEmail}">
					</td>
				</tr>
				<tr>
					<th colspan="2">*성</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberLastName" required value="${memberDto.memberLastName}">
					</td>
				</tr>
				<tr>
					<th colspan="2">*이름</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberFirstName" required value="${memberDto.memberFirstName}">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>숫자만 입력 (- 제외)</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="number" name="memberTel" value="${memberDto.memberTel}">
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>-를 포함하여 YYYY-MM-DD 형식으로 입력</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="date" name="memberBirth" value="${memberDto.memberBirth}">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
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
	
	<a href="/members/mypage">마이페이지</a> / 
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
