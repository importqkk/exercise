<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>테이블</title>
	</head>
	<body>
	
		<h1 align="center">연락처 목록</h1>
	
		<table border="1" width="500" align="center">
			<thead>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody align="center">
				<tr>
					<td>알렉사</td>
					<td>010-1111-1111</td>
					<td>alexa@email.com</td>
				</tr>
				<tr>
					<td>빅스비</td>
					<td>010-2222-2222</td>
					<td>bixby@email.com</td>
				</tr>
				<tr>
					<td>시리</td>
					<td>010-3333-3333</td>
					<td>siri@email.com</td>
				</tr>
				<tr>
					<td>지니</td>
					<td>010-4444-4444</td>
					<td>genie@email.com</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"  align="right">새 연락처 등록</td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>