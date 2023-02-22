<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>회원가입</h1>
	
	<br><br>
	
	<form action="join" method="post" enctype="multipart/form-data">
		<table border="1" width="530">
			<tbody align="left">
				<tr>
					<th colspan="2">*표는 필수 입력입니다.</th>
				</tr>
				<tr>
					<th colspan="2">프로필 이미지</th>
				</tr>
				<tr>
					<td colspan="2"><input type="file" name="attach"></td>
				</tr>
				<tr>
					<th width="17%">*아이디</th>
					<td>영문, 숫자 5~20자</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="memberID" required></td>
				</tr>
				<tr>
					<th>*비밀번호</th>
					<td>영어 대문자, 소문자, 숫자, 특수문자를 포함한 8~16자</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="memberPW" required></td>
				</tr>
				<tr>
					<th>*닉네임</th>
					<td>한글, 숫자 2~10자</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="memberNick" required></td>
				</tr>
				<tr>
					<th colspan="2">*이메일</th>
				</tr>
				<tr>
					<td colspan="2"><input type="email" name="memberEmail" required></td>
				</tr>
				<tr>
					<th colspan="2">*성</th>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="memberLastName" required></td>
				</tr>
				<tr>
					<th colspan="2">*이름</th>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="memberFirstName" required></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>숫자만 입력 (- 제외)</td>
				</tr>
				<tr>
					<td colspan="2"><input type="number" name="memberTel"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>-를 포함하여 YYYY-MM-DD 형식으로 입력</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="memberBirth"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><button>가입</button></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<br>
	
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
