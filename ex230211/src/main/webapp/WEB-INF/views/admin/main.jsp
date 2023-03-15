<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
		
	<a href="/admin/members/list">회원 관리</a>
	
	<br><br><br>
	
	<h2>회원 현황</h2>
	<table border="1" width=500>
		<thead>
			<tr>
				<th>등급</th>
				<th>인원</th>
				<th>평균 포인트</th>
				<th>최대 포인트</th>
				<th>최소 포인트</th>
			</tr>
		</thead>
		<c:forEach var="memberStatDto" items="${memberList}">
			<tbody align="right">
				<tr>
					<td align="center">${memberStatDto.memberLevel}</td>
					<td>
						<fmt:formatNumber value="${memberStatDto.cnt}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${memberStatDto.avgPoint}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${memberStatDto.maxPoint}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${memberStatDto.minPoint}" pattern="#,##0"></fmt:formatNumber>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<br><br>
	
	<h2>강의 현황</h2>
	<table border="1" width="700">
		<thead>
			<tr>
				<th>개수</th>
				<th>평균 강의료</th>
				<th>최저 강의료</th>
				<th>최고 강의료</th>
				<th>평균 시수</th>
				<th>최단 시수</th>
				<th>최장 시수</th>
			</tr>
		</thead>
		<c:forEach var="lectureStatDto" items="${lectureList}">
			<tbody align="center">
				<tr>
					<td>
						<fmt:formatNumber value="${lectureStatDto.cnt}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${lectureStatDto.avgFee}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${lectureStatDto.minFee}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${lectureStatDto.maxFee}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${lectureStatDto.avgHours}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${lectureStatDto.minHours}" pattern="#,##0"></fmt:formatNumber>
					</td>
					<td>
						<fmt:formatNumber value="${lectureStatDto.maxHours}" pattern="#,##0"></fmt:formatNumber>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<br><br>
	
	<h2>게시판 현황</h2>
		<table border="1" width="200">
		<thead>
			<tr>
				<th>카테고리</th>
				<th>개시글 수</th>
			</tr>
		</thead>
		<c:forEach var="boardStatDto" items="${boardList}">
			<tbody align="center">
				<tr>
					<td>
						${boardStatDto.boardCategory}
					</td>
					<td align="right">
						<fmt:formatNumber value="${boardStatDto.cnt}" pattern="#,##0"></fmt:formatNumber>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
		
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
