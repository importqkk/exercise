<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>강의 목록</h1>

	<br><br>

	<!-- 검색창 -->
	<form action="list" method="get">
		<select name="column">
			<option value="lecture">강의명</option>
			<option value="lecturer">강사명</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어를 입력하세요." value="${keyword}" required>
		<button>검색</button>
	</form>
	
	<br>

	<!-- 목록 -->
	<c:choose>
		<c:when test="${list.isEmpty()}">
			검색 결과가 없습니다.
		</c:when>
		<c:otherwise>
			<table border="1" width="650">
		<thead>
			<tr>
				<th>번호</th>
				<th width="50%">강의명</th>
				<th>강사명</th>
				<th>시수</th>
				<th>수강료</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="lecturesDto" items="${list}">
					<tr>
						<td>${lecturesDto.lecturesNo}</td>
						<td>
							<a href="detail?lecturesNo=${lecturesDto.lecturesNo}">${lecturesDto.lecturesLecture}</a>
						</td>
						<td>${lecturesDto.lecturesLecturer}</td>
						<td>${lecturesDto.lecturesHours}</td>
						<td align="right">
							<fmt:formatNumber value="${lecturesDto.lecturesFee}" pattern="#,##0"></fmt:formatNumber>
						</td>
					</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<a href="add">등록</a>
				</td>
			</tr>
		</tfoot>
	</table>
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<!-- 페이지 네비게이터 -->
	<c:forEach var="i" begin="1" end="${totalPage}" step="1">
		<c:choose>
			<c:when test="${page == i}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="list?column=${column}&keyword=${keyword}&page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<br><br>
	
	<a href="list">전체목록</a>
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
