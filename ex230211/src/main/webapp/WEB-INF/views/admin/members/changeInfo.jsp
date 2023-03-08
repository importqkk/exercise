<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>개인정보 변경</h1>
	
	<br><br>
	
	<form action="changeInfo" method="post" enctype="multipart/form-data">
		<table border="0" width="400">
			<tbody align="left">
				<tr>
					<th width="20%">*아이디</th>
					<td colspan="2">
						<input type="text" name="memberID" readonly value="${membersDto.memberID}">
					</td>
				</tr>
				<tr>
					<th>*닉네임</th>
					<td>한글, 숫자 2~10자</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberNick" required value="${membersDto.memberNick}">
					</td>
				</tr>
				<tr>
					<th colspan="2">*이메일</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="email" name="memberEmail" required value="${membersDto.memberEmail}">
					</td>
				</tr>
				<tr>
					<th colspan="2">*성</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberLastName" required value="${membersDto.memberLastName}">
					</td>
				</tr>
				<tr>
					<th colspan="2">*이름</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberFirstName" required value="${membersDto.memberFirstName}">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>숫자만 입력 (- 제외)</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="number" name="memberTel" value="${membersDto.memberTel}">
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>-를 포함하여 YYYY-MM-DD 형식으로 입력</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="date" name="memberBirth" value="${membersDto.memberBirth}">
					</td>
				</tr>
				<tr>
					<th>포인트</th>
					<td>(기존: ${membersDto.memberPoint} point)</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="number" name="memberPoint" value="${membersDto.memberPoint}">
					</td>
				</tr>
				<tr>
					<th>레벨</th>
					<td>(기존: ${membersDto.memberLevel})</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="memberLevel" value="${membersDto.memberLevel}">
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
	
	<a href="/admin/members/detail?memberID=${membersDto.memberID}">회원상세</a> / 
	<a href="/admin/members/list">목록으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
