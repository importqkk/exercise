<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>게시판</h1>
	
	<c:choose>
		<c:when test="${list.isEmpty()}">
			<br>
			<h3>검색 결과가 없습니다.</h3>
		</c:when>
		<c:otherwise>
			<table border="0" width="800">
				<thead>
					<tr>
						<th>번호</th>
						<th width="40%">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>좋아요</th>
						<th>조회수</th>
						<c:if test="${sessionScope.memberLevel == 'admin'}">
							<th>관리</th>
						</c:if>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="boardDto" items="${noticeList}">
						<tr bgcolor="FFF8E1">
							<td>${boardDto.boardNo}</td>
							<td align="left">
								<c:if test="${boardDto.boardCategory != null}">
									[${boardDto.boardCategory}]
								</c:if>
								<a href="/board/detail?boardNo=${boardDto.boardNo}">
									${boardDto.boardTitle}
								</a>
								<c:if test="${boardDto.boardComment != 0}">
									(${boardDto.boardComment})
								</c:if>
							</td>
							<td>${boardDto.boardWriter}</td>
							<td>${boardDto.boardDateAuto}</td>
							<td>${boardDto.boardLike}</td>
							<td>${boardDto.boardView}</td>
							<c:if test="${sessionScope.memberLevel == 'admin'}">
								<td>
									<a href="/board/delete?boardNo=${boardDto.boardNo}">삭제</a> | 
									<a href="/board/edit?boardNo=${boardDto.boardNo}">수정</a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
					<c:forEach var="boardDto" items="${list}">
						<tr>
							<td>${boardDto.boardNo}</td>
							<td align="left">
							
								<c:forEach var="i" begin="1" end="${boardDto.boardDepth}">
									&nbsp;&nbsp;
								</c:forEach>
								<c:if test="${boardDto.boardDepth > 0}">
									ㄴ
								</c:if>
								<a href="/board/detail?boardNo=${boardDto.boardNo}">
									<c:if test="${boardDto.boardCategory != null}">
										[${boardDto.boardCategory}]
									</c:if>
										${boardDto.boardTitle}
									<c:if test="${boardDto.boardComment != 0}">
										(${boardDto.boardComment})
									</c:if>
								</a>
							</td>
							<td>${boardDto.boardWriter}</td>
							<td>${boardDto.boardDateAuto}</td>
							<td>${boardDto.boardLike}</td>
							<td>${boardDto.boardView}</td>
							<c:if test="${sessionScope.memberLevel == 'admin'}">
								<td>
									<a href="/board/delete?boardNo=${boardDto.boardNo}">삭제</a>
									<c:if test="${boardDto.boardWriter == sessionScope.memberID}">
										 | <a href="/board/edit?boardNo=${boardDto.boardNo}">수정</a>
									</c:if>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	
	<br><br>
	
	<a href="/board/post">글쓰기</a>
	<a href="/board/list">전체목록</a>
	<a href="/">메인으로</a>
	
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
	
	<form action="list" method="get">
		<c:choose>
			<c:when test="${vo.column == 'board_category'}">
				<select name="column">
					<option value="board_title">제목</option>
					<option value="board_content">내용</option>
					<option value="board_writer">작성자</option>
					<option value="board_category" selected>카테고리</option>
				</select>
			</c:when>
			<c:when test="${vo.column == 'board_writer'}">
				<select name="column">
					<option value="board_title">제목</option>
					<option value="board_content">내용</option>
					<option value="board_writer" selected>작성자</option>
					<option value="board_category">카테고리</option>
				</select>
			</c:when>
			<c:when test="${vo.column == 'board_content'}">
				<select name="column">
					<option value="board_title">제목</option>
					<option value="board_content" selected>내용</option>
					<option value="board_writer">작성자</option>
					<option value="board_category">카테고리</option>
				</select>
			</c:when>
			<c:otherwise>
				<select name="column">
					<option value="board_title" selected>제목</option>
					<option value="board_content">내용</option>
					<option value="board_writer">작성자</option>
					<option value="board_category">카테고리</option>
				</select>
			</c:otherwise>
		</c:choose>
		<input type="text" name="keyword" required placeholder="검색어" value="${vo.keyword}">
		<button>검색</button>
	</form>
	
	<br><br>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
