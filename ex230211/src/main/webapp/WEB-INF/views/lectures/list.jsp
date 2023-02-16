<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>강의 목록</h1>

	<br><br>

	<!-- 검색창 -->
	<form action="list" method="get">
		<c:choose>
			<c:when test="${vo.column == 'lecturer'}">
				<select name="column">
					<option value="lecture">강의명</option>
					<option value="lecturer" selected>강사명</option>
				</select>
			</c:when>
			<c:otherwise>
				<select name="column">
					<option value="lecture" selected>강의명</option>
					<option value="lecturer">강사명</option>
				</select>
			</c:otherwise>
		</c:choose>
		
		<input type="text" name="keyword" placeholder="검색어를 입력하세요." value="${vo.keyword}" required>
		<button>검색</button>
	</form>
	
	<br>

	<!-- 목록 -->
	<c:choose>
		<c:when test="${list.isEmpty()}">
			검색 결과가 없습니다.
		</c:when>
		<c:otherwise>
			<table border="1" width="600">
				<thead>
					<tr>
						<th>번호</th>
						<th width="50%">강의명</th>
						<th>강사명</th>
						<th>수강료</th>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="lecturesDto" items="${list}">
							<tr>
								<td>${lecturesDto.lecturesNo}</td>
								<td>
									<a href="detail?lecturesNo=${lecturesDto.lecturesNo}">
										${lecturesDto.lecturesLecture}
									</a>
								</td>
								<td>${lecturesDto.lecturesLecturer}</td>
								<td align="right">
									<fmt:formatNumber value="${lecturesDto.lecturesFee}" pattern="#,##0">
									</fmt:formatNumber>
								</td>
							</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="right">
							<a href="add">등록</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<!-- 페이지 네비게이터 -->
	<!-- << (첫페이지로) -->
	<c:choose>
		<c:when test="${!vo.firstPage}">
			<a href="list?page=1${vo.param}">&laquo;</a>
		</c:when>
		<c:otherwise>
			&laquo;
		</c:otherwise>
	</c:choose>
	<!-- < (이전페이지로) -->
	<c:choose>
		<c:when test="${vo.prev}">
			<a href="list?page=${vo.prevPage}${vo.param}">&lt;</a>
		</c:when>
		<c:otherwise>
			&lt;
		</c:otherwise>
	</c:choose>
	<!-- 숫자 -->
	<c:forEach var="i" begin="${vo.firstBlock}" end="${vo.lastBlock}">
		<c:choose>
			<c:when test="${vo.page == i}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="list?page=${i}${vo.param}">
					${i}
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<!-- > (다음페이지로) -->
	<c:choose>
		<c:when test="${vo.next}">
			<a href="list?page=${vo.nextPage}${vo.param}">&gt;</a>
		</c:when>
		<c:otherwise>
			&gt;
		</c:otherwise>
	</c:choose>
	<!-- >> (마지막페이지로) -->
	<c:choose>
		<c:when test="${!vo.lastPage}">
			<a href="list?page=${vo.countTotalPage}${vo.param}">&raquo;</a>
		</c:when>
		<c:otherwise>
			&raquo;
		</c:otherwise>
	</c:choose>
	
	<br><br>
	
	<a href="list">전체목록</a>
	<a href="/">메인으로</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
