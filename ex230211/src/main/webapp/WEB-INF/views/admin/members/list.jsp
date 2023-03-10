<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>회원 목록</h1>
	
		<form action="list" method="get">
		<c:choose>
			<c:when test="${vo.column == 'member_level'}">
				<select name="column">
					<option value="member_id">아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_first_name">이름</option>
					<option value="member_level" selected>등급</option>
				</select>
			</c:when>
			<c:when test="${vo.column == 'member_first_name'}">
				<select name="column">
					<option value="member_id">아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_first_name" selected>이름</option>
					<option value="member_level">등급</option>
				</select>
			</c:when>
			<c:when test="${vo.column == 'member_nick'}">
				<select name="column">
					<option value="member_id">아이디</option>
					<option value="member_nick" selected>닉네임</option>
					<option value="member_first_name">이름</option>
					<option value="member_level">등급</option>
				</select>
			</c:when>
			<c:otherwise>
				<select name="column">
					<option value="member_id" selected>아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_first_name">이름</option>
					<option value="member_level">등급</option>
				</select>
			</c:otherwise>
		</c:choose>
		<input type="text" name="keyword" required placeholder="검색어" value="${vo.keyword}">
		<button>검색</button>
	</form>
	
	<br><br>
	
	<a href="/admin/members/list?sort=member_id asc">아이디순</a>
	<a href="/admin/members/list?sort=member_nick asc">닉네임순</a>
	<a href="/admin/members/list?sort=member_level asc">등급순</a>
	<a href="/admin/members/list?sort=member_join asc">가입일 오름차</a>
	<a href="/admin/members/list?sort=member_join desc">가입일 내림차</a>
	
	<br><br>
	
	<c:choose>
		<c:when test="${list.isEmpty()}">
			<br>
			<h3>검색 결과가 없습니다.</h3>
		</c:when>
		<c:otherwise>
			<table border="0" width="900">
				<thead>
					<tr>
						<th width=30%>아이디</th>
						<th>닉네임</th>
						<th>이름</th>
						<th>등급</th>
						<th>가입일</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="membersDto" items="${list}">
						<tr>
							<td>
								<a href="/admin/members/detail?memberID=${membersDto.memberID}">
									${membersDto.memberID}
								</a>
							</td>
							<td>${membersDto.memberNick}</td>
							<td>${membersDto.memberLastName}${membersDto.memberFirstName}</td>
							<td>${membersDto.memberLevel}</td>
							<td>${membersDto.memberJoin}</td>
							<td>
								<a href="/admin/members/leave?memberID=${membersDto.memberID}&page=${vo.page}">탈퇴</a> | 
								<a href="/admin/members/changeInfo?memberID=${membersDto.memberID}">수정</a> | 
								<a href="/admin/members/tempPW?memberID=${membersDto.memberID}">임시비밀번호</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	
	<br><br>
	
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
	<!-- 숫자(begin ~ end) -->
	<c:forEach var="i" begin="${vo.firstBlock}" end="${vo.lastBlock}">
		<c:choose>
			<c:when test="${vo.page == i}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="list?page=${i}${vo.param}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<!-- >  (다음페이지로) -->
	<c:choose>
		<c:when test="${vo.next}">
			<a href="list?page=${vo.nextPage}${vo.param}">&gt;</a>
		</c:when>
		<c:otherwise>
			&gt;
		</c:otherwise>
	</c:choose>
	<!-- >> (마지막 페이지로) -->
	<c:choose>
		<c:when test="${!vo.lastPage}">
			<a href="list?&page=${vo.countTotalPage}${vo.param}">&raquo;</a>
		</c:when>
		<c:otherwise>
			&raquo;
		</c:otherwise>
	</c:choose>
	
	<br><br>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
