<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>강의 등록</h1>

	<br><br>

	<form action="add" method="post" enctype="multipart/form-data">
		<table border="0" width="350">
			<tbody>
				<tr>
					<th width="50%">강의명</th>
					<td><input type="text" name="lecturesLecture" required></td>
				</tr>
				<tr>
					<th>강사명</th>
					<td><input type="text" name="lecturesLecturer" required></td>
				</tr>
				<tr>
					<th>시수</th>
					<td><input type="number" name="lecturesHours" required min=0 step="30"></td>
				</tr>
				<tr>
					<th>수강료</th>
					<td><input type="number" name="lecturesFee" required min=0></td>
				</tr>
				<tr>
					<th>사진등록</th>
					<td><input type="file" name="attach" accept="image/"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><button>등록</button></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<br>
	
	<a href="list">전체목록</a>
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
